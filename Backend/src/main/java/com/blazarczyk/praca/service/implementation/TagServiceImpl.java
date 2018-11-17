package com.blazarczyk.praca.service.implementation;

import com.blazarczyk.praca.model.Tag;
import com.blazarczyk.praca.repository.TagDAO;
import com.blazarczyk.praca.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    
    @Autowired
    TagDAO tagDAO;

    @Override
    public Tag getTagWithName(String name) {
        return tagDAO.findByName(name);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagDAO.getAll();
    }
}
