package com.pro.user.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.user.registration.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity getByUserKey(String userKey);
	

}
