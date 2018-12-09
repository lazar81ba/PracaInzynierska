package com.blazarczyk.praca.model.request;

import com.blazarczyk.praca.model.databse.Link;
import com.blazarczyk.praca.model.databse.ProjectDetail;
import com.blazarczyk.praca.model.databse.Tag;
import com.blazarczyk.praca.model.json.LinkJson;
import com.blazarczyk.praca.model.json.ProjectDetailJson;
import com.blazarczyk.praca.model.json.TagJson;

import javax.persistence.*;
import java.util.Set;

public class CreateProjectRequest {

    private String name;
    private String description;
    private String imageURL;
    private boolean publicProject;
    private Set<ProjectDetailJson> projectDetails;
    private Set<LinkJson> links;
    private Set<TagJson> tags;

}
