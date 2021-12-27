package com.pro.user.sensitive.controller;

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

import com.pro.user.sensitive.request.UserSensitiveRequest;
import com.pro.user.sensitive.response.OperationStatusModel;
import com.pro.user.sensitive.response.RequestOparationStatus;
import com.pro.user.sensitive.response.UserSensitiveResponse;
import com.pro.user.sensitive.sensitiveDto.UserSensitiveDto;
import com.pro.user.sensitive.service.UserSensitiveService;

@RestController
@RequestMapping("/user/sensitive")
public class UserSensitiveController {
	Logger logger = LogManager.getLogger(UserSensitiveController.class);

	@Autowired
	public UserSensitiveService userSensitiveService;

	@PostMapping("/")
	public UserSensitiveResponse saveSensitive(@RequestBody UserSensitiveRequest userSensitiveRequest) {
		logger.info("savesenessitive api");
		UserSensitiveResponse userSensitiveResponse = userSensitiveService.saveSensitive(userSensitiveRequest);
		logger.info("savesenessitive api");
		return userSensitiveResponse;
	}
	
	 @GetMapping("/{id}")
	 public UserSensitiveResponse getValueById(@PathVariable("id") int id)
	 {
			logger.info("get value By Id senessitive api");
		 UserSensitiveResponse userSensitiveResponse =new UserSensitiveResponse();
		
		 UserSensitiveDto retrive =userSensitiveService.getvalueById(id);
		 BeanUtils.copyProperties(retrive, userSensitiveResponse);
			logger.info("get value By Id senessitive api");
		 return userSensitiveResponse;
		 
	 }
	 @PutMapping("/{id}")
	 public UserSensitiveResponse updateSensitiveDetails(@PathVariable("id") int id,@RequestBody UserSensitiveRequest userSensitiveRequest)
	 {
			logger.info("update value By Id senessitive api");
		 UserSensitiveResponse userSensitiveResponse =new UserSensitiveResponse();
		 
		 UserSensitiveDto dto =new UserSensitiveDto();
		 
		BeanUtils.copyProperties(userSensitiveRequest, dto);
		
		UserSensitiveDto emailDto=userSensitiveService.updateValue(id,dto);
		BeanUtils.copyProperties(emailDto, userSensitiveResponse);
		logger.info("update value By Id senessitive api");
		return userSensitiveResponse;
		 
	 }
	 @DeleteMapping("/{id}")
	 public OperationStatusModel deleteUser(@PathVariable("id") int id)
	 {
		 logger.info("Delete By User senessitive api");
		OperationStatusModel status=new OperationStatusModel();
		status.setOperationName(RequestOparationStatus.delete.name());
		userSensitiveService.deleteValue(id);
		status.setOperationResult(RequestOparationStatus.success.name());
		 logger.info("Delete By User senessitive api");
		return status;
	 } 
	 
	
	 


}
