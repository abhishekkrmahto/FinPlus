package menus;

import java.util.Scanner;

import services.TransactionService;

public class TransactionSystemMenu {
    Scanner sc = new Scanner(System.in);
    TransactionService transactionService = new TransactionService();

    static void typeWriter(String text, int delay) throws Exception {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(delay);
        }
        System.out.println();
    }

    static long convertStringAccountToLong(String account) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < account.length(); i++) {
            if (account.charAt(i) >= '0' && account.charAt(i) <= '9') {
                s.append(account.charAt(i));
            }
        }
        Long accLong = Long.parseLong(s.toString());
        return accLong;
    }

    public void traceInstructions() throws Exception {

        typeWriter("1. Transfer Money", 40);
        typeWriter("2. Transaction History", 40);
        typeWriter("3. Sort Transactions", 40);
        System.out.println();

        System.out.print("Enter Input:- ");
        int input = sc.nextInt();

        switch (input) {
            case 1:
                System.out.print("Enter Sender Account Number:- ");
                String senderAccString = sc.next();
                long senderAccountNumber = convertStringAccountToLong(senderAccString);
                System.out.print("Enter Receiver Account Number:- ");
                String recevierAccString = sc.next();
                long receiverAccountNumber = convertStringAccountToLong(recevierAccString);
                transactionService.makeTransaction(senderAccountNumber, receiverAccountNumber);
                break;
            case 2:
                System.out.println("Pending ..... ");
                break;

            case 3:
                System.out.println("Pending ..... ");
                break;

            default:
                break;
        }
    }

}
