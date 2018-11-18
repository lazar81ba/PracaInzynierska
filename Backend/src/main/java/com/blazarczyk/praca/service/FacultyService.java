package com.blazarczyk.praca.service;

import com.blazarczyk.praca.model.databse.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty getFacultyWithId(long id);
    List<Faculty> getFacultiesWithName(String name);
    List<Faculty> getAllFacultiesInUniversity(long university_id);
    Faculty getFacultyWithAttendingStudent(long user_id);
    List<Faculty> getFacultiesWithSpecialization(long specialization_id);
}
