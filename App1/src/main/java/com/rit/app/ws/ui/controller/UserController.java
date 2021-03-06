package com.rit.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rit.app.ws.service.UserService;
import com.rit.app.ws.ui.model.request.UserDetailsRequestModel;
import com.rit.app.ws.ui.model.response.OperationStatusModel;
import com.rit.app.ws.ui.model.response.RequestOperationStatus;
import com.rit.app.ws.ui.model.response.UserRest;
import com.rit.app.ws.ui.shared.dto.UserDto;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/{id}")
	public UserRest getUser(@PathVariable String id) {
		UserRest retVal = new UserRest();

		UserDto userDto = userService.getUserByUserId(id);
		BeanUtils.copyProperties(userDto, retVal);
		return retVal;
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

	@PutMapping(path="/{id}")
	public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModel userDetails) {
		
		UserRest retVal = new UserRest();

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);

		UserDto updatedUser = userService.updateUser(id, userDto);
		BeanUtils.copyProperties(updatedUser, retVal);

		return retVal;
	}

	@DeleteMapping(path="/{id}")
	public OperationStatusModel deleteUser(@PathVariable String id) {
		
		OperationStatusModel retVal = new OperationStatusModel();
		retVal.setOperationName(RequestOperationName.DELETE.name());
		
		userService.deleteUser(id);
		
		retVal.setOperationResult(RequestOperationStatus.Success.name());
		return retVal;
	}
}
