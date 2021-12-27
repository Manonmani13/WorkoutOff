package com.pro.user.sensitive.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
public class UserSensitiveEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private long userId;
	private String name;
	private String value;
	
	
	

}
