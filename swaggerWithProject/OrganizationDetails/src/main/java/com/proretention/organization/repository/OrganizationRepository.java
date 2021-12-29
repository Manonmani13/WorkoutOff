package com.proretention.organization.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proretention.organization.entity.OrganizationDetails;


@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationDetails,Long> {

	OrganizationDetails findByOrganizationKey(String organizationKey);

	OrganizationDetails deleteByOrganizationKey(String organizationKey);


}