package com.blazarczyk.praca.model.databse;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tag", schema = "public")
public class Tag {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "tags")
    private Set<Project> projectEntries;

    public Tag() {
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
