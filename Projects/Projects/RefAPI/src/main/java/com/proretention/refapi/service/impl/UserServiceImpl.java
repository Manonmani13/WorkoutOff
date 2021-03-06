package com.proretention.refapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proretention.refapi.io.entity.UserEntity;
import com.proretention.refapi.repository.UserRepository;
import com.proretention.refapi.service.UserService;
import com.proretention.refapi.ui.shared.Utils;
import com.proretention.refapi.ui.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	Utils utils;
	
	@Autowired
	UserRepository userRepository;

	
	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		String publicUserId = "abc"+userEntity.getFirstName();
		userEntity.setUserId(publicUserId);
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto retVal = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, retVal);
		
		return retVal;
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		
		UserDto retVal = new UserDto();
		
		UserEntity userEntity = userRepository.findByUserId(userId);
		BeanUtils.copyProperties(userEntity, retVal);
		
		return retVal;
	}

	@Override
	public UserDto updateUser(String userId, UserDto userDto) {

		UserDto retVal = new UserDto();
		
		UserEntity userEntity = userRepository.findByUserId(userId);
		userEntity.setFirstName(userDto.getFirstName());
		userEntity.setLastName(userDto.getLastName());
		userEntity.setEmail(userDto.getEmail());
		
		UserEntity updatedUserDetail = userRepository.save(userEntity);
		BeanUtils.copyProperties(updatedUserDetail, retVal);
		
		return retVal;
	}

	@Override
	public void deleteUser(String userId) {
		
		UserEntity userEntity = userRepository.findByUserId(userId);
		userRepository.delete(userEntity);
	}

	
	@Override
	public List<UserDto> getUsers(int page, int limit) {
		List<UserDto> retVal = new ArrayList<>();
		
		if(page>0) {
			page = page-1;
		}
	
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<UserEntity> usersPage = userRepository.findAll(pageableRequest);
		
		List<UserEntity> users =   usersPage.getContent();
		
		for(UserEntity userEntity : users) {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(userEntity, userDto);
			retVal.add(userDto);
		}
		return retVal;
	}

}
