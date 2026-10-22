import java.time.LocalDateTime;

public class Transaction {
    private static int countTransaction = 0;
    private final int transactionId;
    private final TransactionType type;
    private final float amount;
    private final LocalDateTime timestamp;
    private final int sourceAccountId;
    private final int destinationAccountId;

    public Transaction(TransactionType type, float amount, LocalDateTime timestamp, int sourceAccountId, int destinationAccountId) {
        this.transactionId = ++countTransaction;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public TransactionType getType() {
        return type;
    }

    public float getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getSourceAccountId() {
        return sourceAccountId;
    }

    public int getDestinationAccountId() {
        return destinationAccountId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", sourceAccountId='" + sourceAccountId + '\'' +
                ", destinationAccountId='" + destinationAccountId + '\'' +
                '}';
    }
}
