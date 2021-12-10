package com.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.entity.OrganizationDetails;
import com.organization.request.model.OrganizationDetailsRequestModel;
import com.organization.response.OrganizationDetailsResponseModel;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationDetails,Long> {

	OrganizationDetails getByOrganizationId(long organizationId);

	OrganizationDetailsResponseModel save(OrganizationDetailsRequestModel organization);

}