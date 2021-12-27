package com.pro.user.registration.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pro.user.registration.dto.UserRegistrationDto;
import com.pro.user.registration.entity.UserEntity;
import com.pro.user.registration.exception.ResourceNotFound;
import com.pro.user.registration.repository.UserRepository;
import com.pro.user.registration.request.UserRequest;
import com.pro.user.registration.request.UserRoleRequest;
import com.pro.user.registration.request.UserSensitiveRequest;
import com.pro.user.registration.request.UserTenantRequest;
import com.pro.user.registration.response.UserCreationResponse;
import com.pro.user.registration.response.UserRoleResponse;
import com.pro.user.registration.response.UserSensitiveResponse;
import com.pro.user.registration.response.UserTenantResponse;
import com.pro.user.registration.service.UserRegistrationService;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
	

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public RestTemplate restTemplate;


	
	@Override
	public UserRegistrationDto createUser(UserRegistrationDto userRegistrationDto) {
		System.out.println("User Registration Started");
		System.out.println("Regsitration Req : "+userRegistrationDto);
		try
		{
	
		if(userRegistrationDto.getDesignation().isEmpty()||userRegistrationDto.getCreatedBy().isEmpty()||userRegistrationDto.getDomain().isEmpty()
				||userRegistrationDto.getFirstName().isEmpty()||userRegistrationDto.getLastName().isEmpty()||
				userRegistrationDto.getOrganization().isEmpty()||userRegistrationDto.getEmail().isEmpty()
				||userRegistrationDto.getPhone().isEmpty()||userRegistrationDto.getDesignation().isBlank()
				)
			throw new  ResourceNotFound("please give proper input because there is some filed null");
		}
		catch(ResourceNotFound rs)
		{
			throw new ResourceNotFound("please give proper input because there is some filed null");
		}
		catch(Exception e)
		{
			throw new ResourceNotFound("some thing wrong in service");
		}
		if (RequestContextHolder.getRequestAttributes() == null) {
			return null;
		}

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		String jwtString = request.getHeader("Authorization");
		System.out.println("Access Token : "+jwtString);
		
		String accessVerify = restTemplate.postForObject("http://localhost:9002/access/verify",jwtString,String.class);
		System.out.println("Access Verification Completed : "+accessVerify);
		
		if (accessVerify.equals("Authorized")) {
			
			UserRequest userRequest = new UserRequest();
			BeanUtils.copyProperties(userRegistrationDto, userRequest);
			
			System.out.println("User Details :"+userRequest);
			
			UserCreationResponse userCreated = restTemplate.postForObject("http://localhost:9003/user/",userRequest,UserCreationResponse.class);
			System.out.println("User Created : "+userCreated);
			
			BeanUtils.copyProperties(userCreated, userRegistrationDto);
			
			UserSensitiveRequest userSensitiveRequest = new UserSensitiveRequest();
			BeanUtils.copyProperties(userRegistrationDto, userSensitiveRequest);
			
			System.out.println("User Sensitive Details : "+userSensitiveRequest);
			UserSensitiveResponse userSensitiveCreated = restTemplate.postForObject("http://localhost:9004/user/sensitive/",userSensitiveRequest,UserSensitiveResponse.class);
			System.out.println("USer Sensitive Created : "+userSensitiveCreated);
			
			BeanUtils.copyProperties(userSensitiveCreated, userRegistrationDto);

			UserTenantRequest userTenantRequest = new UserTenantRequest();
			BeanUtils.copyProperties(userRegistrationDto, userTenantRequest);
			
			System.out.println("User Tenant Details : "+userTenantRequest);
			UserTenantResponse userTenantCreated = restTemplate.postForObject("http://localhost:9005/user/tenant/",userTenantRequest,UserTenantResponse.class);
			System.out.println("USerTenant Created : "+userTenantCreated);
			
			BeanUtils.copyProperties(userTenantCreated, userRegistrationDto);
			
			UserRoleRequest userRoleRequest = new UserRoleRequest();
			BeanUtils.copyProperties(userRegistrationDto, userRoleRequest);
			
			userRoleRequest.setUserRole("admin");
			
			System.out.println("User Role Details : "+userRoleRequest);
			UserRoleResponse userRoleCreated = restTemplate.postForObject("http://localhost:9006/user/role/",userRoleRequest,UserRoleResponse.class);
			System.out.println("UserRole Created : "+userRoleCreated);
			
			BeanUtils.copyProperties(userRoleCreated, userRegistrationDto);

			return userRegistrationDto;
		}
		else
		{
			System.out.println("UnAuthorised");
			return null;
		}
		
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
