package com.pro.user.sensitive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.user.sensitive.entity.UserSensitiveEntity;

@Repository
public interface UserSensitiveRepository extends JpaRepository<UserSensitiveEntity, Long> {

	UserSensitiveEntity getById(int id);

}
