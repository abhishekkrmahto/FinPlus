package services;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

import dsa.graphs.TransactionGraph;
import dsa.trees.AccountsAvlTree;
import models.Account;
import models.FraudAlert;
import models.Transaction;
import repository.AccountRepository;
import repository.TransactionRepository;

public class TransactionService {
    // Constants
    private static final long SUSPICIOUS_AMOUNT_LIMIT = 100000;
    private static final int OTP_MIN = 100000;
    private static final int OTP_MAX = 999999;
    private static final int MAX_OTP_ATTEMPTS = 3;
    private static final int FRAUD_RISK_INCREMENT = 10;
    private static final int MAX_RISK_SCORE = 100;
    private static final String TRANSACTION_PREFIX = "FINBANK25K";

    TransactionGraph transactionGraph = new TransactionGraph();
    TransactionRepository transactionRepository = new TransactionRepository();
    EmailService emailService = new EmailService();
    AccountRepository accountRepository = new AccountRepository();
    AccountsAvlTree accountsAvlTree = new AccountsAvlTree();
    FraudService fraudService = new FraudService();
    Random random = new Random();
    Scanner sc = new Scanner(System.in);

    public void makeTransaction(long senderAccountNumber, long receiverAccountNumber) {
        Account sender = accountsAvlTree.findByAccountId(accountsAvlTree.root, senderAccountNumber);
        Account receiver = accountsAvlTree.findByAccountId(accountsAvlTree.root, receiverAccountNumber);

        if (sender == null || receiver == null) {
            System.out.println(sender == null ? "Sender Account Not Exists" : "Receiver Account Not Exists");
            return;
        }

        System.out.print("Enter Amount:- ");
        long amount = sc.nextLong();

        // High amount warning and OTP
        if (amount > SUSPICIOUS_AMOUNT_LIMIT) {
            if (!handleSuspiciousTransaction(sender)) {
                return;
            }
        }

        // Check balance
        if (sender.getBalance() < amount) {
            System.out.println("Account Not have Enough Amount");
            return;
        }

        // OTP verification
        if (!verifyTransactionOtp(sender)) {
            return;
        }

        // Process transaction
        processTransaction(sender, receiver, senderAccountNumber, receiverAccountNumber, amount);
    }

    private boolean handleSuspiciousTransaction(Account sender) {
        System.out.println("Suspicious Activity found !! (sending more than 1 lakh will increase your fraud score)");
        System.out.println("For confirmation -> (1)");
        System.out.println("For cancellation -> (2)");
        System.out.print("Enter:- ");

        if ("2".equalsIgnoreCase(sc.next())) {
            return false;
        }

        System.out.println("Enter Confirmation OTP:- ");
        int otp = generateOtp();
        emailService.otpMail(sender.getEmail(), otp);

        return String.valueOf(otp).equalsIgnoreCase(sc.next());
    }

    private boolean verifyTransactionOtp(Account sender) {
        for (int attempts = MAX_OTP_ATTEMPTS; attempts > 0; attempts--) {
            int otp = generateOtp();
            System.out.print("Enter OTP:- ");
            emailService.otpMail(sender.getEmail(), otp);

            if (String.valueOf(otp).equalsIgnoreCase(sc.next())) {
                return true;
            }
            if (attempts > 1)
                System.out.println("Wrong OTP!! Attempts remaining: " + (attempts - 1));
        }
        System.out.println("Max OTP attempts exceeded!");
        return false;
    }

    private void processTransaction(Account sender, Account receiver, long senderAccNum,
            long receiverAccNum, long amount) {
        long senderNewBalance = sender.getBalance() - amount;
        long receiverNewBalance = receiver.getBalance() + amount;

        // Create transaction
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setSenderAccountNumber(senderAccNum);
        transaction.setReceiverAccountNumber(receiverAccNum);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setTransactionId(transactionGraph.nextTransactionId + 1);
        transaction.setTransactionIdString(TRANSACTION_PREFIX + (transactionGraph.nextTransactionId + 1));

        // Handle fraud if amount > limit
        if (amount > SUSPICIOUS_AMOUNT_LIMIT) {
            if (!updateFraudScore(senderAccNum)) {
                System.out.println("Transaction cancelled !!");
                return;
            }
        }

        // Update balances and save transaction
        accountRepository.updateBalance(senderAccNum, senderNewBalance);
        accountRepository.updateBalance(receiverAccNum, receiverNewBalance);
        transactionGraph.addTransactionToAccount(senderAccNum, transaction);
        transactionRepository.addTransaction(transaction);

        // Send emails
        emailService.creditBalance(receiver.getEmail(), amount, transaction.getTransactionIdString());
        emailService.debitBalance(sender.getEmail(), amount, transaction.getTransactionIdString());
    }

    private boolean updateFraudScore(long accountNumber) {
        FraudAlert fraudDetails = fraudService.getFraudDetails(accountNumber);
        int newRiskScore = (fraudDetails == null) ? FRAUD_RISK_INCREMENT
                : fraudDetails.getRiskScore() + FRAUD_RISK_INCREMENT;

        if (newRiskScore > MAX_RISK_SCORE) {
            System.out.println("Your Account on high alert meet Admin");
            return false;
        }

        fraudService.updateFraud(accountNumber, newRiskScore);
        return true;
    }

    private int generateOtp() {
        return random.nextInt(OTP_MAX - OTP_MIN + 1) + OTP_MIN;
    }
}