package com.eagle.portal.web.domain;

import javax.persistence.*;

/**
 * Individual Buyer Entity class
 * @see Buyer
 * @see com.eagle.user.domain.User
 * @see com.eagle.commons.domain.EntityBase
 * @see java.io.Serializable
 * @author Harshana Samaranayake
 */
@Entity
@Table(name = "individual_buyer", schema = "eagle")
@AttributeOverride(name = "id", column = @Column(name = "buyer_id"))
public class IndividualBuyer extends Buyer {
    private String firstName;
    private String lastName;

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndividualBuyer that = (IndividualBuyer) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }
}
