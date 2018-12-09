package com.blazarczyk.praca.converters;

import com.blazarczyk.praca.model.databse.Link;
import com.blazarczyk.praca.model.databse.Project;
import com.blazarczyk.praca.model.databse.ProjectDetail;
import com.blazarczyk.praca.model.databse.Tag;
import com.blazarczyk.praca.model.request.CreateProjectRequest;

import java.util.HashSet;
import java.util.Set;

public class ProjectConverter {
    public static Project fromCreateProjectRequest(CreateProjectRequest createProjectRequest) {
        Project project = new Project();
        project.setName(createProjectRequest.getName());
        project.setDescription(createProjectRequest.getDescription());
        project.setImageURL(createProjectRequest.getImageURL());
        project.setPublicProject(createProjectRequest.isPublicProject());
        Set<Link> links = new HashSet<>();
        createProjectRequest.getLinks().forEach(
                (link) -> links.add(new Link(link.getAddress()))
        );
        project.setLinks(links);

        Set<ProjectDetail> projectDetails = new HashSet<>();
        createProjectRequest.getProjectDetails().forEach(
                (detail) -> projectDetails.add(new ProjectDetail(detail.getContent()))
        );
        project.setProjectDetails(projectDetails);

        Set<Tag> tags = new HashSet<>();
        createProjectRequest.getTags().forEach(
                (tag) -> tags.add(new Tag(tag.getName()))
        );
        project.setTags(tags);
        return project;
    }
}
