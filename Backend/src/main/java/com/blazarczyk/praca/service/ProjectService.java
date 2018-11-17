package com.blazarczyk.praca.service;

import com.blazarczyk.praca.model.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getProjectsWithName(String name);
    List<Project> getProjectsByParticipantId(long id);

}
