package com.pro.user.registration.response;



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
public class UserRoleResponse {

	private int id;
	private long userId;
	private String userRole;
	
	

	
}