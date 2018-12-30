package com.blazarczyk.praca.controller;

import com.blazarczyk.praca.converters.ProjectConverter;
import com.blazarczyk.praca.model.json.*;
import com.blazarczyk.praca.model.request.CreateProjectRequest;
import com.blazarczyk.praca.model.request.UserEmailRequest;
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

    @RequestMapping(path = "/projects/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ProjectJson getProject(@PathVariable(value = "id") Long id){
        return new ProjectJson(projectService.getProjectWithId(id));
    }

    @RequestMapping(path = "/projects/{id}/subscribe", method = RequestMethod.POST)
    @ResponseBody
    public void subscribeProject(@PathVariable(value = "id",required = false) Long projectId,
                                 @RequestBody UserEmailRequest userEmailRequest){
        projectService.addProjectToSubscribe(projectId, userEmailRequest.getEmail());
    }

    @RequestMapping(path = "/projects/{id}/unsubscribe", method = RequestMethod.POST)
    @ResponseBody
    public void unsubscribeProject(@PathVariable(value = "id",required = false) Long projectId,
                                 @RequestBody UserEmailRequest userEmailRequest){
        projectService.removeProjectFromSubscribe(projectId, userEmailRequest.getEmail());
    }

    @RequestMapping(path = "/projects/{id}/join", method = RequestMethod.POST)
    @ResponseBody
    public void joinProject(@PathVariable(value = "id",required = false) Long projectId,
                                 @RequestBody UserEmailRequest userEmailRequest){
        projectService.addUserToParticipator(projectId, userEmailRequest.getEmail());
    }

    @RequestMapping(path = "/projects/{id}/resign", method = RequestMethod.POST)
    @ResponseBody
    public void resignProject(@PathVariable(value = "id",required = false) Long projectId,
                                   @RequestBody UserEmailRequest userEmailRequest){
        projectService.removeUserFromParticipator(projectId, userEmailRequest.getEmail());
    }

    @RequestMapping(path = "/projects", method = RequestMethod.POST)
    @ResponseBody
    public void createProject(@RequestBody CreateProjectRequest createProjectRequest) {
        projectService.createProject(
                ProjectConverter.fromCreateProjectRequest(createProjectRequest)
        );
    }

    @RequestMapping(path = "/projects", method = RequestMethod.GET)
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

    @RequestMapping(path = "/projects/{id}/projectDetails", method = RequestMethod.GET)
    @ResponseBody
    public List<ProjectDetailJson> getProjectDetails(@PathVariable(value = "id") Long id){
        return (new ProjectJson(projectService.getProjectWithId(id))).getProjectDetails();
    }

    @RequestMapping(path = "/projects/{id}/links", method = RequestMethod.GET)
    @ResponseBody
    public List<LinkJson> getProjectLinks(@PathVariable(value = "id") Long id){
        return (new ProjectJson(projectService.getProjectWithId(id))).getLinks();
    }

    @RequestMapping(path = "/projects/{id}/tags", method = RequestMethod.GET)
    @ResponseBody
    public List<TagJson> getProjectTags(@PathVariable(value = "id") Long id){
        return (new ProjectJson(projectService.getProjectWithId(id))).getTags();
    }

    @RequestMapping(path = "/projects/{id}/participators", method = RequestMethod.GET)
    @ResponseBody
    public List<UserGeneralJson> getUsersByProjectId(@PathVariable(value = "id") Long project_id){
        List<UserGeneralJson> users = new LinkedList<>();
        userService.getUsersParticipatingInProjectById(project_id).forEach(x -> users.add(new UserGeneralJson(x)));
        return users;
    }

}
