package com.practices.studentsolution.core;

import com.practices.studentsolution.core.services.StudentService;
import com.practices.studentsolution.core.services.impl.ElementaryStudentServiceImpl;
import com.practices.studentsolution.core.services.impl.KinderStudentServiceImpl;
import com.practices.studentsolution.core.services.impl.HighStudentServiceImpl;
import com.practices.studentsolution.core.services.impl.UniversityStudentServiceImpl;

/**
 * Created by andresmerida on 9/14/16.
 */
public class StudentFactory {

    //use getStudent method to get object of type student
    public StudentService getStudent(String studentType){
        if(studentType == null){
            return null;
        }
        if(studentType.equalsIgnoreCase("KINDER")){
            return new KinderStudentServiceImpl();

        } else if(studentType.equalsIgnoreCase("ELEMENTARY")){
            return new ElementaryStudentServiceImpl();

        } else if(studentType.equalsIgnoreCase("HIGH")){
            return new HighStudentServiceImpl();

        } else if(studentType.equalsIgnoreCase("UNIVERSITY")) {
            return new UniversityStudentServiceImpl();
        }

        return null;
    }
}
