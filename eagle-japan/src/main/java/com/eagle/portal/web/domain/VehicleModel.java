package com.eagle.portal.web.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.eagle.commons.domain.EntityBase;

@Entity
@Table(name = "vehicle_model", catalog = "eagle")
public class VehicleModel extends EntityBase{

	private static final long serialVersionUID = 5447389317392388010L;

	private String name;
	
	@ManyToOne
	@JoinColumn(name="vehicle_make_id")
	@NotFound(action=NotFoundAction.IGNORE)
	private VehicleMake vehicleMake;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VehicleMake getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(VehicleMake vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
