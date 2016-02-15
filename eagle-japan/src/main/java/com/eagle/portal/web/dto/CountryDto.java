package com.eagle.portal.web.dto;

/**
 * Country Data transfer object class
 * @author Harshana Samaranayake
 */
public class CountryDto {

    private Integer id;

    private String name;

    private String abbreviation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
