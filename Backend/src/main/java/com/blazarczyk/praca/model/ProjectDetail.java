package com.blazarczyk.praca.model;

import javax.persistence.*;

@Entity
@Table(name = "project_details", schema = "public")
public class ProjectDetail {
    @Id
    private long id;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
