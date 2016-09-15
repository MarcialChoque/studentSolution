package com.practices.studentsolution.core.utils;

import com.practices.studentsolution.core.entities.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andresmerida on 9/14/16.
 */
public class SingleCreateStudent {

    //create an object of SingleCreateStudent
    private static SingleCreateStudent instance = new SingleCreateStudent();

    private static final String DEFAULT_DELIMITER = ",";

    //make the constructor private so that this class cannot be
    //instantiated
    private SingleCreateStudent(){}

    //Get the only object available
    public static SingleCreateStudent getInstance(){
        return instance;
    }

    public Student getNewStudent(String line){
        Student student = new Student();
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(DEFAULT_DELIMITER);
        int index = 0;
        while (scanner.hasNext()) {
            String data = scanner.next();
            if (index == 0)
                student.setType(data);
            else if (index == 1)
                student.setName(data);
            else if (index == 2)
                student.setGender(data.charAt(0));
            else if (index == 3)
                student.setUpdated(DateUtil.getDateYyyyMMddHHmmssFormat(data));
            else
                System.out.println("invalid data::" + data);
            index++;
        }

        return student;
    }

    public String getDefaultDelimiter() {
        return DEFAULT_DELIMITER;
    }
}
