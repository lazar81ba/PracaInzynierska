package com.blazarczyk.praca.model.json;

import com.blazarczyk.praca.model.databse.Project;

import java.util.LinkedList;
import java.util.List;

public class ProjectJson {

    private long id;
    private String name;
    private String description;
    private String imageURL;
    private boolean publicProject;
    private List<ProjectDetailJson> projectDetails = new LinkedList<>();
    private List<LinkJson> links = new LinkedList<>();
    private List<TagJson> tags = new LinkedList<>();
    private List<UserGeneralJson> participators = new LinkedList<>();


    public ProjectJson() {
    }

    public ProjectJson(Project project) {
        id = project.getId();
        name = project.getName();
        description = project.getDescription();
        imageURL = project.getImageURL();
        publicProject = project.isPublicProject();
        projectDetails = new LinkedList<>();
        links = new LinkedList<>();
        tags = new LinkedList<>();
        participators = new LinkedList<>();
        project.getProjectDetails().forEach(x -> projectDetails.add(new ProjectDetailJson(x)));
        project.getLinks().forEach(x -> links.add(new LinkJson(x)));
        project.getTags().forEach(x -> tags.add(new TagJson(x)));
        project.getProjectParticipants().forEach(x -> participators.add(new UserGeneralJson(x)));
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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

    public List<UserGeneralJson> getParticipators() {
        return participators;
    }

    public void setParticipators(List<UserGeneralJson> participators) {
        this.participators = participators;
    }
}
