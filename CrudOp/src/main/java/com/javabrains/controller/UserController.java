package com.javabrains.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.Service.UserService;
import com.javabrains.model.User;

@RestController
@RequestMapping("/api/user")
public class UserController {
private UserService userservice;
public  UserController(UserService userservice)
{
super();
this.userservice=userservice;
}
@PostMapping
public  ResponseEntity <User> saveUser(@RequestBody User user)
{
	return new ResponseEntity<User>(userservice.saveUser(user),HttpStatus.OK);
}
@GetMapping
public List<User> getUser()
{
	return userservice.getUserAll();
}
@GetMapping("{id}")
public ResponseEntity<User> getUserById(@PathVariable("id") int id)
{
 return new ResponseEntity<User> (userservice.getUserById(id),HttpStatus.OK);	
}
@PutMapping("{id}")
public ResponseEntity<User> updateUser(@PathVariable ("id") int id,@RequestBody User user)
{
return new ResponseEntity<User> (userservice.updateUser(user, id),HttpStatus.OK);

}
@DeleteMapping("{id}")
public  ResponseEntity<String> deleteUser(@PathVariable int id)
{
	userservice.delete(id);
	return new ResponseEntity<String>("User deleted successfully",HttpStatus.OK);
}
 }
