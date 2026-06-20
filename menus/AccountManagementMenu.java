package menus;

import java.util.Scanner;

import dataFetching.LoadAllData;
import dsa.trees.AccountsAvlTree;
import repository.AccountRepository;
import services.AccountService;

public class AccountManagementMenu {
    AccountsAvlTree accountsAvlTree = new AccountsAvlTree();
    AccountService accountService = new AccountService();
    AccountRepository accountRepository = new AccountRepository();

    static void typeWriter(String text, int delay) throws Exception {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(delay);
        }
        System.out.println();
    }

    static Scanner sc = new Scanner(System.in);

    public void accountManagementMenu() throws Exception {

        LoadAllData loadAllData = new LoadAllData();
        loadAllData.fetchForAvlTree(accountRepository.getAllAccounts());

        typeWriter("1. Create Account", 40);
        typeWriter("2. Search Account", 40);
        typeWriter("3. Loan System", 40);
        typeWriter("4. Add Balance", 40);
        typeWriter("5. Delete Account", 40);

        int input = sc.nextInt();

        switch (input) {
            case 1:
                accountService.createAccount();
                break;
            case 2:
                System.out.println("Under Maintainance");
                break;
            case 3:
                System.out.println("Under Maintainance");
                break;
            case 4:
                accountService.addBalance();
                break;
            case 5:
                System.out.println("Under Maintainance");
                break;

            default:
                break;
        }

    }
}
