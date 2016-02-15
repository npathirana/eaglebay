package com.eagle.portal.web.dto;

/**
 * Individual Buyer Data transfer object class
 * @see java.io.Serializable
 * @see com.eagle.user.domain.User
 * @see com.eagle.commons.domain.EntityBase
 * @see BuyerDto
 * @author Harshana Samaranayake
 */
public class IndividualBuyerDto extends BuyerDto {

    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
