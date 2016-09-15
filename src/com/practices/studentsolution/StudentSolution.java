package com.practices.studentsolution;

import com.practices.studentsolution.core.entities.Student;
import com.practices.studentsolution.core.services.StudentService;
import com.practices.studentsolution.core.utils.SingleCreateStudent;
import com.practices.studentsolution.core.StudentFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by andresmerida on 9/14/16.
 */
public class StudentSolution {

    public final static Logger LOGGER = Logger.getLogger(StudentSolution.class.getName());
    public final static String INPUT_NAME = "name";
    public final static String EQUAL_SIMBOL = "=";
    public final static Character GENDER_FEMALE = 'F';
    public final static Character GENDER_MALE = 'M';

    List<Student> students;

    public static void main(String[] args) throws IOException {
        LOGGER.info("loading student from csv file...");
        StudentSolution studentSolution = new StudentSolution();
        studentSolution.students = studentSolution.loadStudents(args[0]);

        int index = args[1].indexOf(EQUAL_SIMBOL);
        String argName = args[1].substring(0, index);
        String argValue = args[1].substring(index+1);

        if (args.length < 3) {
            if(argName.equals(INPUT_NAME)){
                studentSolution.fingStudentByName(argValue);
            } else {
                studentSolution.findStudentsByType(argValue);
            }
        }else {
            studentSolution.findStudentsByTypeAndGender(argValue, args[2].charAt(0) == 'f'?GENDER_FEMALE:GENDER_MALE);
        }

        LOGGER.info("students loaded");
    }

    private List<Student> loadStudents(String fileName) throws IOException {
        File file = new File(getClass().getResource(fileName).getFile());
        List<Student> students;
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            students = loadStudents(new InputStreamReader(fileInputStream));
        }
        return students;
    }

    public List<Student> loadStudents(Reader r) throws IOException {
        List<Student> studentList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(r);

        // read file line by line
        String line = null;

        while ((line = reader.readLine()) != null) {
            StudentFactory studentFactory = new StudentFactory();
            StudentService studentService = studentFactory.getStudent(line.substring(0,
                    line.indexOf(SingleCreateStudent.getInstance().getDefaultDelimiter())));
            studentList.add(studentService.createStudent(line));
        }

        LOGGER.info("studentList size = " + studentList.size());

        //close reader
        reader.close();

        return studentList;
    }

    // find student or students by name
    public void fingStudentByName(String name) {
        final List<Student> studentsFinged = new ArrayList<>();

        for (Student student : students) {
            if(student.getName().equalsIgnoreCase(name)) {
                studentsFinged.add(student);
            }
        }

        if (studentsFinged.size() > 0 ) {
            this.showStudents(studentsFinged.iterator());
        } else {
            System.out.println("There aro not students with name = "+name);
        }
    }

    public void findStudentsByType(String type) {
        final List<Student> studentsFinged = new ArrayList<>();

        for (Student student : students) {
            if(student.getType().equals(type)) {
                studentsFinged.add(student);
            }
        }

        if (studentsFinged.size() > 0 ) {
            this.showStudents(studentsFinged.iterator());
        } else {
            System.out.println("There aro not students with type = "+type);
        }
    }

    public void findStudentsByTypeAndGender(String type, Character gender) {
        final List<Student> studentsFinged = new ArrayList<>();

        for (Student student : students) {
            if(student.getType().equalsIgnoreCase(type) && student.getGender() == gender) {
                studentsFinged.add(student);
            }
        }

        if (studentsFinged.size() > 0 ) {
            Collections.sort(studentsFinged, Collections.reverseOrder());
            this.showStudents(studentsFinged.iterator());
        } else {
            System.out.println("There aro not students with gender = "+gender);
        }
    }

    public void showStudents(Iterator<Student> students) {
        while (students.hasNext()) {
            System.out.println(students.next().toString());
        }
    }
}
