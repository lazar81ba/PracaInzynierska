package com.blazarczyk.praca.repository;

import com.blazarczyk.praca.model.Faculty;
import com.blazarczyk.praca.model.Specialization;
import com.blazarczyk.praca.model.University;
import com.blazarczyk.praca.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacultyDAO extends CrudRepository<Faculty, Long> {
    public Faculty findById(Long id);
    public List<Faculty> findAllByName(String name);
    public List<Faculty> findAllByUniversity(University university);
    public Faculty findByUsersContaining(User user);
    public List<Faculty> findAllBySpecializationsContaining(Specialization specialization);
}
