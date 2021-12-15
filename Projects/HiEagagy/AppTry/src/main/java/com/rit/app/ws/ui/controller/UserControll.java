package com.rit.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rit.app.ws.service.UserService;
import com.rit.app.ws.ui.model.request.UserDetailsRequestModel;
import com.rit.app.ws.ui.model.response.UserRest;
import com.rit.app.ws.ui.shared.dto.UserDto;

@RestController
@RequestMapping("users")
public class UserControll {

	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser() {
		return "GetUser";
	}
	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		
		UserRest retVal = new UserRest();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, retVal);
		
		return retVal;
	}
	@PutMapping
	public String updateUser() {
		return "UpdateUser";
	}
	@DeleteMapping
	public String deleteUser() {
		return "DeleteUser";
	}

}
