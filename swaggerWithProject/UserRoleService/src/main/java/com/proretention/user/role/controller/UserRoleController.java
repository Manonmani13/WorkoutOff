package com.proretention.user.role.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.proretention.user.role.request.UserRoleRequest;
import com.proretention.user.role.response.OperationStatusModel;
import com.proretention.user.role.response.RequestOparationStatus;
import com.proretention.user.role.response.UserRoleResponse;
import com.proretention.user.role.sensitiveDto.UserRoleDto;
import com.proretention.user.role.service.UserRoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user/role")
@Api(value = "User Role Service", description = "To store and manage user role while singup")
public class UserRoleController {
	Logger logger = LogManager.getLogger(UserRoleController.class);

	@Autowired
	public UserRoleService userRoleService;

	@PostMapping("/create")
	@ApiOperation(value = "create user role details",notes="give your details to save",
			response=UserRoleResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User role created successfully"),
			@ApiResponse(code = 401, message = "Unauthenticated access"),
			@ApiResponse(code = 403, message = "Access denied"), @ApiResponse(code = 404, message = "Not found!!!"),
			@ApiResponse(code = 500, message = "internal server error!!!"),
			@ApiResponse(code = 503, message = "Requested service unavailable!!!") })
	public UserRoleResponse createRole(@RequestBody UserRoleRequest userRoleRequest) {
		logger.info("saving  user role process started ");
		UserRoleDto userRoleDto = new UserRoleDto();
		BeanUtils.copyProperties(userRoleRequest, userRoleDto);

		UserRoleResponse savedUser = userRoleService.createRole(userRoleDto);

		UserRoleResponse response = new UserRoleResponse();
		BeanUtils.copyProperties(savedUser, response);
		logger.info("saving  user role process completed ");;
		return response;

	}

	@GetMapping("/get/{id}")
	@ApiOperation(value = "Get the user role created while signup",notes="find your details by Id",
			response=UserRoleResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User role         read successfully"),
			@ApiResponse(code = 401, message = "Unauthenticated access"),
			@ApiResponse(code = 403, message = "Access denied"), @ApiResponse(code = 404, message = "Not found!!!"),
			@ApiResponse(code = 500, message = "internal server error!!!"),
			@ApiResponse(code = 503, message = "Requested service unavailable!!!") })
	public UserRoleResponse getValueById(@PathVariable("id") int id) {
		logger.info("get value by Id user role process started");

		UserRoleResponse userRoleResponse = new UserRoleResponse();

		UserRoleDto retrive = userRoleService.getRoleById(id);
		BeanUtils.copyProperties(retrive, userRoleResponse);
		logger.info("get value by Id user role process completed");
		return userRoleResponse;

	}

 	@PutMapping("/update/{id}")
	@ApiOperation(value = "update user role ",notes="update user role by Id",
			response=UserRoleResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User role updated successfully"),
			@ApiResponse(code = 401, message = "Unauthenticated access"),
			@ApiResponse(code = 403, message = "Access denied"), @ApiResponse(code = 404, message = "Not found!!!"),
			@ApiResponse(code = 500, message = "internal server error!!!"),
			@ApiResponse(code = 503, message = "Requested service unavailable!!!") })
	public UserRoleResponse updateEmail(@PathVariable("id") int id, @RequestBody UserRoleRequest userRoleRequest) {
		logger.info("update user role process started");
		UserRoleResponse userRoleResponse = new UserRoleResponse();

		UserRoleDto dto = new UserRoleDto();

		BeanUtils.copyProperties(userRoleRequest, dto);

		UserRoleDto emailDto = userRoleService.updateRole(id, dto);
		BeanUtils.copyProperties(emailDto, userRoleResponse);
		logger.info("update user role process completed");
		return userRoleResponse;

	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Delete user role",notes="delete user role by Id",
			response=UserRoleResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User role deleted successfully"),
			@ApiResponse(code = 401, message = "Unauthenticated access"),
			@ApiResponse(code = 403, message = "Access denied"), @ApiResponse(code = 404, message = "Not found!!!"),
			@ApiResponse(code = 500, message = "internal server error!!!"),
			@ApiResponse(code = 503, message = "Requested service unavailable!!!") })
	public OperationStatusModel deleteUser(@PathVariable("id") int id) {
		logger.info("delete user by Id process started");
		OperationStatusModel status = new OperationStatusModel();
		status.setOperationName(RequestOparationStatus.delete.name());
		userRoleService.deleteRole(id);
		status.setOperationResult(RequestOparationStatus.success.name());
		logger.info("delete user by Id process completed");
		return status;
	}

}
