package com.yash.user.controller;

import com.yash.user.domain.User;
import com.yash.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    String testHello() {
        log.info("testHello");
        return "Hello I Am In User Controller";
    }
    @GetMapping("/all")
    ResponseEntity<List<User>> findAll() {
        log.info("Fetch All User");
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{userId}")
    ResponseEntity<User> findById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PostMapping("/save")
    ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping("/update")
    ResponseEntity<User> updateTask(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/{userId}")
    ResponseEntity<Boolean> deleteTask(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }
}
