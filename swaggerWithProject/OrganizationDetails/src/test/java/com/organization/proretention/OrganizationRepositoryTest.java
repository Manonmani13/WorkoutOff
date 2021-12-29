package com.organization.proretention;


import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.proretention.organization.entity.OrganizationDetails;
import com.proretention.organization.repository.OrganizationRepository;
@DataJpaTest
	
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrganizationRepositoryTest {
	@Autowired
	OrganizationRepository organizationRepository;
	
	@Test
    @Order(1)
    @Rollback(value = false)
	public void saveOrganizationDetails()
	{
		OrganizationDetails orgDet=OrganizationDetails.builder()
				.aboutUs("best")
				.address("kadhanchavadi")
				.bussinessType("IT")
				.city("Chennai")
				.companyId(23)
				.country("India")
				.insdustry("proretention")
				.locationUrl("location")
				.organizationId(1)
				.organizationKey("kk")
				.state("TamilNadu")
				.taxId(222)
				.userId(1)
				.userKey("abc")
				.websiteUrl("google.com")
				.zipCode(100)
				.build();
		organizationRepository.save(orgDet);
		Assertions.assertThat(orgDet.getOrganizationId()).isGreaterThan(0);
	}
    @Test
    @Order(2)
    public void getOrganization()
    {
    	OrganizationDetails org=organizationRepository.findByOrganizationKey("kk");
    	Assertions.assertThat(org.getOrganizationId()).isEqualTo(1);
    }
    @Test
    @Order(3)
    public void  getListOfOrganization()
    {
    	List<OrganizationDetails> orgDet =organizationRepository.findAll();
    	Assertions.assertThat(orgDet.size()).isGreaterThan(0);
    }
    @Test
    @Order(4)
    @Rollback(value = false)
    public void  updateOrganization()
    {
    	OrganizationDetails org=organizationRepository.findByOrganizationKey("kk");
    	org.setAboutUs("best Company");
    	OrganizationDetails orgUpdate=organizationRepository.save(org);
    	Assertions.assertThat(orgUpdate.getAboutUs()).isEqualTo("best Company");
    	
    	
    }
    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteOrganization()
    {
    	OrganizationDetails org=organizationRepository.findByOrganizationKey("kk");
    	organizationRepository.delete(org);
    	
    }
    
}
