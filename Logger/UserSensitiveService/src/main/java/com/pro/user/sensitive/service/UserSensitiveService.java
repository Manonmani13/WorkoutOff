package com.pro.user.sensitive.service;

import com.pro.user.sensitive.request.UserSensitiveRequest;
import com.pro.user.sensitive.response.UserSensitiveResponse;
import com.pro.user.sensitive.sensitiveDto.UserSensitiveDto;

public interface UserSensitiveService {
	UserSensitiveDto getvalueById(int id);

	UserSensitiveDto updateValue(int id, UserSensitiveDto dto);

	void deleteValue(int id);

	UserSensitiveResponse saveSensitive(UserSensitiveRequest userSensitiveRequest);


}
