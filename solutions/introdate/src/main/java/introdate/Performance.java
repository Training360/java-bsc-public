package introdate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class Performance {

    private LocalDate date;
    private String type;
    private LocalTime time;

    public Performance(int year, Month month, int day, String type, int hour, int minute) {
        this.date = LocalDate.of(year, month, day);
        this.type = type;
        this.time = LocalTime.of(hour, minute);
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "date=" + date +
                ", type='" + type + '\'' +
                ", time=" + time +
                '}';
    }
}
