package com.pro.user.registration.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.user.registration.dto.UserRegistrationDto;
import com.pro.user.registration.request.UserRegistrationRequest;
import com.pro.user.registration.response.UserCreationResponse;
import com.pro.user.registration.service.UserRegistrationService;


@RestController
@RequestMapping("/user-registration")
public class UserRegsitrationController {
	Logger logger = LogManager.getLogger(UserRegsitrationController.class);

	@Autowired
	UserRegistrationService userRegistrationService;
	
	@PostMapping("/")
	public UserRegistrationDto createUser(@RequestBody UserRegistrationRequest userRegistrationRequest)
	{
		logger.info("save user registration details api");
		UserRegistrationDto userRegistrationDto=new UserRegistrationDto();
		BeanUtils.copyProperties(userRegistrationRequest,userRegistrationDto);
		
		UserRegistrationDto saveUserDto= userRegistrationService.createUser(userRegistrationDto);
		
		UserCreationResponse response = new UserCreationResponse();
		BeanUtils.copyProperties(saveUserDto, response);
		logger.info("save user registration details api");
		return saveUserDto;
	}
	
	
}
