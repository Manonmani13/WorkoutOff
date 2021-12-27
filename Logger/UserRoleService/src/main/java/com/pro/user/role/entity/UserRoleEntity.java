package com.pro.user.role.entity;

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
@Builder
@AllArgsConstructor
@Entity(name="user_role")
public class UserRoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private long userId;
	private String userRole;
	
	
}
