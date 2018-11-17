package com.blazarczyk.praca.model.json;


import com.blazarczyk.praca.model.databse.Tag;

public class TagJson {
    private long id;
    private String name;

    public TagJson() {
    }

    public TagJson(Tag tag) {
        id = tag.getId();
        name = tag.getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
