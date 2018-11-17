package com.blazarczyk.praca.service.implementation;

import com.blazarczyk.praca.model.Faculty;
import com.blazarczyk.praca.repository.FacultyDAO;
import com.blazarczyk.praca.repository.SpecializationDAO;
import com.blazarczyk.praca.repository.UniversityDAO;
import com.blazarczyk.praca.repository.UserDAO;
import com.blazarczyk.praca.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    FacultyDAO facultyDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    SpecializationDAO specializationDAO;

    @Autowired
    UniversityDAO universityDAO;

    @Override
    public List<Faculty> getFacultiesWithName(String name) {
        return facultyDAO.findAllByName(name);
    }

    @Override
    public List<Faculty> getAllFacultiesInUniversity(long university_id) {
        return facultyDAO.findAllByUniversity(universityDAO.findById(university_id));
    }

    @Override
    public Faculty getFacultyWithAttendingStudent(long user_id) {
        return facultyDAO.findByUsersContaining(userDAO.findById(user_id));
    }

    @Override
    public List<Faculty> getFacultiesWithSpecialization(long specialization_id) {
        return facultyDAO.findAllBySpecializationsContaining(specializationDAO.findById(specialization_id));
    }
}
