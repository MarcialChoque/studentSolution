package com.practices.studentsolution;

import com.practices.studentsolution.core.entities.Student;
import com.practices.studentsolution.core.services.StudentService;
import com.practices.studentsolution.core.utils.SingleCreateStudent;
import com.practices.studentsolution.core.StudentFactory;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by andresmerida on 9/14/16.
 */
public class StudentSolution {

    private final static Logger LOGGER = Logger.getLogger(StudentSolution.class.getName());
    //private static final ClassLoader loader = StudentSolution.class.getClassLoader();

    public static void main(String[] args) throws IOException {
        LOGGER.info("loading student from csv file...");
        StudentSolution studentSolution = new StudentSolution();
        studentSolution.loadStudents();
        LOGGER.info("students loaded");
    }

    public List<Student> loadStudents() throws IOException {
        //BufferedReader reader = new BufferedReader(new FileReader("/Users/andresmerida/dev/input.csv"));
        FileInputStream fileInputStream= null;
        List<Student> studentList = new ArrayList<>();
        try {
            //ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(getClass().getResource("input.csv").getFile());
            fileInputStream = new FileInputStream(file);

            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

            // read file line by line
            String line = null;

            while ((line = reader.readLine()) != null) {
                StudentFactory studentFactory = new StudentFactory();
                StudentService studentService = studentFactory.getStudent(line.substring(0,
                        line.indexOf(SingleCreateStudent.getInstance().getDefaultDelimiter())));
                studentList.add(studentService.createStudent(line));
            }

            LOGGER.info("studentList size = "+studentList.size());
            for (Student student : studentList) {
                System.out.println(new Timestamp(student.getUpdated().getTime()));
            }

            //close reader
            fileInputStream.close();
            reader.close();
            return studentList;
        } catch (FileNotFoundException e) {
            System.out.println("eror directory");
            e.printStackTrace();
        }finally {
            fileInputStream.close();
        }

        return studentList;
    }
}
