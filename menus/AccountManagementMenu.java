package menus;

import java.util.Scanner;

import services.AccountService;
import utils.FastScanner;

public class AccountManagementMenu {
    static void typeWriter(String text, int delay) throws Exception {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(delay);
        }
        System.out.println();
    }

    static Scanner sc = new Scanner(System.in);

    public void accountManagementMenu() throws Exception {

        typeWriter("1. Create Account", 40);
        typeWriter("2. Search Account", 40);
        typeWriter("3. Loan System", 40);
        typeWriter("4. Delete Account", 40);

        int input = sc.nextInt();

        switch (input) {
            case 1:
                AccountService accountService = new AccountService();
                accountService.createAccount();
                break;
            case 2:
                System.out.println("Under Maintainance");
                break;
            case 3:
                System.out.println("Under Maintainance");
                break;
            case 4:
                System.out.println("Under Maintainance");
                break;

            default:
                break;
        }

    }
}
