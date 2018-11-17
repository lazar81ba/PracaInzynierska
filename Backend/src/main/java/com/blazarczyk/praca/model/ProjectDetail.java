package com.blazarczyk.praca.model;

import javax.persistence.*;

@Entity
@Table(name = "project_details", schema = "public")
public class ProjectDetail {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;



    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
