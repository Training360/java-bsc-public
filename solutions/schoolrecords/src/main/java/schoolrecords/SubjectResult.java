package schoolrecords;

public class SubjectResult {

    private String studentName;

    private double subjectAverage;

    public SubjectResult(String studentName, double subjectAverage) {
        this.studentName = studentName;
        this.subjectAverage = subjectAverage;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getSubjectAverage() {
        return subjectAverage;
    }

    @Override
    public String toString() {
        return studentName + ": " + subjectAverage;
    }
}
