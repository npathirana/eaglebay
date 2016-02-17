package com.eagle.portal.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.web.controller.ControllerBase;
import com.eagle.commons.web.controller.json.PostResponse;
import com.eagle.portal.web.domain.Vehicle;
import com.eagle.portal.web.service.VehicleService;

@Controller
@RequestMapping("/vehicles")
public class VehicleController extends ControllerBase{
	
	protected static Logger logger = LoggerFactory.getLogger(VehicleController.class);
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping()
	public String getNewSellerPage(Model model){
		logger.debug("Loaded New Seller Page");
		return "new-vehicle";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody PostResponse  persistVehicle(@ModelAttribute() Vehicle vehicleDto){
		logger.debug("inside persistVehicle({}), ", vehicleDto);
		
		PostResponse response = new PostResponse();
		try {
			vehicleService.save(vehicleDto);
			response.setResult(vehicleDto);
		} catch (ServiceException e) {
			setServiceError(response, e);
		}
		return response;
	}
}
