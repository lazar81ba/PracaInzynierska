package com.blazarczyk.praca.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "specialization", schema = "public")
public class Specialization {

    @Id
    private long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "specialization")
    private Set<User> users;

    @ManyToMany(mappedBy = "specializations")
    private Set<Faculty> faculties;

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

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }
}
