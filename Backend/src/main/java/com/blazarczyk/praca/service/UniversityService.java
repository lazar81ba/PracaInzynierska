package com.blazarczyk.praca.service;

import com.blazarczyk.praca.model.databse.University;

import java.util.List;

public interface UniversityService {
    University getUniversityWithName(String name);
    University getUniversityWithAttendingStudent(long user_id);
    List<University> getAllUniversitiesInCountry(long country_id);
}
