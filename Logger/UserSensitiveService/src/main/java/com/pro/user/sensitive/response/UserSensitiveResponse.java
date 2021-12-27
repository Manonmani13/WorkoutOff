package com.pro.user.sensitive.response;

import com.pro.user.sensitive.request.UserSensitiveRequest;

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
public class UserSensitiveResponse {

	private long userId;
	private String phone;
	private String email;
	
}
