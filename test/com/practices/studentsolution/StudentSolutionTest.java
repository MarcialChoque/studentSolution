import com.practices.studentsolution.StudentSolution;
import com.practices.studentsolution.core.entities.Student;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

/**
 * Created by andresmerida on 9/14/16.
 */
public class StudentSolutionTest {

    public static final int SIZE = 50000;

    public static void main(String[] args) throws Exception {
        testLoadStudents();
    }

    private static void testLoadStudents() throws IOException {
        StudentSolution fs = new StudentSolution();
        List<Student> students = fs.loadStudents(new StringReader(buildContent()));
        if(students.size() == SIZE) {
            System.out.println("TEST OK!");
        } else {
            System.out.println("TEST FAIL!");
        }
    }

    private static String buildContent() {
        StringBuilder b = new StringBuilder();
        int i = 1;
        String[] types = {"Kinder", "High", "University", "Elementary"};
        String[] genders = {"M", "F"};
        while (i <= SIZE) {
            String type = types[(int) (Math.random() * 4)];
            String gender = genders[(int) (Math.random() * 2)];
            String name = "Name" + i;
            b.append(String.format("%s,%s,%s,%s\n", type, name, gender, "20130129080903"));
            i++;
        }
        return b.toString();
    }
}
