package schoolrecords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class School {

    private List<Subject> subjects = new ArrayList<>();

    private List<Tutor> tutors = new ArrayList<>();

    public School(Path path) {
        loadFromFile(path);
    }

    public Tutor findTutorByName(String tutorName) {
        for (Tutor tutor : tutors) {
            if (tutor.getName().equals(tutorName)) {
                return tutor;
            }
        }
        throw new IllegalArgumentException("Can't find tutor with this name!");
    }

    public Subject findSubjectByName(String subjectName) {
        for (Subject subject : subjects) {
            if (subject.getName().equals(subjectName)) {
                return subject;
            }
        }
        throw new IllegalArgumentException("Can't find subject with this name!");
    }

    private void loadFromFile(Path path) {
        try {
            List<String> subjectsAndTutors = Files.readAllLines(path);
            load(subjectsAndTutors);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't load subjects and tutors from file.", ioe);
        }
    }

    private void load(List<String> subjectsAndTutors) {
        for (String item : subjectsAndTutors) {
            String[] parts = item.split(";");
            loadSubject(parts[0]);
            loadTutor(parts[0], parts[1]);
        }
    }

    private void loadSubject(String subjectName) {
        boolean subjectExists = false;
        for (Subject subject : subjects) {
            if (subject.getName().equals(subjectName)) {
                subjectExists = true;
            }
        }
        if (!subjectExists) {
            subjects.add(new Subject(subjectName));
        }
    }

    private void loadTutor(String subjectName, String tutorName) {
        boolean tutorExists = false;
        Tutor tutor = new Tutor(tutorName, new ArrayList<>());
        for (Tutor t : tutors) {
            if (t.getName().equals(tutorName)) {
                tutorExists = true;
                tutor = t;
            }
        }
        if (!tutorExists) {
            tutors.add(tutor);
        }
        if (!tutor.isTutorTeachingSubject(subjectName)) {
            Subject subject = findSubjectByName(subjectName);
            tutor.addSubject(subject);
        }
    }
}
