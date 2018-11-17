package com.blazarczyk.praca.service;

import com.blazarczyk.praca.model.databse.User;

import java.util.List;

public interface UserService {
    public void createUser(User user);
    List<User> getUsersByUniversityId(long university_id);
    List<User> getUsersByUniversityName(String name);
    List<User> getUsersByFacultyId(long faculty_id);
    List<User> getUsersBySpecializationId(long specialization_id);
    User getUserWithEmail(String email);
    List<User> getUsersWithNameAndSurname(String name, String surname);
    List<User> getUsersParticipatingInProjectById(long project_id);
}
