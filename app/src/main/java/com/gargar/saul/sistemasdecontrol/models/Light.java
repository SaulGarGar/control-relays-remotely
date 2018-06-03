package com.gargar.saul.sistemasdecontrol.models;

/**
 * Created by saul on 31/05/18.
 */

public class Light {

    private Boolean state;
    private String id;
    private String name;

    public Light(Boolean state, String id, String name) {
        this.state = state;
        this.id = id;
        this.name = name;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
