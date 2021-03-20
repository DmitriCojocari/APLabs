package optional.lab4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class School {

    private String schoolName;
    private int capacity;
    private List<Student> schoolPreferences;
    private PriorityQueue<Student> matches;

    public School(String name, int capacity) {
        this.schoolName = name;
        this.schoolPreferences = new ArrayList<>();
        this.capacity = capacity;

        //ranks Students based on their positions in the schoolPreferences List
        //this Comparator ensures that the PriorityQueue is stores Students
        //in order of increasing preference
        Comparator<Student> ranking = (s1, s2) -> {
            int indexOne = School.this.schoolPreferences.indexOf(s1);
            int indexTwo = School.this.schoolPreferences.indexOf(s2);
            return indexTwo - indexOne;
        };
        this.matches = new PriorityQueue(capacity, ranking);
    }

    /**
     * A School can make offers if it has not reached its max. capacity of admitted Students
     * and it has Students to which it has not made an offer.
     *
     * @return true if this School can make offers, false otherwise
     */
    public boolean canMakeOffers() {
        return this.matches.size() < this.capacity && this.schoolPreferences.size() > 0;
    }

    /**
     * @param s The Student to remove from this School's admitted students
     */
    public void unMatchStudent(Student s) {
        this.matches.remove(s);
    }

    /**
     * This School makes offers to Students in preference order until it has reached
     * its capacity or runs out of Students to which it can make an offer.
     *
     * @return true if this School added a Student to its matches, false otherwise
     */
    public boolean makeOffers() {
        while (this.schoolPreferences.size() > 0 && this.matches.size() < this.capacity) {
            Student temp = this.schoolPreferences.remove(0);
            if (temp.acceptOffer(this)) {
                this.matches.add(temp);
                continue;
            }
        }
        return true;
    }

    /**
     * @return PriorityQueue<Student> The admitted Students for this School
     */
    public PriorityQueue<Student> getMatches() {
        return this.matches;
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
    public String toString() {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                ", capacity=" + capacity +
                '}';
    }

}
