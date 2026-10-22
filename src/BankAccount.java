import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private static int countMember = 0;
    private int accountId;
    private String nominativo;
    private float balance;
    private LocalDate openDate;
    private List<Transaction> transactions;

    public BankAccount(String nominativo, float initBalance) {
        this.accountId = ++countMember;
        this.nominativo = nominativo;
        this.balance = initBalance;
        openDate = LocalDate.now();
        transactions = new ArrayList<>();
    }

    public int getAccountId() {
        return accountId;
    }

    public String getNominativo() {
        return nominativo;
    }

    public float getBalance() {
        return balance;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public static int getCountMember() {
        return countMember;
    }

    public boolean deposit(float amount){
        if(amount>=0){
            this.balance += amount;
            return true;
        }
        return false;
    }
    public boolean withDraw(float amount){
        if(amount < 0 || amount > balance){
            return false;
        }
            this.balance -= amount;
            return true;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId='" + accountId + '\'' +
                ", nominativo='" + nominativo + '\'' +
                ", balance=" + balance +
                ", openDate=" + openDate +
                ", transactions=" + transactions +
                '}';
    }
}
