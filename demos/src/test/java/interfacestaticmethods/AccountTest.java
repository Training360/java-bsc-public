package interfacestaticmethods;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class AccountTest {

    @Test
    public void testLastCreated() {
        List<Account> accounts =
                Arrays.asList(
                        new Account(LocalDateTime.of(2018, 1, 1, 10, 0)),
                        new Account(LocalDateTime.of(2018, 1, 1, 11, 0)),
                        new Account(LocalDateTime.of(2018, 1, 1, 8, 0)),
                        new Account(LocalDateTime.of(2018, 1, 1, 13, 0))
                );
        Account account = Audited.lastCreated(accounts);

        assertThat(account.getCreatedAt().getHour(), equalTo(13));

    }
}
