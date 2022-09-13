package initializer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    @Test
    void testCreateWithThreeParameters() {
        //Given
        CreditCard card = new CreditCard(1000, Currency.EUR);
        //Then
        assertEquals(308_230L, card.getBalance());
    }

    @Test
    void testCreateWithOneParameter() {
        //Given
        CreditCard card = new CreditCard(100_000);
        //Then
        assertEquals(100_000L, card.getBalance());
    }

    @Test
    void testPaymentWithTwoParametersSuccess() {
        //Given
        CreditCard card = new CreditCard(100_000);
        //Then
        assertTrue(card.payment(100, Currency.EUR));
        assertEquals(69177L, card.getBalance());
    }

    @Test
    void testPaymentWithTwoParametersFail() {
        //Given
        CreditCard card = new CreditCard(100_000);
        //Then
        assertFalse(card.payment(1000, Currency.EUR));
        assertEquals(100_000L, card.getBalance());
    }

    @Test
    void testPaymentWithOneParameterSuccess() {
        //Given
        CreditCard card = new CreditCard(100_000);
        //Then
        assertTrue(card.payment(10_000));
        assertEquals(90_000L, card.getBalance());
    }

    @Test
    void testPaymentWithOneParameterFail() {
        //Given
        CreditCard card = new CreditCard(100_000);
        //Then
        assertFalse(card.payment(150_000));
        assertEquals(100_000L, card.getBalance());
    }
}