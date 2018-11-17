package com.blazarczyk.praca.repository;

import com.blazarczyk.praca.model.Country;
import com.blazarczyk.praca.model.University;
import com.blazarczyk.praca.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UniversityDAO extends CrudRepository<University, Long> {
    public University findById(Long id);
    public University findByName(String name);
    public University findByUsersContaining(User user);
    public List<University> findAllByCountry(Country country);
}
