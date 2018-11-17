package com.blazarczyk.praca.controller;

import com.blazarczyk.praca.model.json.ProjectJson;
import com.blazarczyk.praca.model.json.UserJson;
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

        return response;
    }

}
