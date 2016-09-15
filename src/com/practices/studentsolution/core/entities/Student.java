package com.practices.studentsolution.core.entities;

import java.util.Date;

/**
 * Created by andresmerida on 9/14/16.
 */
public class Student {

    private String type;
    private String name;
    private String gender;
    private Date updated;

    public Student() {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
