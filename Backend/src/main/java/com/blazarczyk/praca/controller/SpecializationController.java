package com.blazarczyk.praca.controller;

import com.blazarczyk.praca.model.json.*;
import com.blazarczyk.praca.service.SpecializationService;
import com.blazarczyk.praca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class SpecializationController {

    @Autowired
    UserService userService;

    @Autowired
    SpecializationService specializationService;

    @RequestMapping(path = "/specialization/{id}/users", method = RequestMethod.GET)
    @ResponseBody
    public List<UserGeneralJson> getSpecializationUsers(@PathVariable(value = "id") Long specialization_id){
        List<UserGeneralJson> users = new LinkedList<>();
        userService.getUsersBySpecializationId(specialization_id).forEach(x -> users.add(new UserGeneralJson(x)));
        return users;
    }

    @RequestMapping(path = "/specialization/{id}/faculties", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyGeneralJson> getSpecializationFaculties(@PathVariable(value = "id") Long specialization_id){
        return new SpecializationJson(specializationService.getSpecializationWithId(specialization_id)).getFaculties();

    }

    @RequestMapping(path = "/specialization/{id}/faculties/{faculty_id}", method = RequestMethod.GET)
    @ResponseBody
    public FacultyGeneralJson getSpecializationFaculties(@PathVariable(value = "id") Long specialization_id,
                                                         @PathVariable(value = "faculty_id") Long faculty_id){
        return new SpecializationJson(specializationService.getSpecializationWithId(specialization_id)).getFaculties()
                .stream()
                .filter(x -> x.getId() == faculty_id)
                .findFirst()
                .get();
    }

    @RequestMapping(path = "/specialization/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SpecializationJson getSpecialization(@PathVariable(value = "id") Long specialization_id){
        return new SpecializationJson(specializationService.getSpecializationWithId(specialization_id));
    }

    @RequestMapping(path = "/specialization", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecializationGeneralJson> getSpecializationsByNameOrFaculty(@RequestParam(value = "name",required = false)String name,
                                                                             @RequestParam(value = "faculty_id", required = false) Long faculty_id){
        List<SpecializationGeneralJson> response = new LinkedList<>();
        if (name!= null)
            specializationService.getAllSpecializationsWithName(name).forEach(x -> response.add(new SpecializationGeneralJson(x)));
        else if (faculty_id != null)
            specializationService.getSpecializationsWithinFaculty(faculty_id).forEach(x -> response.add(new SpecializationGeneralJson(x)));
        return response;
    }
}
