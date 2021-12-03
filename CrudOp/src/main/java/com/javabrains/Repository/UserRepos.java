package com.javabrains.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javabrains.model.User;

public interface UserRepos extends JpaRepository <User,Integer> {

}
