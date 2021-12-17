package com.organization.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor

@Entity
@Table(name="Organization")
public class OrganizationDetails   implements Serializable{
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long organizationId;
private String organizationKey;
private long userId;
private String userKey;
private String address;
private String country;
private String city;
private String state;
private long zipCode;
private String locationUrl;
private String websiteUrl;
private String insdustry;
private String bussinessType;
private long taxId;
private long companyId;
private String aboutUs;



}
