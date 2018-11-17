package com.blazarczyk.praca.model.json;


import com.blazarczyk.praca.model.databse.Faculty;

public class FacultyGeneralJson {
    private long id;
    private String name;

    public FacultyGeneralJson() {
    }

    public FacultyGeneralJson(Faculty faculty) {
        id = faculty.getId();
        name = faculty.getName();
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
