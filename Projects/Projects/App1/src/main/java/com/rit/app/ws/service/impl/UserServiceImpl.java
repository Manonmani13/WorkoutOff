package com.rit.app.ws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rit.app.ws.UserRepository;
import com.rit.app.ws.io.entity.UserEntity;
import com.rit.app.ws.service.UserService;
import com.rit.app.ws.ui.shared.Utils;
import com.rit.app.ws.ui.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	Utils utils;
	
	@Autowired
	UserRepository userRepository;
	
	//@Autowired
	//BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		//String publicUserId = "abc";
		//userEntity.setUserId(publicUserId);
		
		
		//userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setEncryptedPassword("testpwd");
		
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
		
		
		// TODO Auto-generated method stub
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

}
