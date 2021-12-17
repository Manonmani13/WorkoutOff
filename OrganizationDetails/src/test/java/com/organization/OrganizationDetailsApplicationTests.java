package com.organization;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.organization.entity.OrganizationDetails;
import com.organization.repository.OrganizationRepository;

@SpringBootTest
class OrganizationDetailsApplicationTests {


	@Autowired
	OrganizationRepository organizationRepository;
	
	@Test
	public void testCreate()
	{

		OrganizationDetails orgDet=new OrganizationDetails();
		orgDet.setAboutUs("bestCompany");
		orgDet.setAddress("Kadhanjavadi");
		orgDet.setBussinessType("IT");
		orgDet.setCity("Chennai");
		orgDet.setCompanyId(231);
		orgDet.setCountry("India");
		orgDet.setInsdustry("Proretention");
		orgDet.setLocationUrl("thousandLight");
		orgDet.setOrganizationId(1);
		orgDet.setOrganizationKey("abc");
		orgDet.setState("TamilNadu");
		orgDet.setTaxId(235);
		orgDet.setUserId(2);
		orgDet.setUserKey("kk");
		orgDet.setWebsiteUrl("google.com");
		orgDet.setZipCode(230);
		organizationRepository.save(orgDet);
		Assertions.assertNotNull(organizationRepository.findByOrganizationKey("abc"));
	}
	@Test
public void testReadAll()
{
	List<OrganizationDetails> list=organizationRepository.findAll();
	assertThat(list).size().isGreaterThan(0);
	
}    
@Test
public void testSingleOrganization()
{
	OrganizationDetails organization=organizationRepository.findByOrganizationKey("abc");
	Assertions.assertEquals("TamilNadu",organization.getState());
}
@Test
public void testUpdate()
{
	OrganizationDetails organization=organizationRepository.findByOrganizationKey("abc");
	organization.setAboutUs("good company");
	organizationRepository.save(organization);
	Assertions.assertNotEquals("best company",organizationRepository.findByOrganizationKey("abc"));
	
}
//@Test
//public void testDelete()
//{
//	OrganizationDetails organization=organizationRepository.deleteByOrganizationKey("abc");
//	
//	assertThat(organizationRepository.existsByOrganizationKey("abc")).isFalse();
//}
}
