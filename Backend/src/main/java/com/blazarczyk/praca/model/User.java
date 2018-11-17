package com.blazarczyk.praca.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String image_url;

    @Column
    private String sex;

    @ManyToOne
    @JoinColumn(name = "id_university")
    private University university;

    @ManyToOne
    @JoinColumn(name = "id_faculty")
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "id_specialization")
    private Specialization specialization;



    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "project_user",
            joinColumns = { @JoinColumn(name = "id_user") },
            inverseJoinColumns = { @JoinColumn(name = "id_project") }
    )
    private Set<Project> participatedProjects;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "observable",
            joinColumns = { @JoinColumn(name = "id_user") },
            inverseJoinColumns = { @JoinColumn(name = "id_project") }
    )
    private Set<Project> observedProjects;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Set<Project> getParticipatedProjects() {
        return participatedProjects;
    }

    public void setParticipatedProjects(Set<Project> participatedProjects) {
        this.participatedProjects = participatedProjects;
    }

    public Set<Project> getObservedProjects() {
        return observedProjects;
    }

    public void setObservedProjects(Set<Project> observedProjects) {
        this.observedProjects = observedProjects;
    }
}
