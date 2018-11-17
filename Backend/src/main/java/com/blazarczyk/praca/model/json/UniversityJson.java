package com.blazarczyk.praca.model.json;


import com.blazarczyk.praca.model.databse.University;

import java.util.LinkedList;
import java.util.List;

public class UniversityJson {

    private long id;
    private String name;
    private CountryJson country;
    private List<FacultyJson> faculties = new LinkedList<>();

    public UniversityJson() {
    }

    public UniversityJson(University university) {
        id = university.getId();
        name = university.getName();
        country = new CountryJson(university.getCountry());
        faculties = new LinkedList<>();
        university.getFaculties().forEach(x -> faculties.add(new FacultyJson(x)));
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

    public CountryJson getCountry() {
        return country;
    }

    public void setCountry(CountryJson country) {
        this.country = country;
    }

    public List<FacultyJson> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<FacultyJson> faculties) {
        this.faculties = faculties;
    }
}
