package optional.lab4;

import java.util.List;

public class Problem {

    private List<Student> students;
    private List<School> schools;

    public Problem(List<Student> students, List<School> schools) {
        this.students = students;
        this.schools = schools;
    }

    //find students who find acceptable a given list of schools
    public void acceptableListOfSchools(List<School> givenListOfSchools) {
        for (Student student : students) {
            if (student.getStudentPreferences().containsAll(givenListOfSchools)) {
                System.out.print(student + "\n");
            }
        }
    }

    //find schools that have givenStudent as their top preference
    public void topStudentPreference(Student givenStudent) {
        for (School school : schools) {
            if (school.getSchoolPreferences().get(0) == givenStudent) {
                System.out.print(school + "\n");
            }
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

}
