package com.proretention.refapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.proretention.refapi.io.entity.UserEntity;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

	UserEntity findByUserId(String userId);

}
