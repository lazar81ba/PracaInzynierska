package com.blazarczyk.praca.controller;

import com.blazarczyk.praca.model.databse.User;
import com.blazarczyk.praca.model.json.UserJson;
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


    @RequestMapping(path = "/university/{id}/users", method = RequestMethod.GET)
    @ResponseBody
    public List<UserJson> getUniversityUsersById(@PathVariable(value = "id") Long university_id){
        List<UserJson> users = new LinkedList<>();
        userService.getUsersByUniversityId(university_id).forEach(x -> users.add(new UserJson(x)));
        return users;
    }

    @RequestMapping(path = "/faculty/{id}/users", method = RequestMethod.GET)
    @ResponseBody
    public List<UserJson> getFacultyUsers(@PathVariable(value = "id") Long faculty_id){
        List<UserJson> users = new LinkedList<>();
        userService.getUsersByFacultyId(faculty_id).forEach(x -> users.add(new UserJson(x)));
        return users;
    }

    @RequestMapping(path = "/specialization/{id}/users", method = RequestMethod.GET)
    @ResponseBody
    public List<UserJson> getSpecializationUsers(@PathVariable(value = "id") Long specialization_id){
        List<UserJson> users = new LinkedList<>();
        userService.getUsersBySpecializationId(specialization_id).forEach(x -> users.add(new UserJson(x)));
        return users;
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<UserJson> getUsersByNameAndSurname(@RequestParam(value = "name")String name,
                                               @RequestParam(value = "surname")String surname){
        List<UserJson> users = new LinkedList<>();
        userService.getUsersWithNameAndSurname(name, surname).forEach(x -> users.add(new UserJson(x)));
        return users;
    }

    @RequestMapping(path = "/project/{id}/users", method = RequestMethod.GET)
    @ResponseBody
    public List<UserJson> getUsersByProjectId(@PathVariable(value = "id") Long project_id){
        List<UserJson> users = new LinkedList<>();
        userService.getUsersParticipatingInProjectById(project_id).forEach(x -> users.add(new UserJson(x)));
        return users;
    }

//    @RequestMapping(path = "/user", method = RequestMethod.POST)
//    public void createUser(@RequestBody UserJson user){
//        userService.createUser(user);
//    }
//

}
