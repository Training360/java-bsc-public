package introexceptionthrowjunit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TankTest {

    Tank tank = new Tank();

    @Test
    void testGetAngle() {
        tank.modifyAngle(2087);
        tank.modifyAngle(-2010);

        assertEquals(77, tank.getAngle());
    }

    @Test
    void testGetAngleInvalidNote() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> tank.modifyAngle(2000));
        assertEquals("Turret can not reach a position between 80° and 280°!", exception.getMessage());
    }
}