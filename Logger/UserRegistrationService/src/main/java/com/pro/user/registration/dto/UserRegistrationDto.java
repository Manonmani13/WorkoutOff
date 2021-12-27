package com.pro.user.registration.dto;

import java.time.LocalDateTime;



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
public class UserRegistrationDto {

	private long userId;
	private String userKey;
	private String tenantKey;
	private String userRole;
	private String domain;
	private String firstName;
	private String lastName;
	private String organization;
	private String designation;
	private String email;
	private String phone;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String createdBy = "ADMIN";
	private String updatedBy = "ADMINS";

	
}
