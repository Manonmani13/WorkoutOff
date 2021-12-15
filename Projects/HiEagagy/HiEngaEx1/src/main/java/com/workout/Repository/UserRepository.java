package com.workout.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workout.model.UserInfo;

public interface UserRepository extends JpaRepository <UserInfo,Integer> {

}
