package com.blazarczyk.praca.service.implementation;

import com.blazarczyk.praca.model.databse.Specialization;
import com.blazarczyk.praca.repository.FacultyDAO;
import com.blazarczyk.praca.repository.SpecializationDAO;
import com.blazarczyk.praca.repository.UserDAO;
import com.blazarczyk.praca.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationServiceImpl implements SpecializationService {

    @Autowired
    SpecializationDAO specializationDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    FacultyDAO facultyDAO;

    @Override
    public List<Specialization> getAllSpecializationsWithName(String name) {
        return specializationDAO.findAllByName(name);
    }

    @Override
    public List<Specialization> getSpecializationsWithinFaculty(long faculty_id) {
        return specializationDAO.findAllByFacultiesContaining(facultyDAO.findById(faculty_id));
    }

    @Override
    public Specialization getSpecializationAttendingByStudent(long user_id) {
        return specializationDAO.findByUsersContaining(userDAO.findById(user_id));
    }
}
