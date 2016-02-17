package com.eagle.portal.web.controller;

import java.util.Date;
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
import com.eagle.commons.util.PasswordParser;
import com.eagle.commons.web.controller.ControllerBase;
import com.eagle.commons.web.controller.json.PostResponse;
import com.eagle.portal.web.domain.ContactInfo;
import com.eagle.portal.web.domain.Country;
import com.eagle.portal.web.domain.Seller;
import com.eagle.portal.web.dto.SellerDto;
import com.eagle.portal.web.service.SellerService;

@Controller
@RequestMapping("/sellers")
public class SellerController extends ControllerBase{

	protected static Logger logger = LoggerFactory.getLogger(SellerController.class);
	
	@Autowired
	private SellerService sellerService;
	
	@RequestMapping()
	public String getNewSellerPage(Model model){
		logger.debug("Loaded New Seller Page");
		return "new-seller";
	}
	
	@RequestMapping(value="/step-1",method=RequestMethod.POST)
	public @ResponseBody PostResponse  persistSellerStep1(@ModelAttribute() SellerDto sellerDto){
		logger.debug("inside persistSeller({}), ", sellerDto);

        PostResponse response = new PostResponse();
        Seller seller = new Seller();
        
        //fill seller object from sellerDto
        seller.setEmail(sellerDto.getEmail());
        seller.setPassword(PasswordParser.encryptPassword(sellerDto.getPassword()));
        seller.setIsExporter(sellerDto.getIsExporter());
        seller.setIsDealsCar(sellerDto.getIsDealsCar());
        seller.setIsAuctionAgent(sellerDto.getIsAuctionAgent());
        seller.setIsSupplier(sellerDto.getIsSupplier());
        seller.setIsDistributor(sellerDto.getIsDistributor());
        seller.setIsDealsCar(sellerDto.getIsDealsCar());
        seller.setIsDealsMachinery(sellerDto.getIsDealsMachinery());
        seller.setIsDealsSpareParts(sellerDto.getIsDealsSpareParts());
        seller.setBizType(sellerDto.getBizType());
        
        //setting required fields for user
        seller.setAttempts((short)0);
        seller.setRegisteredOn(new Date());
        seller.setStatus((short)0);
        
        try {
        	
            seller = sellerService.save(seller);
            response.setResult(seller);
            
        } catch (ServiceException e) {
            setServiceError(response, e);
        }

        return response;
	}
	
	@RequestMapping(value="/step-2",method=RequestMethod.POST)
	public @ResponseBody PostResponse  persistSellerStep2(@ModelAttribute() SellerDto sellerDto){
		logger.debug("inside persistSeller({}), ", sellerDto);

        PostResponse response = new PostResponse();
        Seller seller = null;
        try{
        	
        	seller = sellerService.getById(sellerDto.getId());
        
        }catch(ServiceException e){
        	setServiceError(response, e);
        }
        
        //fill seller object from sellerDto
        seller.setBizName(sellerDto.getBizName());
        seller.setBizEstablishedOn(sellerDto.getBizEstablishedOn());
        
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setAddress1(sellerDto.getContactInfo().getAddress1());
        contactInfo.setAddress2(sellerDto.getContactInfo().getAddress2());
        contactInfo.setCity(sellerDto.getContactInfo().getCity());
        contactInfo.setEmail(sellerDto.getContactInfo().getEmail());
        contactInfo.setFax(sellerDto.getContactInfo().getFax());
        contactInfo.setHotline(sellerDto.getContactInfo().getHotline());
        contactInfo.setMobile(sellerDto.getContactInfo().getMobile());
        contactInfo.setPhone(sellerDto.getContactInfo().getPhone());
        contactInfo.setPostalCode(sellerDto.getContactInfo().getPostalCode());
        contactInfo.setStateProvince(sellerDto.getContactInfo().getStateProvince());
        contactInfo.setWebsiteUrl(sellerDto.getContactInfo().getWebsiteUrl());
       
        Country country = new Country();
        country.setName(sellerDto.getContactInfo().getCountry().getName());
        
        try{
        	contactInfo.setCountry(country);
        	seller.setContactInfo(contactInfo);
        	sellerService.save(seller);
        	
        	response.setResult(seller);
        
        }catch(ServiceException e){
        	setServiceError(response, e);
        }
        
        return response;
	}
}
