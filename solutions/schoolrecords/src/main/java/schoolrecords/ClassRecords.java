package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private List<Student> students = new ArrayList<>();

    private String className;

    private Random random;

    public ClassRecords(String className, Random random) {
        validate(className);
        this.className = className;
        this.random = random;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(String name) {
        validate(name);
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return false;
            }
        }
        return students.add(new Student(name));
    }

    public boolean removeStudent(String name) {
        validate(name);
        Student foundStudent = null;
        for (Student student : students) {
            if (student.getName().equals(name)) {
                foundStudent = student;
            }
        }
        return students.remove(foundStudent);
    }

    public double calculateClassAverageBySubject(String subjectName) {
        validate(subjectName);
        double average = 0.0;
        int count = 0;
        for (Student student : students) {
            double studentAverage = student.calculateSubjectAverage(subjectName);
            if (studentAverage != 0) {
                average += studentAverage;
                count++;
            }
        }
        average = average / count;
        return Math.round(average * 100) / 100.0;
    }

    public Student findStudentByName(String name) {
        validate(name);
        if (students.isEmpty()) {
            throw new IllegalArgumentException("No students to search!");
        }
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        throw new IllegalArgumentException("No student found with name: " + name);
    }

    public Student repetition() {
        if (students.isEmpty()) {
            throw new IllegalArgumentException("No students to select for repetition!");
        }
        int index = random.nextInt(students.size());
        return students.get(index);
    }

    public List<SubjectResult> listSubjectResults(String subjectName) {
        validate(subjectName);
        List<SubjectResult> results = new ArrayList<>();
        for (Student student : students) {
            double studentAverage = student.calculateSubjectAverage(subjectName);
            if (studentAverage != 0) {
                SubjectResult result = new SubjectResult(student.getName(), studentAverage);
                results.add(result);
            }
        }
        return results;
    }

    public String listStudentNames() {
        StringBuilder studentNames = new StringBuilder();
        for (Student student : students) {
            studentNames.append(student.getName());
            if (student != students.get(students.size() - 1)) {
                studentNames.append(", ");
            }
        }
        return studentNames.toString();
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty!");
        }
    }
}
