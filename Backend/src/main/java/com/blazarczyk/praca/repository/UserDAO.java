package com.blazarczyk.praca.repository;

import com.blazarczyk.praca.model.databse.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDAO extends CrudRepository<User, Long> {
    public User findById(Long id);
    public List<User> findAllByUniversity(University university);
    public List<User> findAllByFaculty(Faculty faculty);
    public List<User> findAllBySpecialization(Specialization specialization);
    public User findByEmail(String email);
    public List<User> findAllByNameAndSurname(String name, String surname);
    public List<User> findAllByParticipatedProjectsContaining(Project project);
}
