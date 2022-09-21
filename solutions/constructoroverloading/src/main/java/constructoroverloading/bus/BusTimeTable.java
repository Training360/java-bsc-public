package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    private final List<SimpleTime> timeTable;

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        List<SimpleTime> generatedTimeTable = new ArrayList<>();
        for (int i = firstHour; i <= lastHour; i++) {
            generatedTimeTable.add(new SimpleTime(i, everyMinute));
        }
        timeTable = generatedTimeTable;
    }

    public List<SimpleTime> getTimeTable() {
        return timeTable;
    }

    public SimpleTime getNextBus(SimpleTime actual) {
        for (SimpleTime time : timeTable) {
            if (time.getDifference(actual) >= 0) {
                return time;
            }
        }
        throw new IllegalStateException("No more buses today!");
    }
}
