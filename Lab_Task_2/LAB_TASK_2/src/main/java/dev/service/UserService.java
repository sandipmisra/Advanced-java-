package dev.service;

import dev.domain.User;
import dev.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        user.setFullname(user.getFullname().toUpperCase());
        userRepository.create(user);
    }
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public User getUserById(int userId) {
        return userRepository.get(userId);
    }

    public void updateUser(User user) {
        userRepository.edit(user);
    }

    public void deleteUserById(int userId) {
        userRepository.delete(userId);
    }

    public User get(int id) {
        return userRepository.get(id);
    }

    public void delete(int id) {
        userRepository.delete(id);
    }

    public int getUsersCount() {
        List<User> allUsers = userRepository.getAll();
        return allUsers.size();
    }




}
