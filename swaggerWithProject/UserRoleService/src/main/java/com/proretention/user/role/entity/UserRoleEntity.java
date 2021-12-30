package com.proretention.user.role.entity;

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
	private long roleId;
	private long tenantId;
	private long userId;
	private String userRole;
	
	
}
