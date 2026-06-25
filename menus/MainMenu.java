package menus;

import java.util.Scanner;

import dataFetching.LoadAllData;
import repository.AccountRepository;
import repository.TransactionRepository;

public class MainMenu {
    AccountRepository accountRepository = new AccountRepository();
    TransactionRepository transactionRepository = new TransactionRepository();

    static void typeWriter(String text, int delay) throws Exception {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(delay);
        }
        System.out.println();
    }

    // static FastScanner sc = new FastScanner();
    static Scanner sc = new Scanner(System.in);

    public void mainMenu() throws Exception {

        typeWriter("1. Account Management", 40);
        typeWriter("2. Transaction Management", 40);
        typeWriter("3. Loan System", 40);
        typeWriter("4. Fraud Detection", 40);
        typeWriter("5. Analytics", 40);
        typeWriter("6. Exit", 40);
        System.out.println();
        System.out.print("Enter Input:- ");

        int input = sc.nextInt();

        switch (input) {
            case 1:
                LoadAllData loadAllDataForAvlTree = new LoadAllData();
                loadAllDataForAvlTree.fetchForAvlTree(accountRepository.getAllAccounts());
                AccountManagementMenu accountManagementMenu = new AccountManagementMenu();
                accountManagementMenu.accountManagementMenu();
                break;

            case 2:
                LoadAllData loadAllData = new LoadAllData();
                loadAllData.fetchForTransactionGraph(transactionRepository.getAllTransactions());
                loadAllData.fetchForAvlTree(accountRepository.getAllAccounts());
                TransactionSystemMenu transactionSystem = new TransactionSystemMenu();
                transactionSystem.traceInstructions();
                break;
            case 3:
                System.out.println("Under maintainance !!");
                break;
            case 4:
                System.out.println("Under maintainance !!");
                break;
            case 5:
                System.out.println("Under maintainance !!");
                break;
            case 6:
                System.out.println("Under maintainance !!");
                break;

            default:
                break;
        }

        System.out.println("\n==============================================");

    }
}
