package services;


import java.util.Random;
import java.util.Scanner;

import dsa.graphs.TransactionGraph;
import dsa.trees.AccountsAvlTree;
import models.Account;

import repository.AccountRepository;
import utils.HtmlUtil;

public class AccountService {
    AccountRepository accountRepository = new AccountRepository();
    AccountsAvlTree accountsAvlTree = new AccountsAvlTree();
    EmailService emailService = new EmailService();
    TransactionGraph transactionGraph = new TransactionGraph();
    HtmlUtil htmlUtil = new HtmlUtil();
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    public void createAccount() throws Exception {

        String accountNumberPrefix = "FINBANK";

        Account account = new Account();
        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER NAME:- ");
        account.setName(sc.nextLine());

        System.out.print("ENTER EMAIL:- ");
        account.setEmail(sc.nextLine());

        account.setBalance(0);

        boolean emailExist = accountsAvlTree.emailExistsOrNot(account, accountsAvlTree.root);
        account.setAccountId(accountsAvlTree.maxId + 1);
        account.setAccountNumber(accountNumberPrefix + String.valueOf(account.getAccountId()));

        if (emailExist) {
            System.out.println("ACCOUNT NOT SAVED GIVEN EMAIL ALREADY EXISTS");
            emailService.tryingToRegisterWithExistingEmailMail(account.getEmail());
            return;
        }

        int attempts = 3;

        while (attempts-- > 0) {

            Random rand = new Random();
            int otp = 100000 + rand.nextInt(900000);

            emailService.otpMail(account.getEmail(), otp);

            System.out.print("ENTER OTP(sent in your email):- ");
            int enteredOtp = sc.nextInt();

            if (otp == enteredOtp) {

                account.setAccountNumber(accountNumberPrefix + account.getAccountId());

                boolean savedBoolean = accountRepository.saveAccount(account);

                if (savedBoolean) {
                    accountsAvlTree.insertAccount(accountsAvlTree.root, account);
                    System.out.println("ACCOUNT SAVED SUCCESSFULLY");
                    System.out.println("Wait.... sending email");
                    emailService.accountCreationSuccessMail(account);
                }

                return;
            }

            System.out.println("Wrong OTP, OTP resent to your gmail");
        }

        System.out.println("ACCOUNT NOT CREATED. OTP VERIFICATION FAILED.");
    }

    public void addBalance() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER ACCOUNT ID:-");
        long id = sc.nextLong();
        try {
            Account account = accountRepository.findByAccountId(id);
            if (account != null) {
                System.out.print("ENTER AMOUNT:- ");
                long amount = sc.nextLong();
                long newBalance = account.getBalance() + amount;
                int attempts = 3;
                while (attempts-- > 0) {

                    Random rand = new Random();
                    int otp = 100000 + rand.nextInt(900000);

                    emailService.otpMail(account.getEmail(), otp);

                    System.out.print("ENTER OTP(sent in your email):- ");
                    int enteredOtp = sc.nextInt();

                    if (otp == enteredOtp) {
                        account = accountRepository.updateBalance(id, newBalance);
                        emailService.balanceAddedSuccessfullyMail(account);
                        System.out.println("Balance Updated !!");
                        return;
                    }

                    System.out.println("Wrong OTP, OTP resent to your gmail");
                }
            } else {
                System.out.println("Account not found !!");
                return;
            }
        } catch (Exception e) {
            System.out.println("ERROR WHILE ADDING BALANCE");
            e.printStackTrace();
        }
    }
}
