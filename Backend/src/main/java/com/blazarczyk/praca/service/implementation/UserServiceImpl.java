package com.blazarczyk.praca.service.implementation;

import com.blazarczyk.praca.model.*;
import com.blazarczyk.praca.repository.*;
import com.blazarczyk.praca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    UniversityDAO universityDAO;

    @Autowired
    FacultyDAO facultyDAO;

    @Autowired
    SpecializationDAO specializationDAO;

    @Autowired
    ProjectDAO projectDAO;


    @Override
    public List<User> getUsersByUniversityId(long university_id) {
        return userDAO.findAllByUniversity(universityDAO.findById(university_id));
    }

    @Override
    public List<User> getUsersByFacultyId(long faculty_id) {
        return userDAO.findAllByFaculty(facultyDAO.findById(faculty_id));
    }

    @Override
    public List<User> getUsersBySpecializationId(long specialization_id) {
        return userDAO.findAllBySpecialization(specializationDAO.findById(specialization_id));
    }

    @Override
    public User getUserWithEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    public List<User> getUsersWithNameAndSurname(String name, String surname) {
        return userDAO.findAllByNameAndSurname(name,surname);
    }

    @Override
    public List<User> getUsersParticipatingInProjectById(long project_id) {
        return userDAO.findAllByParticipatedProjectsContaining(projectDAO.findById(project_id));
    }
}
