package com.eagle.portal.web.service.impl;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.eagle.commons.exception.DataAccessException;
import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.service.impl.GenericServiceImpl;
import com.eagle.portal.web.dao.VehicleDao;
import com.eagle.portal.web.domain.Vehicle;
import com.eagle.portal.web.service.VehicleService;

@Service
@Transactional(value = "transactionManager", readOnly = true, propagation = Propagation.REQUIRED)
public class VehicleServiceImpl extends GenericServiceImpl<Vehicle> implements VehicleService {

	@Autowired
	private VehicleDao vehicleDao;
	
	@PostConstruct
	void init() {
		init(Vehicle.class, vehicleDao);
	}
	
	@Override
	@Transactional(value = "transactionManager", readOnly = false, rollbackFor = ServiceException.class)
	public Vehicle save(Vehicle obj) throws ServiceException {

		if (obj != null) {
			if (obj.getId() == null) {
				this.add(obj);
			} else {
				this.edit(obj);
			}
		} else {
			throw new ServiceException(ServiceException.VALIDATION_FAILED, "label.error.required.user");
		}
		return obj;
	}
	
	public Vehicle add(Vehicle vehicle) throws ServiceException { 
		validateConstraints(vehicle);
		
		try {
			vehicleDao.add(vehicle);
			return vehicle;
		}catch (DataAccessException e) {
            throw translateException(e);
        }
	}
	
	public Vehicle edit(Vehicle vehicle) throws ServiceException { 
		validateConstraints(vehicle);
		
		try {
			vehicleDao.modify(vehicle);
			return vehicle;
		}catch (DataAccessException e) {
            throw translateException(e);
        }
	}
		
}
