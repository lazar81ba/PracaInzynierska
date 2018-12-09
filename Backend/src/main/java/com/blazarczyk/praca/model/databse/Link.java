package com.blazarczyk.praca.model.databse;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "link", schema = "public")
public class Link {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String address;

    public Link(String address) {
        this.address = address;
    }

    @ManyToMany(mappedBy = "links")
    private Set<Project> projectEntries;

    public Link() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Project> getProjectEntries() {
        return projectEntries;
    }

    public void setProjectEntries(Set<Project> projectEntries) {
        this.projectEntries = projectEntries;
    }
}
