package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entity.Manager;
import com.manager.repository.ManagerRepository;

@Service
public class ManagerService {
@Autowired
private ManagerRepository managerRepository;

public Manager saveManager(Manager manager) {
	// TODO Auto-generated method stub
	return managerRepository.save(manager);
}

public Manager getManager(long managerId) {
	// TODO Auto-generated method stub
	return managerRepository.findByManagerId(managerId);
}

}
