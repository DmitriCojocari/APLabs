package compulsory.lab4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lab4Compulsory {

    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("Student" + i))
                .toArray(Student[]::new);

        List<Student> studentList = new LinkedList<>();
        Collections.addAll(studentList, students);

        LinkedList<Student> sortedStudentList = studentList.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("Sorted student list by name: \n" + sortedStudentList.toString());

        var schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("School" + i, (i + 1) * 10, new ArrayList<Student>()))
                .toArray(School[]::new);

        Set<School> schoolSet = new TreeSet<>();
        Collections.addAll(schoolSet, schools);

        System.out.println(schoolSet.toString());


        Map<Student, List<School>> stdPrefMap = new HashMap<>();

        stdPrefMap.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[2], Arrays.asList(schools[0], schools[1]));
        stdPrefMap.put(students[3], Arrays.asList(schools[0], schools[2]));

        System.out.println("Preferences for studs: \n" + stdPrefMap);

        Map<School, List<Student>> schPrefMap = new TreeMap<>();
        schPrefMap.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        schPrefMap.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        schPrefMap.put(schools[2], Arrays.asList(students[0], students[1], students[3]));

        System.out.println("Preferences for schools: \n" + schPrefMap);

    }
}
