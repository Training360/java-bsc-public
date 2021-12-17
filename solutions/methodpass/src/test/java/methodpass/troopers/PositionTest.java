package methodpass.troopers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

    @Test
    void testDistanceFrom() {
        Position pos1 = new Position(2, 6);
        Position pos2 = new Position(-5, 1.4);

        assertEquals(8.376157, pos1.distanceFrom(pos2), 0.000001);
    }
}
