package models;

public class FraudAlert {

    private long alertId;

    private long transactionId;

    private String reason;

    private int riskScore;

    public FraudAlert() {
    }

    public FraudAlert(long alertId,
            long transactionId,
            String reason,
            int riskScore) {

        this.alertId = alertId;
        this.transactionId = transactionId;
        this.reason = reason;
        this.riskScore = riskScore;
    }

    public long getAlertId() {
        return alertId;
    }

    public void setAlertId(long alertId) {
        this.alertId = alertId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }
}