package com.pro.user.sensitive.request;


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
public class UserSensitiveRequest {

	private long userId;
	private String phone;
	private String email;
	

}
