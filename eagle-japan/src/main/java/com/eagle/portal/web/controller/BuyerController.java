package com.eagle.portal.web.controller;

import com.eagle.portal.web.domain.ContactInfo;
import com.eagle.portal.web.domain.CorporateBuyer;
import com.eagle.portal.web.domain.Country;
import com.eagle.portal.web.domain.IndividualBuyer;
import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.web.controller.ControllerBase;
import com.eagle.commons.web.controller.json.PostResponse;
import com.eagle.portal.web.dto.CorporateBuyerDto;
import com.eagle.portal.web.dto.IndividualBuyerDto;
import com.eagle.portal.web.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for Buyer
 * Created by Harshana Samaranayake on 2/1/2016.
 * @see
 */
@Controller
@RequestMapping("/buyer")
public class BuyerController extends ControllerBase {

    protected static Logger logger = LoggerFactory.getLogger(BuyerController.class);

    @Autowired
    private CountryService countryService;
    @Autowired
    private ContactInfoService contactInfoService;
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private CorporateBuyerService corporateBuyerService;
    @Autowired
    private IndividualBuyerService individualBuyerService;

    @RequestMapping()
    public String newBuyer(){

        logger.debug("Loaded New Seller Page");
        return "buyer-test-page";
    }

    @RequestMapping(value = "cb",method = RequestMethod.POST)
    public @ResponseBody PostResponse persistCorporateBuyer(@ModelAttribute CorporateBuyerDto buyerDto){

        logger.debug("inside persistCorporateBuyer({}), ", buyerDto);

        PostResponse response = new PostResponse();

        CorporateBuyer buyer = null;

        try {
            buyer = corporateBuyerService.getById(buyerDto.getId());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        buyer.setCompanyName(buyerDto.getCompanyName());
        buyer.setCompanyType(buyerDto.getCompanyType());
        buyer.setAttempts(buyerDto.getAttempts());
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setAddress1(buyerDto.getContactInfo().getAddress1());
        contactInfo.setAddress2(buyerDto.getContactInfo().getAddress2());
        contactInfo.setCity(buyerDto.getContactInfo().getCity());
        contactInfo.setEmail(buyerDto.getContactInfo().getEmail());
        contactInfo.setFax(buyerDto.getContactInfo().getFax());
        contactInfo.setHotline(buyerDto.getContactInfo().getHotline());
        contactInfo.setMobile(buyerDto.getContactInfo().getMobile());
        contactInfo.setPhone(buyerDto.getContactInfo().getPhone());
        contactInfo.setPostalCode(buyerDto.getContactInfo().getPostalCode());
        contactInfo.setStateProvince(buyerDto.getContactInfo().getStateProvince());
        contactInfo.setWebsiteUrl(buyerDto.getContactInfo().getWebsiteUrl());

        Country country = new Country();
        country.setName(buyerDto.getContactInfo().getCountry().getName());
        try{

            countryService.save(country);
            contactInfo.setCountry(country);

            contactInfoService.save(contactInfo);
            buyer.setContactId(contactInfo);

            buyerService.save(buyer);

        }catch(ServiceException e){
            setServiceError(response, e);
        }
        return response;
    }

    @RequestMapping(value = "ib",method = RequestMethod.POST)
    public @ResponseBody PostResponse persistIndividualBuyer(@ModelAttribute IndividualBuyerDto buyerDto){

        logger.debug("inside persistCorporateBuyer({}), ", buyerDto);

        PostResponse response = new PostResponse();

        IndividualBuyer buyer = null;

        try {
            buyer = individualBuyerService.getById(buyerDto.getId());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        buyer.setFirstName(buyerDto.getFirstName());
        buyer.setLastName(buyerDto.getLastName());
        buyer.setAttempts(buyerDto.getAttempts());
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setAddress1(buyerDto.getContactInfo().getAddress1());
        contactInfo.setAddress2(buyerDto.getContactInfo().getAddress2());
        contactInfo.setCity(buyerDto.getContactInfo().getCity());
        contactInfo.setEmail(buyerDto.getContactInfo().getEmail());
        contactInfo.setFax(buyerDto.getContactInfo().getFax());
        contactInfo.setHotline(buyerDto.getContactInfo().getHotline());
        contactInfo.setMobile(buyerDto.getContactInfo().getMobile());
        contactInfo.setPhone(buyerDto.getContactInfo().getPhone());
        contactInfo.setPostalCode(buyerDto.getContactInfo().getPostalCode());
        contactInfo.setStateProvince(buyerDto.getContactInfo().getStateProvince());
        contactInfo.setWebsiteUrl(buyerDto.getContactInfo().getWebsiteUrl());

        Country country = new Country();
        country.setName(buyerDto.getContactInfo().getCountry().getName());
        try{

            countryService.save(country);
            contactInfo.setCountry(country);

            contactInfoService.save(contactInfo);
            buyer.setContactId(contactInfo);

            buyerService.save(buyer);

        }catch(ServiceException e){
            setServiceError(response, e);
        }
        return response;
    }

}
