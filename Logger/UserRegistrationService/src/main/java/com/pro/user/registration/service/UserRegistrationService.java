package com.pro.user.registration.service;

import java.util.List;

import com.pro.user.registration.dto.UserRegistrationDto;

public interface UserRegistrationService {

	UserRegistrationDto createUser(UserRegistrationDto userRegistrationDto);

	UserRegistrationDto getByUserKey(String userKey);
	
	UserRegistrationDto updateUser(String userKey, UserRegistrationDto dto);

	void deleteUser(String userKey);

	List<UserRegistrationDto> getUsers(int page, int limit);

}