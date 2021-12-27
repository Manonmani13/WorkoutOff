package com.pro.user.sensitive.sensitiveDto;



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
public class UserSensitiveDto {
	private int id;
	private long userId;
	private String name;
	private String value;
	
	

}
