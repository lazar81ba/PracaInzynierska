package com.blazarczyk.praca.model.json;


import com.blazarczyk.praca.model.databse.Link;

public class LinkJson {

    private long id;
    private String address;

    public LinkJson() {
    }

    public LinkJson(Link link) {
        id = link.getId();
        address = link.getAddress();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
