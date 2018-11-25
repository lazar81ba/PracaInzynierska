package com.blazarczyk.praca.controller;

import com.blazarczyk.praca.model.json.*;
import com.blazarczyk.praca.service.ProjectService;
import com.blazarczyk.praca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @RequestMapping(path = "/project/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ProjectJson getProject(@PathVariable(value = "id") Long id){
        return new ProjectJson(projectService.getProjectWithId(id));
    }

    @RequestMapping(path = "/project", method = RequestMethod.GET)
    @ResponseBody
    public List<ProjectJson> getProjects(@RequestParam(value = "participant_id",required = false) Long id,
                                         @RequestParam(value = "name", required = false)String name){
        List<ProjectJson> response = new LinkedList<>();
        if(id != null)
            projectService.getProjectsByParticipantId(id).forEach(x -> response.add(new ProjectJson(x)));
        else if (name != null)
            projectService.getProjectsWithName(name).forEach(x -> response.add(new ProjectJson(x)));
        else
            projectService.getAllProjects().forEach(x -> response.add(new ProjectJson(x)));

        return response;
    }

    @RequestMapping(path = "/project/{id}/projectDetails", method = RequestMethod.GET)
    @ResponseBody
    public List<ProjectDetailJson> getProjectDetails(@PathVariable(value = "id") Long id){
        return (new ProjectJson(projectService.getProjectWithId(id))).getProjectDetails();
    }

    @RequestMapping(path = "/project/{id}/links", method = RequestMethod.GET)
    @ResponseBody
    public List<LinkJson> getProjectLinks(@PathVariable(value = "id") Long id){
        return (new ProjectJson(projectService.getProjectWithId(id))).getLinks();
    }

    @RequestMapping(path = "/project/{id}/tags", method = RequestMethod.GET)
    @ResponseBody
    public List<TagJson> getProjectTags(@PathVariable(value = "id") Long id){
        return (new ProjectJson(projectService.getProjectWithId(id))).getTags();
    }

    @RequestMapping(path = "/project/{id}/participators", method = RequestMethod.GET)
    @ResponseBody
    public List<UserGeneralJson> getUsersByProjectId(@PathVariable(value = "id") Long project_id){
        List<UserGeneralJson> users = new LinkedList<>();
        userService.getUsersParticipatingInProjectById(project_id).forEach(x -> users.add(new UserGeneralJson(x)));
        return users;
    }

}
