package optional.lab4;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {

    private String name;
    private List<School> studentPreferences;
    private School match;
    private Double evaluationExamScore;

    public Student(String name, Double evaluationExamScore) {
        this.name = name;
        this.studentPreferences = new ArrayList<>();
        this.evaluationExamScore = evaluationExamScore;
    }

    /**
     * Allows the Student to process a School's offer. The Student can
     * accept the School's offer or reject this Schools' offer.
     *
     * @param school The School that makes an offer to this Student
     * @return true if this Student accepts Schools' offer, false otherwise
     */
    public boolean acceptOffer(School school) {
        if (!this.studentPreferences.contains(school)) {
            return false;
        }

        if (this.match == null) {
            this.match = school;
            return true;
        }

        int index = this.studentPreferences.indexOf(school);
        int matchIndex = this.studentPreferences.indexOf((this.match));

        if (index < matchIndex) {
            this.match.unMatchStudent(this);
            this.match = school;
            return true;
        }
        return false;
    }

    public School getMatch() {
        return this.match;
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

    public Double getEvaluationExamScore() {
        return evaluationExamScore;
    }

    public void setEvaluationExamScore(Double evaluationExamScore) {
        this.evaluationExamScore = evaluationExamScore;
    }

    @Override
    public int compareTo(Student student) {
        return this.evaluationExamScore.compareTo(student.getEvaluationExamScore());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", examScore = " + evaluationExamScore +
                '}';
    }

}
