package com.blazarczyk.praca.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "country", schema = "public")
public class Country {

    @Id
    private long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "country")
    private Set<University> universities;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<University> getUniversities() {
        return universities;
    }

    public void setUniversities(Set<University> universities) {
        this.universities = universities;
    }


}
