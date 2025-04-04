package interfacedependencyinversion.vaccine;

import java.util.ArrayList;
import java.util.List;

public class SecondVaccine implements Vaccine {

    private List<Person> vaccinationList = new ArrayList<>();

    @Override
    public List<Person> getVaccinationList() {
        return vaccinationList;
    }

    @Override
    public void generateVaccinationList(List<Person> registered) {
        addYoungPeopleToVaccinationList(registered);
        addEldersToVaccinationList(registered);
    }

    private void addYoungPeopleToVaccinationList(List<Person> registered) {
        for (Person p : registered) {
            if (p.getAge() <= 65 && p.getPregnant() == Pregnancy.NO && p.getChronic() == ChronicDisease.NO) {
                vaccinationList.add(p);
            }
        }
    }

    private void addEldersToVaccinationList(List<Person> registered) {
        for (Person p : registered) {
            if (p.getAge() > 65 && p.getPregnant() == Pregnancy.NO && p.getChronic() == ChronicDisease.NO) {
                vaccinationList.add(p);
            }
        }
    }
}
