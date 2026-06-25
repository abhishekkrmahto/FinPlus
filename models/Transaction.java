package models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Transaction {

    private long transactionId;
    private long senderAccountNumber;
    private long receiverAccountNumber;
    private long amount;
    private LocalDateTime timestamp;
    private String transactionIdString;

    public String getTransactionIdString() {
        return transactionIdString;
    }

    public void setTransactionIdString(String transactionIdString) {
        this.transactionIdString = transactionIdString;
    }

    public Transaction() {
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public long getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(long senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public long getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(long receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }
}