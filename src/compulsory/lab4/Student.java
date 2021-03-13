package compulsory.lab4;

import java.util.List;

public class Student {

    private String name;
    private List<School> studentPreferences;

    public Student(String name, List<School> studentPreferences) {
        this.name = name;
        this.studentPreferences = studentPreferences;
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<School> getStudentPreferences() {
        return studentPreferences;
    }

    public void setStudentPreferences(List<School> studentPreferences) {
        this.studentPreferences = studentPreferences;
    }

    @Override
    public String toString() {
        return "\n Student{" +
                " name= " + name + '\'' +
                '}';
    }
}
