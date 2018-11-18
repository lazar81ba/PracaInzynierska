package com.blazarczyk.praca.service;

import com.blazarczyk.praca.model.databse.Specialization;

import java.util.List;

public interface SpecializationService {
    Specialization getSpecializationWithId(Long id);
    List<Specialization> getAllSpecializationsWithName(String name);
    List<Specialization> getSpecializationsWithinFaculty(long faculty_id);
    Specialization getSpecializationAttendingByStudent(long user_id);
}
