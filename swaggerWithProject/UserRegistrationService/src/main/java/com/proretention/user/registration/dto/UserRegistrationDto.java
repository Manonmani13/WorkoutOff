package com.proretention.user.registration.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description="Details about UserRegistration")
public class UserRegistrationDto {
	@ApiModelProperty(notes="Name of the token")
	private String token;
	@ApiModelProperty(notes="Id of the tanant")
	private long tenantId;
	@ApiModelProperty(notes="Id for user")
	private long userId;
	@ApiModelProperty(notes="Key for user")
	private String userKey;
	@ApiModelProperty(notes="Role of the user")
	private String userRole;
	@ApiModelProperty(notes="Name of the domain")
	private String domain;
	@ApiModelProperty(notes="FirstName of the person")
	private String firstName;
	@ApiModelProperty(notes="LastName of the person")
	private String lastName;
	@ApiModelProperty(notes="Name of the organization")
	private String organization;
	@ApiModelProperty(notes="Name of the designation")
	private String designation;
	@ApiModelProperty(notes="Email id of the user")
	private String email;
	@ApiModelProperty(notes="Phone number of the user")
	private String phone;

	
}
