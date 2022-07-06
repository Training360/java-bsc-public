package schoolrecords;

import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class SchoolController {

    private School school;

    private ClassRecords classRecords;

    private Scanner scanner = new Scanner(System.in);

    private final static int MENU_EXIT = 9;

    public static void main(String[] args) {
        SchoolController controller = new SchoolController();
        controller.school = new School(Paths.get("src/test/resources/school.csv"));
        controller.classRecords = new ClassRecords("9.A", new Random());
        controller.initClass();
        controller.runMenu();
    }

    private void runMenu() {
        int menuNumber = 0;
        while (menuNumber != MENU_EXIT) {
            printMenu();
            System.out.println("Kérem, adja meg a menüpont számát:");
            try {
                menuNumber = Integer.parseInt(scanner.nextLine());
                executeMenu(menuNumber);
            } catch (NumberFormatException nfe) {
                System.out.println("Adjon meg egy egész számot!");
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1. Diákok nevének listázása\n" +
                "2. Diák név alapján keresése\n" +
                "3. Diák létrehozása\n" +
                "4. Diák név alapján törlése\n" +
                "5. Diák feleltetése\n" +
                "6. Tantárgyi osztályátlag kiszámolása\n" +
                "7. Diákok átlagának listázása egy tantárgyból\n" +
                "8. Egy diák egy tantárgyhoz tartozó átlagának kiszámolása\n" +
                "9. Kilépés");
    }

    private void executeMenu(int menuNumber) {
        switch (menuNumber) {
            case 1: {
                System.out.println("Diákok:");
                System.out.println(classRecords.listStudentNames());
                return;
            }
            case 2: {
                System.out.println("Adja meg a keresett diák nevét:");
                String name = scanner.nextLine();
                System.out.println(classRecords.findStudentByName(name));
                return;
            }
            case 3: {
                System.out.println("Adja meg az új diák nevét:");
                String name = scanner.nextLine();
                classRecords.addStudent(name);
                return;
            }
            case 4: {
                System.out.println("Adja meg a törlendő diák nevét:");
                String name = scanner.nextLine();
                classRecords.removeStudent(name);
                return;
            }
            case 5: {
                studentRepetition();
                return;
            }
            case 6: {
                System.out.println("Adja meg a tantárgyat:");
                String subject = scanner.nextLine();
                System.out.println(classRecords.calculateClassAverageBySubject(subject));
                return;
            }
            case 7: {
                System.out.println("Adja meg a tantárgyat:");
                String subject = scanner.nextLine();
                System.out.println(classRecords.listSubjectResults(subject));
                return;
            }
            case 8: {
                System.out.println("Adja meg a diák nevét:");
                String name = scanner.nextLine();
                System.out.println("Adja meg a tantárgyat:");
                String subject = scanner.nextLine();
                System.out.println(classRecords.findStudentByName(name).calculateSubjectAverage(subject));
                return;
            }
            case 9: {
                System.out.println("Viszontlátásra!");
                return;
            }
            default: {
                System.out.println("Nem létezik ilyen menüpont!");
            }
        }
    }

    public void studentRepetition() {
        Student student = classRecords.repetition();
        System.out.println("A mai felelő: " + student.getName());
        System.out.println("Kérem a jegyet");
        int mark = Integer.parseInt(scanner.nextLine());
        System.out.println("Kérem a tárgy nevét:");
        String subjectName = scanner.nextLine();
        System.out.println("Kérem a tanár nevét:");
        String tutorName = scanner.nextLine();

        Mark actualMark = new Mark(findMarkTypeByValue(mark), school.findSubjectByName(subjectName), school.findTutorByName(tutorName));
        student.addGrading(actualMark);
    }

    private MarkType findMarkTypeByValue(int value) {
        for (MarkType markType : MarkType.values()) {
            if (markType.getValue() == value) {
                return markType;
            }
        }
        throw new IllegalArgumentException("Cannot find mark with this value!");
    }

    private void initClass() {
        classRecords.addStudent("Kovács Rita");
        classRecords.addStudent("Nagy Béla");
        classRecords.addStudent("Varga Márton");
        Student firstStudent = classRecords.findStudentByName("Kovács Rita");
        firstStudent.addGrading(new Mark(MarkType.A, school.findSubjectByName("földrajz"), school.findTutorByName("Dienes Irén")));
        firstStudent.addGrading(new Mark(MarkType.C, school.findSubjectByName("matematika"), school.findTutorByName("Szabó László")));
        firstStudent.addGrading(new Mark(MarkType.D, school.findSubjectByName("földrajz"), school.findTutorByName("Dienes Irén")));
        Student secondStudent = classRecords.findStudentByName("Nagy Béla");
        secondStudent.addGrading(new Mark(MarkType.A, school.findSubjectByName("biológia"), school.findTutorByName("Dienes Irén")));
        secondStudent.addGrading(new Mark(MarkType.C, school.findSubjectByName("matematika"), school.findTutorByName("Tóth Ilona")));
        secondStudent.addGrading(new Mark(MarkType.D, school.findSubjectByName("ének-zene"), school.findTutorByName("Németh Lili")));
        Student thirdStudent = classRecords.findStudentByName("Varga Márton");
        thirdStudent.addGrading(new Mark(MarkType.A, school.findSubjectByName("fizika"), school.findTutorByName("Kiss József")));
        thirdStudent.addGrading(new Mark(MarkType.C, school.findSubjectByName("kémia"), school.findTutorByName("Kiss József")));
        thirdStudent.addGrading(new Mark(MarkType.D, school.findSubjectByName("földrajz"), school.findTutorByName("Tóth Ilona")));
    }
}
