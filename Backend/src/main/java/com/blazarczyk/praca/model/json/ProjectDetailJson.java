package com.blazarczyk.praca.model.json;


import com.blazarczyk.praca.model.databse.ProjectDetail;

public class ProjectDetailJson {

    private long id;
    private String content;

    public ProjectDetailJson() {
    }

    public ProjectDetailJson(ProjectDetail projectDetail) {
        id = projectDetail.getId();
        content = projectDetail.getContent();
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
}
