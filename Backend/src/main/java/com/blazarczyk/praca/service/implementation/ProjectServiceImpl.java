package com.blazarczyk.praca.service.implementation;

import com.blazarczyk.praca.model.databse.Project;
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
        return projectDAO.findAllByName(name);
    }

    @Override
    public List<Project> getProjectsByParticipantId(long id) {
        return projectDAO.findAllByProjectParticipantsContaining(userDAO.findById(id));
    }
}
