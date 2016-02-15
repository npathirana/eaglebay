package com.eagle.portal.web.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Corporate Buyer Entity class
 * @author Harshana Samaranayake
 */
@Entity
@Table(name = "country", schema = "eagle", catalog = "")
public class Country {
    private Integer id;
    private String name;
    private String abbreviation;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "abbreviation")
    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country that = (Country) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (abbreviation != null ? !abbreviation.equals(that.abbreviation) : that.abbreviation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (abbreviation != null ? abbreviation.hashCode() : 0);
        return result;
    }

    private Collection<ContactInfo> contactInfo;

    @OneToMany(mappedBy = "country")
    public Collection<ContactInfo> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Collection<ContactInfo> contactInfo) {
        this.contactInfo = contactInfo;
    }
}
