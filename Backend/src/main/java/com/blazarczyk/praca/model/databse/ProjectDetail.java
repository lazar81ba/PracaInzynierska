package com.blazarczyk.praca.model.databse;

import javax.persistence.*;

@Entity
@Table(name = "project_details", schema = "public")
public class ProjectDetail {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String content;

    public ProjectDetail(String content) {
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;

    public ProjectDetail() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
