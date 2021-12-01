package com.muthu.crud.Reposi;

import org.springframework.data.repository.CrudRepository;

import com.muthu.crud.model.User;

public interface UserDao extends CrudRepository<User,Integer>{

}
