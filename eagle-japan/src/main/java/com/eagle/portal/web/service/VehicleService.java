package com.eagle.portal.web.service;

import org.springframework.stereotype.Service;

import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.service.GenericService;
import com.eagle.portal.web.domain.Vehicle;

@Service
public interface VehicleService extends GenericService<Vehicle>{

	Vehicle save(Vehicle obj) throws ServiceException;

}
