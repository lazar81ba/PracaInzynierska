package com.blazarczyk.praca.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project_tag", schema = "public")
public class Tag {
    @Id
    private long id;

    @Column
    private String content;

    @ManyToMany(mappedBy = "tags")
    private Set<Project> projectEntries;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Project> getProjectEntries() {
        return projectEntries;
    }

    public void setProjectEntries(Set<Project> projectEntries) {
        this.projectEntries = projectEntries;
    }
}
