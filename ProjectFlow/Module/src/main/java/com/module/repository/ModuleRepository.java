package com.module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.module.entity.ModuleEntity;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity,Long>{

	ModuleEntity getByModuleKey(String moduleKey);

}
