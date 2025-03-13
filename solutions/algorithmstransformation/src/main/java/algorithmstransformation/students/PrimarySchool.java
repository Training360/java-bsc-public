package algorithmstransformation.students;

import java.util.ArrayList;
import java.util.List;

public class PrimarySchool {

    private List<Person> people;

    public PrimarySchool(List<Person> people) {
        this.people = people;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        for (Person p : people) {
            if (p.getAge() >= 6 && p.getAge() <= 14) {
                Student student = new Student(p.getName(), p.getAddress());
                students.add(student);
            }
        }
        return students;
    }
}
