package com.blazarczyk.praca.service;

import com.blazarczyk.praca.model.databse.Project;

import java.util.List;

public interface ProjectService {

    Project getProjectWithId(long id);
    List<Project> getProjectsWithName(String name);
    List<Project> getProjectsByParticipantId(long id);
    List<Project> getAllProjects();
    List<Project> getRecommendedProjectsForUser(String email);
    void addUserToParticipator(long projectId, String userEmail);
    void removeUserFromParticipator(long projectId, String userEmail);
    void addProjectToSubscribe(long projectId, String userEmail);
    void removeProjectFromSubscribe(long projectId, String userEmail);
    void createProject(Project project);

}
