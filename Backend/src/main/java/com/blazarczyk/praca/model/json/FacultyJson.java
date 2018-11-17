package com.blazarczyk.praca.model.json;

import com.blazarczyk.praca.model.databse.Faculty;

import java.util.LinkedList;
import java.util.List;

public class FacultyJson {

    private long id;
    private String name;
    private List<SpecializationGeneralJson> specializations = new LinkedList<>();

    public FacultyJson() {}

    public FacultyJson(Faculty faculty) {
        id = faculty.getId();
        name =faculty.getName();
        specializations = new LinkedList<>();
        faculty.getSpecializations().forEach(x -> specializations.add(new SpecializationGeneralJson(x)));
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

    public List<SpecializationGeneralJson> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<SpecializationGeneralJson> specializations) {
        this.specializations = specializations;
    }

}
