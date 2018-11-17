package com.blazarczyk.praca.service;

import com.blazarczyk.praca.model.databse.Country;

import java.util.List;

public interface CountryService {
    Country getCountryWithName(String name);
    List<Country> getAllCountries();
}
