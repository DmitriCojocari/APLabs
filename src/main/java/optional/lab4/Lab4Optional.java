package optional.lab4;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lab4Optional {

    public static void main(String[] args) {

        Faker faker = new Faker();

        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student(faker.name().fullName(), faker.number().randomDouble(2, 5, 10)))
                .toArray(Student[]::new);

        List<Student> studentList = new ArrayList<>(Arrays.asList(students));

        var schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School(faker.university().name(), (i + 1)))
                .toArray(School[]::new);

        List<School> schoolList = new ArrayList<>(Arrays.asList(schools));

        studentList.get(0).setStudentPreferences(new ArrayList<>(Arrays.asList(schools[0], schools[1], schools[2])));
        studentList.get(1).setStudentPreferences(new ArrayList<>(Arrays.asList(schools[0], schools[1], schools[2])));
        studentList.get(2).setStudentPreferences(new ArrayList<>(Arrays.asList(schools[0], schools[1])));
        studentList.get(3).setStudentPreferences(new ArrayList<>(Arrays.asList(schools[0], schools[2])));

        List<Student> school0Preferences = new ArrayList<>(Arrays.asList(students[3], students[0], students[1], students[2]));
        Collections.sort(school0Preferences, Collections.reverseOrder());
        schoolList.get(0).setSchoolPreferences(school0Preferences);

        List<Student> school1Preferences = new ArrayList<>(Arrays.asList(students[0], students[2], students[1]));
        Collections.sort(school1Preferences, Collections.reverseOrder());
        schoolList.get(1).setSchoolPreferences(school1Preferences);

        List<Student> school2Preferences = new ArrayList<>(Arrays.asList(students[0], students[1], students[3]));
        Collections.sort(school2Preferences, Collections.reverseOrder());
        schoolList.get(2).setSchoolPreferences(school2Preferences);

        System.out.println("Student List:");
        System.out.println(studentList.toString());
        System.out.println("School List:");
        System.out.println(schoolList.toString());

        Problem problem = new Problem(studentList, schoolList);

        System.out.println("\nList of students that find acceptable the given list of schools : ");
        List<School> givenListOfSchools = Arrays.asList(schools[1], schools[2]);
        problem.acceptableListOfSchools(givenListOfSchools);

        System.out.println("\nList of schools that accept the given student : ");
        problem.topStudentPreference(students[0]);

        System.out.println("\nSolution : ");
        SchoolAdmissionsSolution schoolAdmissionsSolution = new SchoolAdmissionsSolution(problem);
        schoolAdmissionsSolution.findMatches();
    }

}
