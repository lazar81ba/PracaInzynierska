package com.blazarczyk.praca.model.json;

import com.blazarczyk.praca.model.databse.Project;

import java.util.LinkedList;
import java.util.List;

public class ProjectGeneralJson {
    private long id;
    private String name;
    private String description;
    private String imageUrl;
    private boolean publicProject;
    private List<ProjectDetailJson> projectDetails = new LinkedList<>();
    private List<LinkJson> links = new LinkedList<>();
    private List<TagJson> tags = new LinkedList<>();

    public ProjectGeneralJson() {
    }

    public ProjectGeneralJson(Project project) {
        id = project.getId();
        name = project.getName();
        description = project.getDescription();
        imageUrl = project.getImageURL();
        publicProject = project.isPublicProject();
        projectDetails = new LinkedList<>();
        links = new LinkedList<>();
        tags = new LinkedList<>();
        project.getProjectDetails().forEach(x -> projectDetails.add(new ProjectDetailJson(x)));
        project.getLinks().forEach(x -> links.add(new LinkJson(x)));
        project.getTags().forEach(x -> tags.add(new TagJson(x)));
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

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isPublicProject() {
        return publicProject;
    }

    public void setPublicProject(boolean publicProject) {
        this.publicProject = publicProject;
    }

    public List<ProjectDetailJson> getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(List<ProjectDetailJson> projectDetails) {
        this.projectDetails = projectDetails;
    }

    public List<LinkJson> getLinks() {
        return links;
    }

    public void setLinks(List<LinkJson> links) {
        this.links = links;
    }

    public List<TagJson> getTags() {
        return tags;
    }

    public void setTags(List<TagJson> tags) {
        this.tags = tags;
    }
}
