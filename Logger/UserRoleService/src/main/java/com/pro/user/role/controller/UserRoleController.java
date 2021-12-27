package com.pro.user.role.controller;

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

import com.pro.user.role.request.UserRoleRequest;
import com.pro.user.role.response.OperationStatusModel;
import com.pro.user.role.response.RequestOparationStatus;
import com.pro.user.role.response.UserRoleResponse;
import com.pro.user.role.sensitiveDto.UserRoleDto;
import com.pro.user.role.service.UserRoleService;

@RestController
@RequestMapping("/user/role")
public class UserRoleController {
	Logger logger = LogManager.getLogger(UserRoleController.class);

	@Autowired
	public UserRoleService userRoleService;

	@PostMapping("/")
	public UserRoleResponse createRole(@RequestBody UserRoleRequest userRoleRequest) {
		logger.info("save user role api");
		UserRoleDto userRoleDto=new UserRoleDto();
		BeanUtils.copyProperties(userRoleRequest,userRoleDto);
		
		UserRoleResponse savedUser = userRoleService.createRole(userRoleDto);
		
		UserRoleResponse response = new UserRoleResponse();
		BeanUtils.copyProperties(savedUser, response);
		logger.info("save user role api");
		return response;

	}
	
	 @GetMapping("/{id}")
	 public UserRoleResponse getValueById(@PathVariable("id") int id)
	 {
			logger.info("get value by Id user role api");

		 UserRoleResponse userRoleResponse =new UserRoleResponse();
		
		 UserRoleDto retrive =userRoleService.getRoleById(id);
		 BeanUtils.copyProperties(retrive, userRoleResponse);
		 logger.info("get value by Id user role api");
		 return userRoleResponse;
		 
	 }
	 @PutMapping("/{id}")
	 public UserRoleResponse updateEmail(@PathVariable("id") int id,@RequestBody UserRoleRequest userRoleRequest)
	 {
		 logger.info("update user role api");
		 UserRoleResponse userRoleResponse =new UserRoleResponse();
		 
		 UserRoleDto dto =new UserRoleDto();
		 
		BeanUtils.copyProperties(userRoleRequest, dto);
		
		UserRoleDto emailDto=userRoleService.updateRole(id,dto);
		BeanUtils.copyProperties(emailDto, userRoleResponse);
		logger.info("update user role api");
		return userRoleResponse;
		 
	 }
	 @DeleteMapping("/{id}")
	 public OperationStatusModel deleteUser(@PathVariable("id") int id)
	 {
		 logger.info("delete user by Id user role api");
		OperationStatusModel status=new OperationStatusModel();
		status.setOperationName(RequestOparationStatus.delete.name());
		userRoleService.deleteRole(id);
		status.setOperationResult(RequestOparationStatus.success.name());
		logger.info("delete user by Id user role api");
		return status;
	 } 
	 
	
	 


}
