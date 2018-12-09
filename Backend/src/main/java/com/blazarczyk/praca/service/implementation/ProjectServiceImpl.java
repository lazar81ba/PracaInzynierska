package com.blazarczyk.praca.service.implementation;

import com.blazarczyk.praca.model.databse.Project;
import com.blazarczyk.praca.model.databse.User;
import com.blazarczyk.praca.repository.ProjectDAO;
import com.blazarczyk.praca.repository.UserDAO;
import com.blazarczyk.praca.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectDAO projectDAO;
    @Autowired
    UserDAO userDAO;

    @Override
    public Project getProjectWithId(long id) {
        return projectDAO.findById(id);
    }

    @Override
    public List<Project> getProjectsWithName(String name) {
        return projectDAO.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Project> getProjectsByParticipantId(long id) {
        return projectDAO.findAllByProjectParticipantsContaining(userDAO.findById(id));
    }

    @Override
    public List<Project> getAllProjects() {
        return (List<Project>) projectDAO.findAll();
    }

    @Override
    public void addProjectToSubscribe(long projectId, String userEmail) {
        User user = userDAO.findByEmail(userEmail);
        Project projectToSubscribe = projectDAO.findById(projectId);
        user.addObservedProject(projectToSubscribe);
        userDAO.save(user);
    }

    @Override
    public void removeProjectFromSubscribe(long projectId, String userEmail) {
        User user = userDAO.findByEmail(userEmail);
        Project projectToSubscribe = projectDAO.findById(projectId);
        user.removeObservedProject(projectToSubscribe);
        userDAO.save(user);
    }
}
