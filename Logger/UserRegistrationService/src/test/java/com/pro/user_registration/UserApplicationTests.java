package com.pro.user_registration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.pro.user.registration.entity.UserEntity;
import com.pro.user.registration.repository.UserRepository;

@SpringBootTest
class UserApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	UserRepository userRepository;
	@Test

	@Rollback(value=false)
	public void saveUserDetails()
	{
			UserEntity user=UserEntity.builder()
					.userId(1L)
					.userKey("pro12")
					.firstName("latha")
					.lastName("kumar")
					.organization("proretentio")
					.designation("IT")
					.domain("google.com")
					.createdBy("admin")
					.updatedBy("Admin")
					.build();
			userRepository.save(user);
			Assertions.assertThat(user.getUserId()).isGreaterThan(0);
			
	}

}
