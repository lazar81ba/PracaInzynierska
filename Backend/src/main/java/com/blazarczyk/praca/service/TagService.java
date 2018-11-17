package com.blazarczyk.praca.service;

import com.blazarczyk.praca.model.Tag;

import java.util.List;

public interface TagService {
    Tag getTagWithName(String name);
    List<Tag> getAllTags();
}
