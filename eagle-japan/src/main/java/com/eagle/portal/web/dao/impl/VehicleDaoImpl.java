package com.eagle.portal.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.eagle.commons.dao.impl.GenericDaoImpl;
import com.eagle.portal.web.dao.VehicleDao;
import com.eagle.portal.web.domain.Vehicle;

@Repository
public class VehicleDaoImpl extends GenericDaoImpl<Vehicle> implements VehicleDao {

	protected VehicleDaoImpl() {
		super(Vehicle.class);
	}

	

}
