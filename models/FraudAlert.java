package models;

public class FraudAlert {

    private long transactionId;
    private long accountId;

    private int riskScore;

    public FraudAlert() {
    }

    public FraudAlert(
            long transactionId,
            int riskScore) {
        this.transactionId = transactionId;
        this.riskScore = riskScore;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }
}