package interfacedependencyinversion.vaccine;

import java.util.ArrayList;
import java.util.List;

public class FirstVaccine implements Vaccine {

    private List<Person> vaccinationList = new ArrayList<>();

    @Override
    public List<Person> getVaccinationList() {
        return vaccinationList;
    }

    @Override
    public void generateVaccinationList(List<Person> registered) {
        addPregnantsToVaccinationList(registered);
        addEldersToVaccinationList(registered);
        addOthersToVaccinationList(registered);
    }

    private void addPregnantsToVaccinationList(List<Person> registered) {
        for (Person p : registered) {
            if (p.getPregnant() == Pregnancy.YES) {
                vaccinationList.add(p);
            }
        }
    }

    private void addEldersToVaccinationList(List<Person> registered) {
        for (Person p : registered) {
            if (p.getAge() > 65 && p.getPregnant() == Pregnancy.NO) {
                vaccinationList.add(p);
            }
        }
    }

    private void addOthersToVaccinationList(List<Person> registered) {
        for (Person p : registered) {
            if (p.getAge() <= 65 && p.getPregnant() == Pregnancy.NO) {
                vaccinationList.add(p);
            }
        }
    }
}
