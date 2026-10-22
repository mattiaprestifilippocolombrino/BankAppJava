import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {
    private String bankName;
    private List<BankAccount> accounts;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }

    public String getBankName() {
        return bankName;
    }
    public BankAccount createAccount(String owner, float initialBalance){
        if(initialBalance<0){
            return null;
        }
        BankAccount b = new BankAccount(owner, initialBalance);
        accounts.add(b);
        return b;
    }
    public BankAccount findAccount(int accountId){
        for(BankAccount b: accounts){
            if(b.getAccountId() == accountId){
                return b;
            }
        }
        return null;
    }
    public List<BankAccount> getAllAccounts(){
        return Collections.unmodifiableList(accounts);

    }

    public boolean deposit(int accountId, float amount){
        BankAccount b = findAccount(accountId);
        if(b==null){
            return false;
        }
        boolean done = b.deposit(amount);
        if(!done){
            return false;
        }
        b.getTransactions().add(new Transaction(TransactionType.DEPOSIT, amount, LocalDateTime.now(), 0, b.getAccountId()));
        return true;
    }

    public boolean withdraw(int accountId, float amount){
        BankAccount b = findAccount(accountId);
        if(b==null){
            return false;
        }
        boolean done = b.withDraw(amount);
        if(!done){
            return false;
        }
        b.getTransactions().add(new Transaction(TransactionType.WITHDRAWAL, amount, LocalDateTime.now(), b.getAccountId(), 0));
        return true;
    }

    public boolean transfer(int sourceId, int destinationId, float amount) {
        if (sourceId == destinationId) {
            return false;
        }
        BankAccount src = findAccount(sourceId);
        if(src == null){
            return false;
        }
        BankAccount dest = findAccount(destinationId);
        if(dest == null){
            return false;
        }
        boolean done = src.withDraw(amount);
        if(!done){
            return false;
        }
        done = dest.deposit(amount);
        if(!done){
            src.deposit(amount);
            return false;
        }
        Transaction t = new Transaction(TransactionType.TRANSFER, amount, LocalDateTime.now(), src.getAccountId(), dest.getAccountId());
        src.getTransactions().add(t);
        dest.getTransactions().add(t);
        return true;
    }


    public List<Transaction> getHistoryTransaction(int accountId) {
        BankAccount b = findAccount(accountId);
        if (b == null) {
            return null;
        }
        return Collections.unmodifiableList(b.getTransactions());
    }
}
