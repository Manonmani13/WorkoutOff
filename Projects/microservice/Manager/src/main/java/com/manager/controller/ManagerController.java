package com.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.entity.Manager;
import com.manager.service.ManagerService;

@RestController
@RequestMapping("/managers")

public class ManagerController {

@Autowired
private ManagerService managerService;

@PostMapping("/")
public Manager saveManager(@RequestBody Manager manager)
{
	return managerService.saveManager(manager);
	
}

@GetMapping("/{id}")
public Manager getManager(@PathVariable("id") long managerId)
{
	return managerService.getManager(managerId);
}

}
