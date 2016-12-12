/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turtleworks.model.dto;

/**
 *
 * @author José Acuña
 */
public class Brand {

    private Short id;
    private String name;
    private Boolean active;

    public Brand() {
    }

    public Brand(Short id, String name, Boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Brand{" + "id=" + id + ", name=" + name + ", active=" + active + '}';
    }

}
