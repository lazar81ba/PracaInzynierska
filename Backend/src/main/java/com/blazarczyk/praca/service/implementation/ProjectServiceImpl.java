package com.blazarczyk.praca.service.implementation;

import com.blazarczyk.praca.model.databse.Project;
import com.blazarczyk.praca.model.databse.Tag;
import com.blazarczyk.praca.model.databse.User;
import com.blazarczyk.praca.recommendation.ContentBasedRecommender;
import com.blazarczyk.praca.repository.ProjectDAO;
import com.blazarczyk.praca.repository.TagDAO;
import com.blazarczyk.praca.repository.UserDAO;
import com.blazarczyk.praca.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectDAO projectDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    TagDAO tagDAO;
    @Autowired
    private ContentBasedRecommender recommender;

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
    public List<Project> getRecommendedProjectsForUser(String email) {
        recommender.prepareRecommendation();
        return recommender.getUserRecommendation(email);
    }


    @Override
    public void addUserToParticipator(long projectId, String userEmail) {
        User user = userDAO.findByEmail(userEmail);
        Project project = projectDAO.findById(projectId);
        user.addParticipatedProject(project);
        userDAO.save(user);
    }

    @Override
    public void removeUserFromParticipator(long projectId, String userEmail) {
        User user = userDAO.findByEmail(userEmail);
        Project project = projectDAO.findById(projectId);
        user.removeParticipatedProject(project);
        userDAO.save(user);
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

    @Override
    public void createProject(Project project) {
        project.getTags().forEach(
                (tag) -> {
                    Tag tagFromDB = tagDAO.findByName(tag.getName());
                    if(tagFromDB != null){
                        project.removeTag(tag);
                        project.addTag(tagFromDB);
                    }
                }
        );
        projectDAO.save(project);
    }
}
