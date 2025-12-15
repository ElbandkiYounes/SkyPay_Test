package bank;

import com.bank.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private Account account;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @BeforeEach
    public void setUp() {
        account = new Account();
        System.setOut(new PrintStream(outContent));
    }
    
    @Test
    public void testDepositIncreasesBalance() {
        account.deposit(100);
        assertEquals(100, account.getBalance());
        
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }
    
    @Test
    public void testWithdrawDecreasesBalance() {
        account.deposit(100);
        account.withdraw(30);
        assertEquals(70, account.getBalance());
    }
    
    @Test
    public void testDepositWithNegativeAmountThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100);
        });
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }
    
    @Test
    public void testDepositWithZeroAmountThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(0);
        });
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }
    
    @Test
    public void testWithdrawWithNegativeAmountThrowsException() {
        account.deposit(100);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-50);
        });
        assertEquals("Withdrawal amount must be positive", exception.getMessage());
    }
    
    @Test
    public void testWithdrawWithZeroAmountThrowsException() {
        account.deposit(100);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(0);
        });
        assertEquals("Withdrawal amount must be positive", exception.getMessage());
    }
    
    @Test
    public void testWithdrawMoreThanBalanceThrowsException() {
        account.deposit(100);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(150);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }
    
    @Test
    public void testWithdrawFromEmptyAccountThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(50);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }
    
    @Test
    public void testTransactionsAreStored() {
        account.deposit(100);
        account.withdraw(30);
        account.deposit(50);
        
        assertEquals(3, account.getTransactionCount());
        assertEquals(120, account.getBalance());
    }
    
    @Test
    public void testPrintStatementWithNoTransactions() {
        account.printStatement();
        
        String expectedOutput = "Date || Amount || Balance" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
        System.setOut(originalOut);
    }
    
    @Test
    public void testMultipleDepositsAndWithdrawals() {
        account.deposit(1000);
        account.deposit(500);
        account.withdraw(200);
        account.deposit(300);
        account.withdraw(100);
        
        assertEquals(1500, account.getBalance());
        assertEquals(5, account.getTransactionCount());
    }
}
