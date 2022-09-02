package algorithmssum.transactions;

import java.util.List;

public class TransactionSum {

    public int sumAmountOfCreditEntries(List<Transaction> transactions) {
        int sum = 0;
        for (Transaction transaction : transactions) {
            if (transaction.isCredit()) {
                sum += transaction.getAmount();
            }
        }
        return sum;
    }
}
