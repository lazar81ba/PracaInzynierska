package com.blazarczyk.praca.model.json;


import com.blazarczyk.praca.model.databse.Country;

public class CountryJson {

    private long id;
    private String name;

    public CountryJson() {
    }

    public CountryJson(Country country){
        id = country.getId();
        name = country.getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
