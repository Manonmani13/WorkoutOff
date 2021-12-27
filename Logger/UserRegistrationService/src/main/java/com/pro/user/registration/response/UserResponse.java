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
public class UserResponse {
	
	private String userKey;
	private String firstName;
	private String lastName;
	private String domain;
	private String organization;
	private String designation;
	
	
}
