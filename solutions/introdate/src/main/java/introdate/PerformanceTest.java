package introdate;

import java.time.Month;

public class PerformanceTest {

    public static void main(String[] args) {

        Performance performance = new Performance(2019, Month.AUGUST, 8, "Sziget koncert", 9, 30);
        System.out.println(performance.getDate());
        System.out.println(performance.toString());
    }
}
