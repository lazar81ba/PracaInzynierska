package com.blazarczyk.praca.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project_tag", schema = "public")
public class Tag {
    @Id
    private long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Project> projectEntries;

    public String getName() {
        return name;
    }

    public void setName(String content) {
        this.name = content;
    }

    public Set<Project> getProjectEntries() {
        return projectEntries;
    }

    public void setProjectEntries(Set<Project> projectEntries) {
        this.projectEntries = projectEntries;
    }
}
