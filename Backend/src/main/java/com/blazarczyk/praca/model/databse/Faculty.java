package com.blazarczyk.praca.model.databse;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "faculty", schema = "public")
public class Faculty {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "faculty")
    private Set<User> users;

    @ManyToOne
    @JoinColumn(name = "id_university")
    private University university;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "faculty_specialization",
            joinColumns = { @JoinColumn(name = "id_faculty") },
            inverseJoinColumns = { @JoinColumn(name = "id_specialization") }
    )
    private Set<Specialization> specializations;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }
}
