package com.vishnu.online_banking_system.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.vishnu.online_banking_system.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.vishnu.online_banking_system.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vishnu.online_banking_system.security.JwtUtil;


@RestController
public class UserController {
    // APIs will come here
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public String createUser(@RequestBody User user) {
	    userService.saveUser(user);
	    return "User created successfully";
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
	    return userService.getAllUsers();
	}

	@PostMapping("/login")
	public String login(@RequestParam String email,
	                    @RequestParam String password) {

	    boolean success = userService.login(email, password);

	    if (success) {
	        return JwtUtil.generateToken(email);
	    } else {
	        return "Invalid email or password";
	    }
	}



}
