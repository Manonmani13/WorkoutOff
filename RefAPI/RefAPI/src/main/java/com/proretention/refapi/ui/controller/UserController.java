package com.proretention.refapi.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proretention.refapi.service.UserService;
import com.proretention.refapi.ui.model.request.UserDetailsRequestModel;
import com.proretention.refapi.ui.model.response.OperationStatusModel;
import com.proretention.refapi.ui.model.response.RequestOperationStatus;
import com.proretention.refapi.ui.model.response.UserRest;
import com.proretention.refapi.ui.shared.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

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

	@GetMapping
	public List<UserRest> getUsers(@RequestParam(value="page", defaultValue="1") int page, @RequestParam(value="limit", defaultValue="25") int limit) {
		List<UserRest> retVal = new ArrayList<>();
		List<UserDto> users = userService.getUsers(page,limit);
		
		for(UserDto userDto : users ) {
			UserRest userModel = new UserRest();
			BeanUtils.copyProperties(userDto, userModel);
			retVal.add(userModel);
		}
		
		return retVal;
	}
}
