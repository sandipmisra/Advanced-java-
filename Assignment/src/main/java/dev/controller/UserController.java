package dev.controller;

import dev.repository.IncomeBreakDown;
import dev.repository.TaxCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class UserController {



    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }



    @GetMapping("/taxcalculator")
    public String showTaxCalculatorForm(HttpSession session) {
        // Check if the session attribute is present

        return "taxcalculator";
    }

    @PostMapping("/calculateTax")
    public String calculateTax(@RequestParam String category, @RequestParam double totalIncome,
                               HttpSession session, Model model) {


        // Create IncomeBreakDown object
        IncomeBreakDown incomeBreakDown = new IncomeBreakDown(totalIncome, 0, 0, 0, 0, 0);

        // Calculate breakdown
        incomeBreakDown.calculateBreakDown();

        // Get the breakdown values
        double basicPay = incomeBreakDown.getBasicPay();
        double houseRent = incomeBreakDown.getHouseRent();
        double medicalAllowance = incomeBreakDown.getMedicalAllowance();
        double conveyanceAllowance = incomeBreakDown.getConveyanceAllowance();
        double bonus = incomeBreakDown.getBonus();

        // Create TaxCalculator object
        TaxCalculator taxCalculator = new TaxCalculator(totalIncome, category);

        // Calculate tax
        double calculatedTax = taxCalculator.calculateTax();

        // Add attributes to the model
        model.addAttribute("category", category);
        model.addAttribute("totalIncome", totalIncome);
        model.addAttribute("calculatedTax", calculatedTax);
        model.addAttribute("basicPay", basicPay);
        model.addAttribute("houseRent", houseRent);
        model.addAttribute("medicalAllowance", medicalAllowance);
        model.addAttribute("conveyanceAllowance", conveyanceAllowance);
        model.addAttribute("bonus", bonus);

        // Return the view name
        return "taxresult";
    }
}

