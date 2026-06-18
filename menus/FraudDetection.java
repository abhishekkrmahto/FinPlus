package menus;

public class FraudDetection {
    static void typeWriter(String text, int delay) throws Exception {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(delay);
        }
        System.out.println();
    }

    public void fraudDetection() throws Exception {

        typeWriter("1. Detect Circular Transfers", 40);
        typeWriter("2. Detect High Value Transactions", 40);
        typeWriter("3. Generate Risk Report", 40);

    }
}
