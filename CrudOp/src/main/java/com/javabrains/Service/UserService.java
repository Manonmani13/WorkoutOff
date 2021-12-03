package com.javabrains.Service;

import java.util.List;

import com.javabrains.model.User;

public interface UserService {
User saveUser(User user);
List<User> getUserAll();
User getUserById(int id);
User updateUser(User user,int id);
void delete(int id);
}
