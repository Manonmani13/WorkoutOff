package com.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.workout.Repository.UserRepository;
import com.workout.model.UserInfo;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
@PostMapping("/addingUserDetails")
public UserInfo saveUser(@RequestBody UserInfo user)
{
	return userRepository.save(user);
}
}
