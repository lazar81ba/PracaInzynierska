package com.blazarczyk.praca.controller;

import com.blazarczyk.praca.model.json.*;
import com.blazarczyk.praca.service.UniversityService;
import com.blazarczyk.praca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class UniversityController {

    @Autowired
    UniversityService universityService;

    @Autowired
    UserService userService;

    @RequestMapping(path = "/university/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UniversityJson getUniversityById(@PathVariable(value = "id") Long university_id){
        return new UniversityJson(universityService.getUniversityWithId(university_id));
    }

    @RequestMapping(path = "/university/{id}/faculties", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyJson> getUniversityFaculties(@PathVariable(value = "id") Long university_id){
        return (new UniversityJson(universityService.getUniversityWithId(university_id))).getFaculties();
    }

    @RequestMapping(path = "/university/{id}/faculties/{faculty_id}", method = RequestMethod.GET)
    @ResponseBody
    public FacultyJson getUniversityFaculties(@PathVariable(value = "id") Long university_id,
                                                    @PathVariable(value = "faculty_id") Long faculty_id){
        return (new UniversityJson(universityService.getUniversityWithId(university_id))).getFaculties()
                .stream()
                .filter(x -> x.getId() == faculty_id)
                .findFirst()
                .get();
    }

    @RequestMapping(path = "/university/{id}/faculties/{faculty_id}/specializations", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecializationGeneralJson> getUniversityFacultySpecializations(@PathVariable(value = "id") Long university_id,
                                              @PathVariable(value = "faculty_id") Long faculty_id){
        return (new UniversityJson(universityService.getUniversityWithId(university_id))).getFaculties()
                .stream()
                .filter(x -> x.getId() == faculty_id)
                .findFirst()
                .get()
                .getSpecializations();
    }


    @RequestMapping(path = "/university/{id}/country", method = RequestMethod.GET)
    @ResponseBody
    public CountryJson getUniversityCountry(@PathVariable(value = "id") Long university_id){
        return (new UniversityJson(universityService.getUniversityWithId(university_id))).getCountry();
    }

    @RequestMapping(path = "/university/{id}/users", method = RequestMethod.GET)
    @ResponseBody
    public List<UserJson> getUniversityUsersById(@PathVariable(value = "id") Long university_id){
        List<UserJson> users = new LinkedList<>();
        userService.getUsersByUniversityId(university_id).forEach(x -> users.add(new UserJson(x)));
        return users;
    }

    @RequestMapping(path = "/university", method = RequestMethod.GET)
    @ResponseBody
    public List<UniversityGeneralJson> getUniversitiesByStudentOrCountry(@RequestParam(value = "country_id", required = false) Long country_id){
        List<UniversityGeneralJson> response = new LinkedList<>();
        if (country_id != null) {
            universityService.getAllUniversitiesInCountry(country_id)
                    .stream()
                    .forEach(x -> response.add(new UniversityGeneralJson(x)));
        } else {
            universityService.getAllUniversities()
                    .stream()
                    .forEach(x -> response.add(new UniversityGeneralJson(x)));
        }
        return response;
    }

}
