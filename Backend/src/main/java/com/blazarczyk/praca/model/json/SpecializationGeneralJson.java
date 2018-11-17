package com.blazarczyk.praca.model.json;


import com.blazarczyk.praca.model.databse.Specialization;

public class SpecializationGeneralJson {

    private long id;
    private String name;

    public SpecializationGeneralJson() {
    }

    public SpecializationGeneralJson(Specialization specialization) {
        id = specialization.getId();
        name = specialization.getName();
    }


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
}
