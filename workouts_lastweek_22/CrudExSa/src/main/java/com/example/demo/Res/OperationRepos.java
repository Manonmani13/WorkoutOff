package com.example.demo.Res;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Operation;

public interface OperationRepos extends JpaRepository<Operation,String> {

}

