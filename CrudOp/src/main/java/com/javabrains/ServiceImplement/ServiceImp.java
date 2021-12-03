package com.javabrains.ServiceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.javabrains.Repository.UserRepos;
import com.javabrains.Service.UserService;
import com.javabrains.model.User;

public class ServiceImp implements UserService{
	private UserRepos userRepos;
	@Autowired
	public ServiceImp(UserRepos userRepos)
	{
		super();
		this.userRepos=userRepos;
	}
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepos.save(user);
	}

	@Override
	public List<User> getUserAll() {
		// TODO Auto-generated method stub
		return userRepos.findAll();
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepos.findById(id).orElse(new User());
	}

	@Override
	public User updateUser(User user, int id) {
		// TODO Auto-generated method stub
		User existingUser=userRepos.findById(id).orElse(new User());
		existingUser.setName(user.getName());
		userRepos.save(existingUser);
		
		return existingUser;		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userRepos.findById(id).orElse(new User());
		userRepos.deleteById(id);
	}

}
