package models;

public class Loan {

    private long loanId;

    private long accountId;

    private long loanAmount;

    private String accountNumber;

    private int creditScore;

    private String status;

    public Loan() {
    }

    public Loan(long loanId,
            long accountId,
            long loanAmount,
            int creditScore,
            String status) {

        this.loanId = loanId;
        this.accountId = accountId;
        this.loanAmount = loanAmount;
        this.creditScore = creditScore;
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getLoanId() {
        return loanId;
    }

    public void setLoanId(long loanId) {
        this.loanId = loanId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}