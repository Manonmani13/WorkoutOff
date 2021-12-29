package com.proretention.module;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.proretention.module.entity.ModuleEntity;
import com.proretention.module.repository.ModuleRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ModuleRepositoryTest {
@Autowired
ModuleRepository moduleRepository;
@Test
@Order(1)
@Rollback(value=false)
public void saveModuleDetails()
{
		 ModuleEntity module=ModuleEntity.builder()
				 .moduleId(1)
				 .moduleKey("mk")
				 .moduleName("Test")
				 .moduleDescription("about testing")
				 .build();
		 moduleRepository.save(module);
		 Assertions.assertThat(module.getModuleId()).isGreaterThan(0);
}
@Test
@Order(2)
public void getModule()
{
	ModuleEntity module=moduleRepository.getByModuleKey("mk");
	Assertions.assertThat(module.getModuleId()).isEqualTo(1);
	
}
@Test
@Order(3)
public void getAllModule()
{
	List<ModuleEntity> module=moduleRepository.findAll();
	Assertions.assertThat(module.size()).isGreaterThan(0);
	
}
@Test
@Order(4)
@Rollback(value = false)
public void updateModule()
{
	ModuleEntity module=moduleRepository.getByModuleKey("mk");
	module.setModuleName("Java");
	module.setModuleDescription("about java language");
	ModuleEntity moduleupdates=moduleRepository.save(module);
	Assertions.assertThat(moduleupdates.getModuleName()).isEqualTo("Java");
	Assertions.assertThat(moduleupdates.getModuleDescription()).isEqualTo("about java language");
}
@Test
@Order(5)
@Rollback(value=false)
public void deleteModule()
{
	ModuleEntity module=moduleRepository.getByModuleKey("mk");
	moduleRepository.delete(module);
		
}
}

