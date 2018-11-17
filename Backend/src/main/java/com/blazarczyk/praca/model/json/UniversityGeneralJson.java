package com.blazarczyk.praca.model.json;

import com.blazarczyk.praca.model.databse.University;

public class UniversityGeneralJson {

    public UniversityGeneralJson() {}

    public UniversityGeneralJson(University university){
        id = university.getId();
        name = university.getName();
        country = new CountryJson(university.getCountry());
    }

    private long id;

    private String name;

    private CountryJson country;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryJson getCountry() {
        return country;
    }

    public void setCountry(CountryJson country) {
        this.country = country;
    }
}
