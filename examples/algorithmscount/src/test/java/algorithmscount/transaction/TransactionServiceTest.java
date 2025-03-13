package algorithmscount.transaction;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionServiceTest {

    @Test
    void testCountEntryLessThan() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("1234", TransactionType.CREDIT, 1000),
                new Transaction("1234", TransactionType.CREDIT, 2000),
                new Transaction("1234", TransactionType.CREDIT, 3000),
                new Transaction("1234", TransactionType.CREDIT, 4000),
                new Transaction("1234", TransactionType.DEBIT, 8000)
        );

        assertEquals(1, new TransactionService().countEntryLessThan(transactions, 2000));
        assertEquals(0, new TransactionService().countEntryLessThan(transactions, 1000));
        assertEquals(4, new TransactionService().countEntryLessThan(transactions, 10000));
    }
}
