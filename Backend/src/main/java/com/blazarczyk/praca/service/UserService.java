package com.blazarczyk.praca.service;

import com.blazarczyk.praca.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public User getUserById(long id);
    public List<User> getUsersByUniversityId(long university_id);
    public List<User> getUsersByFacultyId(long faculty_id);
    public List<User> getUsersBySpecializationId(long specialization_id);
    public User getUserByEmail(String email);
    public List<User> getUsersByNameAndSurname(String name, String surname);
    public List<User> getUsersParticipatingInProjectById(long project_id);
}
