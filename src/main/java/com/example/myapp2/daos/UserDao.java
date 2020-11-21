package com.example.myapp2.daos;

import com.example.myapp2.models.User;
import com.example.myapp2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDao {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/findAllUsers")
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/findUserById/{id}")
    public User findUserById(
            @PathVariable("id") Integer id) {
        return userRepository.findById(id).get();
    }
    @GetMapping("/deleteUser/{id}")
    public void deleteUser(
            @PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }
    @GetMapping("/createUser")
    public User createUser() {
        User user = new User();
        user.setUsername("new_username");
        userRepository.save(user);
        return user;
    }
    @GetMapping("/renameUser/{id}/{newUsername}")
    public User renameUser(
            @PathVariable("id") Integer id,
            @PathVariable("newUsername") String newUsername) {
        User user = userRepository.findById(id).get();
        user.setUsername(newUsername);
        return userRepository.save(user);
    }

    @GetMapping("/updateUserPassword/{userId}/{newPassword}")
    public User updateUserPassword(
            @PathVariable("userId") Integer userId,
            @PathVariable("newPassword") String newPassword) {
        User user = userRepository.findById(userId).get();
        user.setPassword(newPassword);
        userRepository.save(user);
        return user;
    }
}
