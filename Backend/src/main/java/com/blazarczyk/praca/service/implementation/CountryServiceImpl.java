package com.blazarczyk.praca.service.implementation;

import com.blazarczyk.praca.model.Country;
import com.blazarczyk.praca.repository.CountryDAO;
import com.blazarczyk.praca.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryDAO countryDAO;

    @Override
    public Country getCountryWithName(String name) {
        return countryDAO.findByName(name);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryDAO.getAll();
    }
}
