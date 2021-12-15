package com.proretention.refapi.service;

import java.util.List;

import com.proretention.refapi.ui.shared.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto getUserByUserId(String id);

	UserDto updateUser(String id, UserDto userDto);
	
	void deleteUser(String userId);

	List<UserDto> getUsers(int page, int limit);
}
