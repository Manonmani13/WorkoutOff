package com.pro.user_sensitive;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


import com.pro.user.role.entity.UserRoleEntity;
import com.pro.user.role.repository.UserRoleRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RepositoryTest {
@Autowired
UserRoleRepository userRoleRepository;
@Test
@Order(1)
@Rollback(value=false)
public void saveUserRole()
{
	UserRoleEntity userRole=UserRoleEntity.builder()
			.id(1)
			.userId(22L)
			.userRole("user")
			.build();
	userRoleRepository.save(userRole);
	Assertions.assertThat(userRole.getId()).isGreaterThan(0);
	
}
}
