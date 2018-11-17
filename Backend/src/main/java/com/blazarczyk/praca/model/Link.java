package com.blazarczyk.praca.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "link", schema = "public")
public class Link {
    @Id
    private long id;
    @Column
    private String address;

    @ManyToMany(mappedBy = "links")
    private Set<Project> projectEntries;



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
