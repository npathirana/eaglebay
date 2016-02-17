package com.eagle.portal.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.eagle.commons.domain.EntityBase;

@Entity
@Table(name = "vehiclemake", catalog = "eagle")
public class VehicleMake extends EntityBase{
	
	private static final long serialVersionUID = -687612683247096740L;

	private String name;
	
	@ManyToOne
	@JoinColumn(name="country_id")
	@NotFound(action=NotFoundAction.IGNORE)
	private Country country;
	
	@Column(name = "is_machinery")
	private Boolean isMachinery;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Boolean getIsMachinery() {
		return isMachinery;
	}

	public void setIsMachinery(Boolean isMachinery) {
		this.isMachinery = isMachinery;
	}

}
