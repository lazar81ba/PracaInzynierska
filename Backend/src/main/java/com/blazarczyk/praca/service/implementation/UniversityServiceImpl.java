package com.blazarczyk.praca.service.implementation;

import com.blazarczyk.praca.model.University;
import com.blazarczyk.praca.repository.CountryDAO;
import com.blazarczyk.praca.repository.UniversityDAO;
import com.blazarczyk.praca.repository.UserDAO;
import com.blazarczyk.praca.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    UniversityDAO universityDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    CountryDAO countryDAO;

    @Override
    public University getUniversityWithName(String name) {
        return universityDAO.findByName(name);
    }

    @Override
    public University getUniversityWithAttendingStudent(long user_id) {
        return universityDAO.findByUsersContaining(userDAO.findById(user_id));
    }

    @Override
    public List<University> getAllUniversitiesInCountry(long country_id) {
        return universityDAO.findAllByCountry(countryDAO.findById(country_id));
    }
}
