package com.eagle.commons.domain;

import javax.persistence.*;

/**
 * Corporate Buyer Entity class
 * @see com.eagle.commons.domain.Buyer
 * @see com.eagle.user.domain.User
 * @see com.eagle.commons.domain.EntityBase
 * @see java.io.Serializable
 * @author Harshana Samaranayake
 */
@Entity
@Table(name = "corporate_buyer", schema = "eagle")
@AttributeOverride(name = "id", column = @Column(name = "buyer_id"))
public class CorporateBuyer extends Buyer {
    private String companyName;
    private String companyType;

    @Basic
    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "company_type")
    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CorporateBuyer that = (CorporateBuyer) o;

        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (companyType != null ? !companyType.equals(that.companyType) : that.companyType != null) return false;

        return true;
    }
}
