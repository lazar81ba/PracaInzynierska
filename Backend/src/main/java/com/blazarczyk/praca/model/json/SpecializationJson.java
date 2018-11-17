package com.blazarczyk.praca.model.json;

import com.blazarczyk.praca.model.databse.Faculty;
import com.blazarczyk.praca.model.databse.Specialization;
import com.blazarczyk.praca.model.databse.User;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SpecializationJson {
    private long id;
    private String name;
    private List<UserGeneralJson> users = new LinkedList<>();
    private List<FacultyGeneralJson> faculties = new LinkedList<>();

    public SpecializationJson() {
    }

    public SpecializationJson(Specialization specialization) {
        id = specialization.getId();
        name = specialization.getName();
        users = new LinkedList<>();
        faculties = new LinkedList<>();
        specialization.getUsers().forEach(x -> users.add(new UserGeneralJson(x)));
        specialization.getFaculties().forEach(x -> faculties.add(new FacultyGeneralJson(x)));

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

    public List<UserGeneralJson> getUsers() {
        return users;
    }

    public void setUsers(List<UserGeneralJson> users) {
        this.users = users;
    }

    public List<FacultyGeneralJson> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<FacultyGeneralJson> faculties) {
        this.faculties = faculties;
    }
}
