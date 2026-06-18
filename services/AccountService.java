package services;

import java.util.HashSet;
import java.util.Scanner;

import models.Account;
import repository.AccountRepository;

public class AccountService {
    AccountRepository accountRepository = new AccountRepository();

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
        } else {
            System.out.println("ACCOUNT NOT SAVED");
        }

    }
}
