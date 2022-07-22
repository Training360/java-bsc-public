package formatlocaleprintf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Run {

    private final String RUN_TEXT = "Kedves %s! A mai dátum: %s. Ezen a héten ez a(z) %d. futásod. Most %.1f km-t futottál. Csak így tovább!";
    private List<Double> kms;
    private String runnerName;

    public Run(String runnerName) {
        this.runnerName = runnerName;
        this.kms = new ArrayList<>();
    }

    public void addRun(double km) {
        kms.add(km);
    }

    public String printFormattedRunText() {
        String dateString = LocalDate.now().toString();
        int days = kms.size();
        double km = kms.get(kms.size() - 1);
        return String.format(RUN_TEXT, runnerName, dateString, days, km);
    }
}
