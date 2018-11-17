package com.blazarczyk.praca.repository;

import com.blazarczyk.praca.model.databse.Faculty;
import com.blazarczyk.praca.model.databse.Specialization;
import com.blazarczyk.praca.model.databse.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpecializationDAO extends CrudRepository<Specialization, Long> {
    public Specialization findById(Long id);
    public List<Specialization> findAllByName(String name);
    public List<Specialization> findAllByFacultiesContaining(Faculty faculty);
    public Specialization findByUsersContaining(User user);


}
