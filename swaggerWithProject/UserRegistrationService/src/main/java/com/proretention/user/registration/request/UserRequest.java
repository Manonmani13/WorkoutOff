package com.proretention.user.registration.request;

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
public class UserRequest {
	
	private long tenantId;
	private String firstName;
	private String lastName;
	private String domain;
	private String organization;
	private String designation;

}
