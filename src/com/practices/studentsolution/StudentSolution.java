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

    private final static Logger LOGGER = Logger.getLogger(StudentSolution.class.getName());
    public final static String INPUT_FILE_NAME = "input.csv";

    public static void main(String[] args) throws IOException {
        LOGGER.info("loading student from csv file...");
        StudentSolution studentSolution = new StudentSolution();
        List<Student> students = studentSolution.loadStudents();
        studentSolution.findStudentsByGender(students, 'F');
        LOGGER.info("students loaded");
    }

    private List<Student> loadStudents() throws IOException {
        File file = new File(getClass().getResource(INPUT_FILE_NAME).getFile());
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
    public void fingStudentByName(List<Student> students, String name) {
        final List<Student> studentsFinged = new ArrayList<>();

        for (Student student : students) {
            if(student.getName().equals(name)) {
                studentsFinged.add(student);
            }
        }

        if (studentsFinged.size() > 0 ) {
            this.showStudents(studentsFinged.iterator());
        } else {
            System.out.println("There aro not students with name = "+name);
        }
    }

    public void findStudentsByType(List<Student> students, String type) {
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

    public void findStudentsByGender(List<Student> students, Character gender) {
        final List<Student> studentsFinged = new ArrayList<>();

        for (Student student : students) {
            if(student.getGender() == gender) {
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
