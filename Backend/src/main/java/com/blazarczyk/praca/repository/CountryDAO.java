package com.blazarczyk.praca.repository;

import com.blazarczyk.praca.model.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryDAO extends CrudRepository<Country, Long> {
    public Country findById(Long id);
    public Country findByName(String name);
    @Query("select c from Country c")
    public List<Country> getAll();
}
