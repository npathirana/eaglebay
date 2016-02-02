package com.eagle.portal.web.main.dto;

import com.eagle.user.domain.User;

/**
 * Buyer Data transfer object class
 * @see java.io.Serializable
 * @see com.eagle.user.domain.User
 * @see com.eagle.commons.domain.EntityBase
 * @author Harshana Samaranayake
 */
public class BuyerDto extends User{

    private ContactInfoDto contactInfo;

    private Boolean receiveNewsLetter;

    public ContactInfoDto getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfoDto contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Boolean getReceiveNewsLetter() {
        return receiveNewsLetter;
    }

    public void setReceiveNewsLetter(Boolean receiveNewsLetter) {
        this.receiveNewsLetter = receiveNewsLetter;
    }
}
