package com.eagle.portal.web.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.eagle.commons.domain.EntityBase;

@Entity
@Table(name = "country", catalog = "eagle")
public class Country extends EntityBase{
	
	private static final long serialVersionUID = -6572177230044482259L;

	private String name;
	
	@OneToMany(mappedBy="country",cascade=CascadeType.PERSIST)
	private Set<ContactInfo> contactInfos = new HashSet<ContactInfo>();
	
	private String abbreviation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public Set<ContactInfo> getContactInfos() {
		return contactInfos;
	}

	public void setContactInfos(Set<ContactInfo> contactInfos) {
		this.contactInfos = contactInfos;
	}
	
}
