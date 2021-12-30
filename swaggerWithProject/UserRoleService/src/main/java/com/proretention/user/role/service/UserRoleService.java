package com.proretention.user.role.service;

import com.proretention.user.role.response.UserRoleResponse;
import com.proretention.user.role.sensitiveDto.UserRoleDto;

public interface UserRoleService {
	UserRoleDto getRoleById(int id);

	UserRoleDto updateRole(int id, UserRoleDto dto);

	void deleteRole(int id);

	UserRoleResponse createRole(UserRoleDto userRoleDto);


}
