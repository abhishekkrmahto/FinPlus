package menus;

import java.util.Scanner;

import utils.FastScanner;

public class MainMenu {

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

        int input = sc.nextInt();

        switch (input) {
            case 1:
                AccountManagementMenu accountManagementMenu = new AccountManagementMenu();
                accountManagementMenu.accountManagementMenu();
                break;

            case 2:
                System.out.println("Under maintainance !!");
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
