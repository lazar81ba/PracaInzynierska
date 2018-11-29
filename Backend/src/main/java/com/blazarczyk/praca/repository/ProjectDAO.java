package com.blazarczyk.praca.repository;

import com.blazarczyk.praca.model.databse.Project;
import com.blazarczyk.praca.model.databse.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectDAO extends CrudRepository<Project, Long>, JpaSpecificationExecutor<Project> {
    public Project findById(Long id);
    public List<Project> findByNameContainingIgnoreCase(String name);
    public List<Project> findAllByProjectParticipantsContaining(User user);


}
