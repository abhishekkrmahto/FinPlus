package menus;

public class TransactionSystem {
    static void typeWriter(String text, int delay) throws Exception {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(delay);
        }
        System.out.println();
    }

    public void traceInstructions() throws Exception {

        typeWriter("1. Transfer Money", 40);
        typeWriter("2. Transaction History", 40);
        typeWriter("3. Sort Transactions", 40);

    }
}
