package com.rit.app.ws.service.imp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.rit.app.ws.UserRepository;
import com.rit.app.ws.io.entity.UserEntity;
import com.rit.app.ws.service.UserService;
import com.rit.app.ws.ui.shared.Utils;
import com.rit.app.ws.ui.shared.dto.UserDto;

public class UserServiceImp implements UserService{
	@Autowired
	Utils utils;
	
	@Autowired
	UserRepository userRepository;
	


	@Override
	public UserDto createUser(UserDto user) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		String publicUserId = "abc";
		userEntity.setUserId(publicUserId);
		
		
		//userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setEncryptedPassword("testpwd");
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto retVal = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, retVal);
		
		return retVal;
	
	}

}
