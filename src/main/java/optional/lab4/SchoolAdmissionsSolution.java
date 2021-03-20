package optional.lab4;

public class SchoolAdmissionsSolution {

    private Problem problem;

    public SchoolAdmissionsSolution(Problem problem) {
        this.problem = problem;
    }

    public void findMatches() {
        boolean madeMatch;
        do {
            madeMatch = false;

            for (School school : problem.getSchools()) {
                if (school.canMakeOffers()) {
                    madeMatch = school.makeOffers();
                }
            }
        } while (madeMatch);

        for (Student s : problem.getStudents()) {
            System.out.println(s + " is matched with " + s.getMatch());
        }

        for (School c : problem.getSchools()) {
            System.out.println(c + " is matched with " + c.getMatches());
        }
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

}
