package compulsory.lab4;

import java.util.List;

public class School implements Comparable<School> {

    private String schoolName;
    private int capacity;
    private List<Student> schoolPreferences;

    public School(String schoolName, int capacity, List<Student> schoolPreferences) {
        this.schoolName = schoolName;
        this.capacity = capacity;
        this.schoolPreferences = schoolPreferences;
    }

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getSchoolPreferences() {
        return schoolPreferences;
    }

    public void setSchoolPreferences(List<Student> schoolPreferences) {
        this.schoolPreferences = schoolPreferences;
    }

    @Override
    public int compareTo(School school) {
        int compareValue = this.schoolName.compareTo(school.schoolName);
        return compareValue;
    }

    @Override
    public String toString() {
        return "\n School{" +
                "schoolName='" + schoolName + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
