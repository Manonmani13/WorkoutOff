package com.proretention.user.registration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;

import com.proretention.user.registration.entity.UserEntity;
import com.proretention.user.registration.repository.UserRepository;
@DataJpaTest	
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class UserRepositoryTest {
	@Autowired
	UserRepository userRepository;
	@Test
	@Order(1)
	@Rollback(value=false)
	public void saveUserDetails()
	{
			UserEntity user=UserEntity.builder()
					.userId(1L)
					.tenantId(1)
					.userKey("pro12")
					.firstName("latha")
					.lastName("kumar")
					.organization("proretention")
					.designation("IT")
					.domain("google.com")
					.createdBy("admin")
					.updatedBy("Admin")
					.build();
			userRepository.save(user);
			Assertions.assertThat(user.getUserId()).isGreaterThan(0);
			
	}

}
