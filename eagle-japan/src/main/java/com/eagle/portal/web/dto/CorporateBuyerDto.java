package com.eagle.portal.web.dto;

/**
 * Corporate Buyer Data transfer object class
 * @see java.io.Serializable
 * @see com.eagle.user.domain.User
 * @see com.eagle.commons.domain.EntityBase
 * @see BuyerDto
 * @author Harshana Samaranayake
 */
public class CorporateBuyerDto extends BuyerDto {

    private String companyName;

    private String companyType;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }
}
