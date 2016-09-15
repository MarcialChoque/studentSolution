package com.practices.studentsolution.core.services.impl;

import com.practices.studentsolution.core.services.StudentService;
import com.practices.studentsolution.core.utils.SingleCreateStudent;
import com.practices.studentsolution.core.entities.Student;

import java.util.logging.Logger;

/**
 * Created by andresmerida on 9/14/16.
 */
public class ElementaryStudentServiceImpl implements StudentService {

    private final static Logger LOGGER = Logger.getLogger(ElementaryStudentServiceImpl.class.getName());

    @Override
    public Student createStudent(String lineCvsFile) {
        LOGGER.info("creating elementary student");
        return SingleCreateStudent.getInstance().getNewStudent(lineCvsFile);
    }
}
