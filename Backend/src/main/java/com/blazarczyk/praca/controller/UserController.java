package com.blazarczyk.praca.controller;

import com.blazarczyk.praca.model.databse.Specialization;
import com.blazarczyk.praca.model.json.*;
import com.blazarczyk.praca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/user/{email:.+}", method = RequestMethod.GET)
    @ResponseBody
    public UserJson getUser(@PathVariable(value = "email") String email){
        return new UserJson(userService.getUserWithEmail(email));
    }

    @RequestMapping(path = "/user/{email:.+}/university", method = RequestMethod.GET)
    @ResponseBody
    public UniversityGeneralJson getUserUniversity(@PathVariable(value = "email") String email){
        return (new UserJson(userService.getUserWithEmail(email))).getUniversity();
    }

    @RequestMapping(path = "/user/{email:.+}/faculty", method = RequestMethod.GET)
    @ResponseBody
    public FacultyGeneralJson getUserFaculty(@PathVariable(value = "email") String email){
        return (new UserJson(userService.getUserWithEmail(email))).getFaculty();
    }

    @RequestMapping(path = "/user/{email:.+}/specialization", method = RequestMethod.GET)
    @ResponseBody
    public SpecializationGeneralJson getUserSpecialization(@PathVariable(value = "email") String email){
        return (new UserJson(userService.getUserWithEmail(email))).getSpecialization();
    }

    @RequestMapping(path = "/user/{email:.+}/participatedProjects", method = RequestMethod.GET)
    @ResponseBody
    public List<ProjectGeneralJson> getUserParticipatedProjects(@PathVariable(value = "email") String email){
        return (new UserJson(userService.getUserWithEmail(email))).getParticipatedProjects();
    }

    @RequestMapping(path = "/user/{email:.+}/participatedProjects/{project_id}", method = RequestMethod.GET)
    @ResponseBody
    public ProjectGeneralJson getUserParticipatedProject(@PathVariable(value = "email") String email,
                                                         @PathVariable(value = "project_id")Long id){
        return (new UserJson(userService.getUserWithEmail(email))).getParticipatedProjects()
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .get();
    }

    @RequestMapping(path = "/user/{email:.+}/observedProjects", method = RequestMethod.GET)
    @ResponseBody
    public List<ProjectGeneralJson> getUserObservedProjects(@PathVariable(value = "email") String email){
        return (new UserJson(userService.getUserWithEmail(email))).getObservedProjects();
    }

    @RequestMapping(path = "/user/{email:.+}/observedProjects/{project_id}", method = RequestMethod.GET)
    @ResponseBody
    public ProjectGeneralJson getUserObservedProject(@PathVariable(value = "email") String email,
                                                     @PathVariable(value = "project_id")Long id){
        return (new UserJson(userService.getUserWithEmail(email))).getObservedProjects()
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .get();
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<UserJson> getUsersByNameAndSurname(@RequestParam(value = "name")String name,
                                                   @RequestParam(value = "surname")String surname){
        List<UserJson> users = new LinkedList<>();
        userService.getUsersWithNameAndSurname(name, surname).forEach(x -> users.add(new UserJson(x)));
        return users;
    }



//    @RequestMapping(path = "/user", method = RequestMethod.POST)
//    public void createUser(@RequestBody UserJson user){
//        userService.createUser(user);
//    }
//

}
