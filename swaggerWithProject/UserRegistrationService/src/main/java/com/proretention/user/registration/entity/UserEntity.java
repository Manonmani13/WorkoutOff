package com.proretention.user.registration.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
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
import lombok.ToString;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class UserEntity {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long userId;
private long tenantId;
private String userKey;
private String firstName;
private String lastName;
private String organization;
private String designation;
private String domain;
private String createdBy;
private String updatedBy;

@Column(name="createdAt")
private final  LocalDateTime createdAt = LocalDateTime.now(); 

@Column(name="updatedAt")
private final  LocalDateTime updatedAt= LocalDateTime.now();


}

