package com.proretention.user.registration.response;



import io.swagger.annotations.ApiModel;
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
@ApiModel(value = "UserResponse", description = "User nonsensitive response")

public class UserResponse {
	
	private String userKey;
	private String firstName;
	private String lastName;
	private String domain;
	private String organization;
	private String designation;
	
	
}
