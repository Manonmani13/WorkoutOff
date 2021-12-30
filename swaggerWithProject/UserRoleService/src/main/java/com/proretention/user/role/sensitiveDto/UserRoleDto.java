package com.proretention.user.role.sensitiveDto;

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
	
	private long roleId;
	private long tenantId;
	private long userId;
	private String userRole;
	
	
	
}
