package algorithmscount.bankaccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTest {

    @Test
    void createBankAccount() {
        BankAccount bankAccount = new BankAccount("John Doe", "1234", 1000);

        assertEquals("John Doe", bankAccount.getNameOfOwner());
        assertEquals("1234", bankAccount.getAccountNumber());
        assertEquals(1000, bankAccount.getBalance());
    }
}
