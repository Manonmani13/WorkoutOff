package com.proretention.user.registration.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description="Details about UserRegistrationRequest")
public class UserRegistrationRequest {
	@ApiModelProperty(notes="Name of the token")
	private String token;
	@ApiModelProperty(notes="FirstName of the person")
	private String firstName;
	@ApiModelProperty(notes="LastName of the person")
	private String lastName;
	@ApiModelProperty(notes="Name of the domain")
	private String domain;
	@ApiModelProperty(notes="Name of the organization")
	private String organization;
	@ApiModelProperty(notes="Name of the designation")
	private String designation;
	@ApiModelProperty(notes="Email id of the user")
	private String email;
	@ApiModelProperty(notes="Phone Number of the user")
	private String phone;


}
