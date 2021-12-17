package com.organization.repository;

import java.util.function.IntPredicate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.entity.OrganizationDetails;
import com.organization.request.model.OrganizationDetailsRequestModel;
import com.organization.response.OrganizationDetailsResponseModel;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationDetails,Long> {

	OrganizationDetails findByOrganizationKey(String organizationKey);

	OrganizationDetails deleteByOrganizationKey(String organizationKey);

	Object existsByOrganizationId(String string);

	void existsByOrganizationKey(String string);



	
}