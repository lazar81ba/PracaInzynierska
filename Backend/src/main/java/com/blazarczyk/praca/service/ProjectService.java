package com.blazarczyk.praca.service;

import com.blazarczyk.praca.model.databse.Project;

import java.util.List;

public interface ProjectService {

    Project getProjectWithId(long id);
    List<Project> getProjectsWithName(String name);
    List<Project> getProjectsByParticipantId(long id);

}
