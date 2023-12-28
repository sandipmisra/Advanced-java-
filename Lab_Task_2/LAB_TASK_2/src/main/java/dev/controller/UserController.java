package dev.controller;

import dev.domain.User;
import dev.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void intiBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/create")
    public String fourth(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping("/store")
    public String fifth(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                        @RequestParam(value = "quotaCheckbox", required = false) String quotaCheckbox) {
        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            // Set the value of quota based on the checkbox state
            user.setQuota(quotaCheckbox != null ? "Yes" : "No");

            userService.create(user);
            return "confirm";
        }
    }

    @RequestMapping("/students")
    public String listUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);

        System.out.println("Number of users: " + userList.size());
        System.out.println(userList);

        return "userList";
    }

    @RequestMapping("/students/{userId}")
    public String showUser(@PathVariable int userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "userDetails";
    }



    @GetMapping("/students/{userId}/edit")
    public String editUser(@PathVariable int userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/students/{userId}/update")
    public String updateUser(
            @PathVariable int userId,
            @Valid @ModelAttribute("user") User updatedUser,
            BindingResult bindingResult,
            @RequestParam(value = "quotaCheckbox", required = false) String quotaCheckbox,
            @RequestParam("country") String country,  // Add this line to get the value of the country parameter
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            return "editUser";
        } else {
            // Set the value of quota based on the checkbox state
            updatedUser.setQuota(quotaCheckbox != null ? "Yes" : "No");

            // Set the value of the "Country" field
            updatedUser.setCountry(country);

            updatedUser.setId(userId);
            userService.updateUser(updatedUser);

            // Add the message as a flash attribute
            redirectAttributes.addFlashAttribute("message", "Student INFO of ID " + userId + " has been updated.");

            return "confirmation";
        }
    }



    @RequestMapping("/students/{userId}/delete")
    public String deleteUser(@PathVariable int userId, Model model) {
        userService.deleteUserById(userId);
        String message = "User with ID " + userId + " has been deleted.";
        model.addAttribute("message", message);
        return "deleteUser";
    }

}
