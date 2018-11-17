package com.blazarczyk.praca.repository;

import com.blazarczyk.praca.model.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TagDAO extends CrudRepository<Tag, Long> {
    public Tag findById(Long id);
    public Tag findByName(String name);
    @Query("select t from Tag t")
    public List<Tag> getAll();
}
