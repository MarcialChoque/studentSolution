package com.practices.studentsolution.core.entities;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by andresmerida on 9/14/16.
 */
public class Student implements Comparable<Student> {

    private String type;
    private String name;
    private Character gender;
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

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Student{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", updated=" + new Timestamp(updated.getTime()) +
                '}';
    }

    @Override
    public int compareTo(Student student) {
        return getUpdated().compareTo(student.getUpdated());
    }
}
