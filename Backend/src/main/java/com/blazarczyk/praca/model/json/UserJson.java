package com.blazarczyk.praca.model.json;


import com.blazarczyk.praca.model.databse.User;

import java.util.LinkedList;
import java.util.List;

public class UserJson {

    public UserJson() {}

    public UserJson(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.imageUrl = user.getImageUrl();
        this.sex = user.getSex();
        this.university = new UniversityGeneralJson(user.getUniversity());
        this.faculty = new FacultyGeneralJson(user.getFaculty());
        this.specialization = new SpecializationGeneralJson(user.getSpecialization());
        participatedProjects = new LinkedList<>();
        observedProjects = new LinkedList<>();
        user.getParticipatedProjects().forEach(x -> participatedProjects.add(new ProjectJson(x)));
        user.getObservedProjects().forEach(x -> observedProjects.add(new ProjectJson(x)));

    }

    private long id;

    private String name;

    private String surname;

    private String email;

    private String imageUrl;

    private String sex;

    private UniversityGeneralJson university;

    private FacultyGeneralJson faculty;

    private SpecializationGeneralJson specialization;

    private List<ProjectJson> participatedProjects = new LinkedList<>();

    private List<ProjectJson> observedProjects = new LinkedList<>();

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String image_url) {
        this.imageUrl = image_url;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public UniversityGeneralJson getUniversity() {
        return university;
    }

    public void setUniversity(UniversityGeneralJson university) {
        this.university = university;
    }

    public FacultyGeneralJson getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyGeneralJson faculty) {
        this.faculty = faculty;
    }

    public SpecializationGeneralJson getSpecialization() {
        return specialization;
    }

    public void setSpecialization(SpecializationGeneralJson specialization) {
        this.specialization = specialization;
    }

    public List<ProjectJson> getParticipatedProjects() {
        return participatedProjects;
    }

    public void setParticipatedProjects(List<ProjectJson> participatedProjects) {
        this.participatedProjects = participatedProjects;
    }

    public List<ProjectJson> getObservedProjects() {
        return observedProjects;
    }

    public void setObservedProjects(List<ProjectJson> observedProjects) {
        this.observedProjects = observedProjects;
    }
}
