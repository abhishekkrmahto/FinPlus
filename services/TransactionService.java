package services;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

import dsa.graphs.TransactionGraph;
import dsa.trees.AccountsAvlTree;
import models.Account;
import models.Transaction;
import repository.AccountRepository;
import repository.TransactionRepository;

public class TransactionService {
    TransactionGraph transactionGraph = new TransactionGraph();
    TransactionRepository transactionRepository = new TransactionRepository();
    EmailService emailService = new EmailService();
    AccountRepository accountRepository = new AccountRepository();
    AccountsAvlTree accountsAvlTree = new AccountsAvlTree();
    Random random = new Random();
    Scanner sc = new Scanner(System.in);

    public void makeTransaction(long senderAccountNumber, long receiverAccountNumber) {
        Account sender = accountsAvlTree.findByAccountId(accountsAvlTree.root, senderAccountNumber);
        Account receiver = accountsAvlTree.findByAccountId(accountsAvlTree.root, receiverAccountNumber);
        if (sender == null || receiver == null) {
            if (sender == null) {
                System.out.println("Sender Account Not Exists");
            } else {
                System.out.println("Receiver Account Not Exists");
            }
            return;
        }

        System.out.print("Enter Amount:- ");
        long amount = sc.nextLong();

        if (sender.getBalance() < amount) {
            System.out.println("Account Not have Enough Amount");
            // System.out.println("balance = " + sender.getBalance());
            return;
        }

        int attempts = 3;
        while (attempts-- > 0) {
            int otp = random.nextInt(9999) + 1;
            String transactionIdPrefString = "FINBANK25K";

            System.out.print("Enter OTP:- ");
            emailService.otpMail(sender.getEmail(), otp);
            int enteredOtp = sc.nextInt();
            if (otp == enteredOtp) {
                long senderNewBalance = sender.getBalance() - amount;
                long receiverNewBalance = receiver.getBalance() + amount;
                // updates
                accountRepository.updateBalance(senderAccountNumber, senderNewBalance);
                accountRepository.updateBalance(receiverAccountNumber, receiverNewBalance);

                Transaction transaction = new Transaction();
                transaction.setAmount(amount);
                transaction.setSenderAccountNumber(senderAccountNumber);
                transaction.setReceiverAccountNumber(receiverAccountNumber);
                LocalDateTime currentDateTime = LocalDateTime.now();
                transaction.setTimestamp(currentDateTime);
                long transactionId = transactionGraph.nextTransactionId + 1;
                transaction.setTransactionId(transactionId);
                String txString = transactionIdPrefString + (transactionGraph.nextTransactionId + 1);
                transaction.setTransactionIdString(txString);

                transactionGraph.addTransactionToAccount(senderAccountNumber, transaction);
                transactionRepository.addTransaction(transaction);
                // emails
                emailService.creditBalance(receiver.getEmail(), amount,
                        transaction.getTransactionIdString());
                emailService.debitBalance(sender.getEmail(), amount,
                        transaction.getTransactionIdString());
                return;
            }

        }
    }
}
