package com.pro.user.role.sensitiveDto;

import com.pro.user.role.request.UserRoleRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDto {
	private int id;
	private long userId;
	private String userRole;
	
	
	
}
