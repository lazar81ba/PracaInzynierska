package com.blazarczyk.praca.controller;

import com.blazarczyk.praca.model.json.*;
import com.blazarczyk.praca.service.FacultyService;
import com.blazarczyk.praca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class FacultyController {

    @Autowired
    UserService userService;

    @Autowired
    FacultyService facultyService;

    @RequestMapping(path = "/faculty/{id}/users", method = RequestMethod.GET)
    @ResponseBody
    public List<UserGeneralJson> getFacultyUsers(@PathVariable(value = "id") Long faculty_id){
        List<UserGeneralJson> users = new LinkedList<>();
        userService.getUsersByFacultyId(faculty_id).forEach(x -> users.add(new UserGeneralJson(x)));
        return users;
    }

    @RequestMapping(path = "/faculty/{id}", method = RequestMethod.GET)
    @ResponseBody
    public FacultyJson getFaculty(@PathVariable(value = "id") Long faculty_id){
        return new FacultyJson(facultyService.getFacultyWithId(faculty_id));
    }


    @RequestMapping(path = "/faculty/{id}/specializations", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecializationGeneralJson> getFacultySpecializations(@PathVariable(value = "id") Long faculty_id){
        return new FacultyJson(facultyService.getFacultyWithId(faculty_id)).getSpecializations();
    }

    @RequestMapping(path = "/faculty/{id}/specializations/{specialization_id}", method = RequestMethod.GET)
    @ResponseBody
    public SpecializationGeneralJson getFacultySpecialization(@PathVariable(value = "id") Long faculty_id,
                                                              @PathVariable(value = "specialization_id") Long specialization_id){
        return new FacultyJson(facultyService.getFacultyWithId(faculty_id)).getSpecializations()
                .stream()
                .filter(x -> x.getId() == specialization_id)
                .findFirst()
                .get();
    }

    @RequestMapping(path = "/faculty", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyGeneralJson> getUsersByNameAndSurname(@RequestParam(value = "name",required = false)String name,
                                                             @RequestParam(value = "university_id", required = false) Long university_id,
                                                             @RequestParam(value = "specialization_id", required = false) Long specialization_id){
        List<FacultyGeneralJson> response = new LinkedList<>();
        if (name!= null)
            facultyService.getFacultiesWithName(name).forEach(x -> response.add(new FacultyGeneralJson(x)));
        else if (university_id != null)
            facultyService.getAllFacultiesInUniversity(university_id).forEach(x -> response.add(new FacultyGeneralJson(x)));
        else if (specialization_id != null)
            facultyService.getFacultiesWithSpecialization(specialization_id).forEach(x -> response.add(new FacultyGeneralJson(x)));
        return response;
    }

}
