package com.proretention.user.registration.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.proretention.user.registration.controller.UserRegsitrationController;
import com.proretention.user.registration.dto.UserRegistrationDto;
import com.proretention.user.registration.entity.UserEntity;
import com.proretention.user.registration.exception.ResourceNotFound;
import com.proretention.user.registration.repository.UserRepository;
import com.proretention.user.registration.request.UserRequest;
import com.proretention.user.registration.request.UserRoleRequest;
import com.proretention.user.registration.request.UserSensitiveRequest;
import com.proretention.user.registration.request.UserTenantRequest;
import com.proretention.user.registration.response.UserCreationResponse;
import com.proretention.user.registration.response.UserRoleResponse;
import com.proretention.user.registration.response.UserSensitiveResponse;
import com.proretention.user.registration.response.UserTenantResponse;
import com.proretention.user.registration.service.UserRegistrationService;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	Logger logger = LogManager.getLogger(UserRegsitrationController.class);

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public RestTemplate restTemplate;

	@Override
	public UserRegistrationDto createUser(UserRegistrationDto userRegistrationDto) {

		try {

			if (userRegistrationDto.getDesignation().isEmpty()
					|| userRegistrationDto.getDomain().isEmpty() || userRegistrationDto.getFirstName().isEmpty()
					|| userRegistrationDto.getLastName().isEmpty() || userRegistrationDto.getOrganization().isEmpty()
					|| userRegistrationDto.getEmail().isEmpty() || userRegistrationDto.getPhone().isEmpty())
				throw new ResourceNotFound("please give proper input because there is some filed null");
		} catch (ResourceNotFound rs) {
			throw new ResourceNotFound("please give proper input because there is some filed null");
		} catch (Exception e) {
			throw new ResourceNotFound("some thing wrong in service");
		}
		if (RequestContextHolder.getRequestAttributes() == null) {
			return null;
		}
//
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//
//		String jwtString = request.getHeader("Authorization");
//		System.out.println("Access Token : "+jwtString);
//		
//		String accessVerify = restTemplate.postForObject("http://localhost:9002/access/verify",jwtString,String.class);
//		System.out.println("Access Verification Completed : "+accessVerify);
//		
//		if (accessVerify.equals("Authorized")) {
//			
		
		logger.info("Tenant creation started");
		UserTenantRequest userTenantRequest = new UserTenantRequest();
		BeanUtils.copyProperties(userRegistrationDto, userTenantRequest);
		UserTenantResponse userTenantCreated = restTemplate.postForObject("http://localhost:9005/user/tenant/",
				userTenantRequest, UserTenantResponse.class);
		BeanUtils.copyProperties(userTenantCreated, userRegistrationDto);
		logger.info("Tenant dreation completed");

		logger.info("User details creation started");
		UserRequest userRequest = new UserRequest();
		BeanUtils.copyProperties(userRegistrationDto, userRequest);
		UserCreationResponse userCreated = restTemplate.postForObject("http://localhost:9003/user/", userRequest,
				UserCreationResponse.class);
		BeanUtils.copyProperties(userCreated, userRegistrationDto);
		logger.info("User details creation completed");

		
		UserSensitiveRequest userSensitiveRequest = new UserSensitiveRequest();
		BeanUtils.copyProperties(userRegistrationDto, userSensitiveRequest);
		UserSensitiveResponse userSensitiveCreated = restTemplate.postForObject("http://localhost:9004/user/sensitive/",
				userSensitiveRequest, UserSensitiveResponse.class);
		BeanUtils.copyProperties(userSensitiveCreated, userRegistrationDto);


		UserRoleRequest userRoleRequest = new UserRoleRequest();
		BeanUtils.copyProperties(userRegistrationDto, userRoleRequest);

		userRoleRequest.setUserRole("admin");

		System.out.println("User Role Details : " + userRoleRequest);
		UserRoleResponse userRoleCreated = restTemplate.postForObject("http://localhost:9006/user/role/",
				userRoleRequest, UserRoleResponse.class);
		System.out.println("UserRole Created : " + userRoleCreated);

		BeanUtils.copyProperties(userRoleCreated, userRegistrationDto);

		return userRegistrationDto;
//		}
//		else
//		{
//			System.out.println("UnAuthorised");
//			return null;
//		}

	}

	@Override
	public UserRegistrationDto getByUserKey(String userKey) {
		UserRegistrationDto dto = new UserRegistrationDto();
		UserEntity retrive = userRepository.getByUserKey(userKey);
		BeanUtils.copyProperties(retrive, dto);

		return dto;
	}

	@Override
	public UserRegistrationDto updateUser(String userKey, UserRegistrationDto userDetails) {
		UserRegistrationDto dto = new UserRegistrationDto();

		UserEntity userEntity = userRepository.getByUserKey(userKey);
		userEntity.setFirstName(userDetails.getFirstName());
		userEntity.setLastName(userDetails.getLastName());
		userEntity.setOrganization(userDetails.getOrganization());
		userEntity.setDesignation(userDetails.getDesignation());
		userEntity.setDomain(userDetails.getDomain());
		UserEntity updatedUser = userRepository.save(userEntity);
		BeanUtils.copyProperties(updatedUser, dto);

		return dto;
	}

	@Override
	public void deleteUser(String userKey) {
		UserEntity user = userRepository.getByUserKey(userKey);
		userRepository.delete(user);

	}

	@Override
	public List<UserRegistrationDto> getUsers(int page, int limit) {
		List<UserRegistrationDto> retVal = new ArrayList<>();

		if (page > 0) {
			page = page - 1;
		}

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<UserEntity> usersPage = userRepository.findAll(pageableRequest);

		List<UserEntity> users = usersPage.getContent();

		for (UserEntity userEntity : users) {
			UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
			BeanUtils.copyProperties(userEntity, userRegistrationDto);
			retVal.add(userRegistrationDto);
		}
		return retVal;
	}

}
