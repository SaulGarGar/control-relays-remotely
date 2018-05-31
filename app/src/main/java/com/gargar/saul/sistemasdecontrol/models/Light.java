package com.gargar.saul.sistemasdecontrol.models;

/**
 * Created by saul on 31/05/18.
 */

public class Light {

    private Boolean state;
    private String id;

    public Light(Boolean state, String id) {
        this.state = state;
        this.id = id;
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
}
