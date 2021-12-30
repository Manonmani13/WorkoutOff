package com.proretention.user.registration.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.proretention.user.registration.dto.UserRegistrationDto;
import com.proretention.user.registration.request.UserRegistrationRequest;
import com.proretention.user.registration.response.UserCreationResponse;
import com.proretention.user.registration.service.UserRegistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/user-registration")
@Api(value="User Registration Gateway", description="This API acts as gateway,get the user details and forward them to other microservices to complete user regsitration")
public class UserRegsitrationController {
	Logger logger = LogManager.getLogger(UserRegsitrationController.class);

	@Autowired
	UserRegistrationService userRegistrationService;
	
	@PostMapping("/create")
	@ApiOperation(value="Details about User Registration",notes="give your details to save",
			response=UserRegistrationDto.class)
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "User registered successfully"),
	            @ApiResponse(code = 401, message = "Unauthenticated access"), 
	            @ApiResponse(code = 403, message = "Access denied"),
	            @ApiResponse(code = 404, message = "Not found!!!"),
	            @ApiResponse(code = 500, message = "internal server error!!!"),
	            @ApiResponse(code = 503, message = "Requested service unavailable!!!")
	            })
	public UserRegistrationDto createUser(@RequestBody UserRegistrationRequest userRegistrationRequest)
	{
		logger.info("User Registration  saving Process Started");
		UserRegistrationDto userRegistrationDto=new UserRegistrationDto();
		BeanUtils.copyProperties(userRegistrationRequest,userRegistrationDto);
		
		UserRegistrationDto saveUserDto= userRegistrationService.createUser(userRegistrationDto);
		
		UserCreationResponse response = new UserCreationResponse();
		BeanUtils.copyProperties(saveUserDto, response);
		logger.info("User Registration  saving Process Completed");
		return saveUserDto;
	}
	
	
}
