package interfacedependencyinversion.vaccine;

import interfacedependencyinversion.vaccine.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class VaccineTest {

    Vaccine vaccine;
    List<Person> registered;

    @BeforeEach
    void setUp() {
        registered = new ArrayList<>();
        registered.add(new Person("Kiss József", 45, ChronicDisease.NO, Pregnancy.NO));
        registered.add(new Person("Nagy Eleonóra", 35, ChronicDisease.NO, Pregnancy.YES));
        registered.add(new Person("Szép Virág", 65, ChronicDisease.YES, Pregnancy.NO));
        registered.add(new Person("Németh Béla", 72, ChronicDisease.NO, Pregnancy.NO));
        registered.add(new Person("Gárdos Géza", 25, ChronicDisease.YES, Pregnancy.NO));
        registered.add(new Person("Szabó Veronika", 32, ChronicDisease.NO, Pregnancy.NO));
        registered.add(new Person("Vedres Károly", 53, ChronicDisease.NO, Pregnancy.NO));
        registered.add(new Person("Ökrös Gizella", 33, ChronicDisease.NO, Pregnancy.YES));
        registered.add(new Person("Fekete Dávid", 62, ChronicDisease.NO, Pregnancy.NO));
        registered.add(new Person("Bíró Rita", 29, ChronicDisease.NO, Pregnancy.NO));
        registered.add(new Person("Baráth Zita", 58, ChronicDisease.YES, Pregnancy.NO));
        registered.add(new Person("Kovács Tamás", 42, ChronicDisease.YES, Pregnancy.NO));
        registered.add(new Person("Török István", 81, ChronicDisease.NO, Pregnancy.NO));
        registered.add(new Person("Fehér Ágnes", 34, ChronicDisease.YES, Pregnancy.YES));
        registered.add(new Person("Bánkuti Bendegúz", 93, ChronicDisease.YES, Pregnancy.NO));
    }

    @Test
    void testFirstVaccine() {
        vaccine = new FirstVaccine();
        vaccine.generateVaccinationList(registered);

        Assertions.assertEquals(15, vaccine.getVaccinationList().size());
        Assertions.assertEquals("Nagy Eleonóra", vaccine.getVaccinationList().get(0).getName());
        Assertions.assertEquals("Németh Béla", vaccine.getVaccinationList().get(3).getName());
        Assertions.assertEquals("Kiss József", vaccine.getVaccinationList().get(6).getName());
        Assertions.assertEquals("Kovács Tamás", vaccine.getVaccinationList().get(14).getName());
    }

    @Test
    void testSecondVaccine() {
        vaccine = new SecondVaccine();
        vaccine.generateVaccinationList(registered);

        Assertions.assertEquals(7, vaccine.getVaccinationList().size());
        Assertions.assertEquals("Kiss József", vaccine.getVaccinationList().get(0).getName());
        Assertions.assertEquals("Szabó Veronika", vaccine.getVaccinationList().get(1).getName());
        Assertions.assertEquals("Németh Béla", vaccine.getVaccinationList().get(5).getName());
        Assertions.assertEquals("Török István", vaccine.getVaccinationList().get(6).getName());
    }
}