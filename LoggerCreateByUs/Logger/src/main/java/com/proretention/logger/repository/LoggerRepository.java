package com.proretention.logger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proretention.logger.entity.LoggerEntity;

@Repository
public interface LoggerRepository extends JpaRepository<LoggerEntity,Long>{

}