package services;

import java.util.HashSet;
import java.util.Scanner;

import models.Account;
import repository.AccountRepository;
import utils.HtmlUtil;

public class AccountService {
    AccountRepository accountRepository = new AccountRepository();
    EmailService emailService = new EmailService();
    HtmlUtil htmlUtil = new HtmlUtil();

    public void createAccount() throws Exception {
        String accountNumberPrefix = "FINBANK";

        Account account = new Account();
        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER NAME:- ");
        account.setName(sc.nextLine());

        System.out.print("ENTER EMAIL:- ");
        account.setEmail(sc.nextLine());

        account.setBalance(0);

        HashSet<Account> allAccounts = accountRepository.getAllAccounts();

        account.setAccountId((allAccounts.size() + 1));// total accounts in table+1
        account.setAccountNumber((accountNumberPrefix + String.valueOf(account.getAccountId())));

        boolean savedBoolean = accountRepository.saveAccount(account);

        if (savedBoolean) {
            System.out.println("ACCOUNT SAVED SUCCESSFULLY");
            emailService.accountCreationSuccessMail(account);
        } else {
            System.out.println("ACCOUNT NOT SAVED");
        }

    }

    public void addBalance() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER ACCOUNT ID:-");
        long id = sc.nextLong();
        try {

            // yaha par avl tree ka search lagana hai baad mai
            Account account = accountRepository.findByAccountId(id);
            if (account != null) {
                System.out.print("ENTER AMOUNT:- ");
                long amount = sc.nextLong();
                long newBalance = account.getBalance() + amount;
                account = accountRepository.updateBalance(id, newBalance);
                emailService.balanceAddedSuccessfullyMail(account);
            }
        } catch (Exception e) {
            System.out.println("ERROR WHILE ADDING BALANCE");
            e.printStackTrace();
        }
    }
}
