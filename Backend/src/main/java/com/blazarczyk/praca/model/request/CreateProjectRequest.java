package com.blazarczyk.praca.model.request;

import com.blazarczyk.praca.model.json.LinkJson;
import com.blazarczyk.praca.model.json.ProjectDetailJson;
import com.blazarczyk.praca.model.json.TagJson;

import java.util.Set;

public class CreateProjectRequest {

    private String name;
    private String description;
    private String imageURL;
    private boolean publicProject;
    private Set<ProjectDetailJson> projectDetails;
    private Set<LinkJson> links;
    private Set<TagJson> tags;

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

    public Set<ProjectDetailJson> getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(Set<ProjectDetailJson> projectDetails) {
        this.projectDetails = projectDetails;
    }

    public Set<LinkJson> getLinks() {
        return links;
    }

    public void setLinks(Set<LinkJson> links) {
        this.links = links;
    }

    public Set<TagJson> getTags() {
        return tags;
    }

    public void setTags(Set<TagJson> tags) {
        this.tags = tags;
    }
}
