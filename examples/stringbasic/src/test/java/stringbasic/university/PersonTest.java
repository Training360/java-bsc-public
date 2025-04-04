package stringbasic.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testCreate() {
        Person person = new Person("Kovács Péter", "kovacsp@gmail.com", "123456789",
                "12345678-87654321-12345678", "+3620-1234567");

        assertEquals("Kovács Péter", person.getName());
        assertEquals("kovacsp@gmail.com", person.getEmail());
        assertEquals("123456789", person.getSsn());
        assertEquals("12345678-87654321-12345678", person.getBankAccountNumber());
        assertEquals("+3620-1234567", person.getPhoneNumber());
    }
}