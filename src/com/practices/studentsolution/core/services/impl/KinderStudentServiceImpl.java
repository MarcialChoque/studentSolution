package com.practices.studentsolution.core.services.impl;

import com.practices.studentsolution.core.entities.Student;
import com.practices.studentsolution.core.services.StudentService;
import com.practices.studentsolution.core.utils.SingleCreateStudent;

import java.util.logging.Logger;

/**
 * Created by andresmerida on 9/14/16.
 */
public class KinderStudentServiceImpl implements StudentService {

    private final static Logger LOGGER = Logger.getLogger(KinderStudentServiceImpl.class.getName());

    @Override
    public Student createStudent(String lineCvsFile) {
        LOGGER.info("creating kinder student");
        return SingleCreateStudent.getInstance().getNewStudent(lineCvsFile);
    }
}
