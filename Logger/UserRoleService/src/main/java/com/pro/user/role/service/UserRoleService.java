package com.pro.user.role.service;

import com.pro.user.role.response.UserRoleResponse;
import com.pro.user.role.sensitiveDto.UserRoleDto;

public interface UserRoleService {
	UserRoleDto getRoleById(int id);

	UserRoleDto updateRole(int id, UserRoleDto dto);

	void deleteRole(int id);

	UserRoleResponse createRole(UserRoleDto userRoleDto);


}
