package com.vishnu.online_banking_system.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.vishnu.online_banking_system.repository.UserRepository;
import com.vishnu.online_banking_system.entity.User;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
    // business logic will come here
	@Autowired
	private UserRepository userRepository;

	public void saveUser(User user) {
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    userRepository.save(user);
	}

	public List<User> getAllUsers() {
	    return userRepository.findAll();
	}
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public boolean login(String email, String password) {

	    Optional<User> optionalUser = userRepository.findByEmail(email);

	    if (optionalUser.isEmpty()) {
	        return false;
	    }

	    User user = optionalUser.get();

	    return passwordEncoder.matches(password, user.getPassword());
	}


}
