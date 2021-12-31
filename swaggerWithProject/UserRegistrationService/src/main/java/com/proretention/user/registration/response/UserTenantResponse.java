package com.proretention.user.registration.response;


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
public class UserTenantResponse {

	private int tenantid;
	private long userId;
	private String tenantKey;
	private String status;
	


}