package formatlocaleprintf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunTest {

    Run run = new Run("Kiss Béla");

    @Test
    void testFirstRun() {
        run.addRun(13.40);

        assertEquals(
                "Kedves Kiss Béla! A mai dátum: 2022-03-07. Ezen a héten ez a(z) 1. futásod. Most 13,4 km-t futottál. Csak így tovább!",
                run.printFormattedRunText());
    }

    @Test
    void testMoreRuns() {
        run.addRun(13.40);
        run.addRun(9.30);
        run.addRun(10.60);
        run.addRun(12.80);

        assertEquals("Kedves Kiss Béla! A mai dátum: 2022-03-07. Ezen a héten ez a(z) 4. futásod. Most 12,8 km-t futottál. Csak így tovább!",
                run.printFormattedRunText());
    }
}