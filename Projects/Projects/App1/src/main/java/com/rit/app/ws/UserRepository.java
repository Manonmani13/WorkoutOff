package com.rit.app.ws;

import org.springframework.data.repository.CrudRepository;

import com.rit.app.ws.io.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByUserId(String userId);

}
