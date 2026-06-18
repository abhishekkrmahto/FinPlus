package menus;

public class Analytics {
    static void typeWriter(String text, int delay) throws Exception {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(delay);
        }
        System.out.println();
    }

    public void analytics() throws Exception {

        typeWriter("1. Monthly Transaction Total", 40);
        typeWriter("2. Top Customers", 40);
        typeWriter("3. Lowest Cost Path", 40);
        typeWriter("4. Connected Accounts", 40);

    }
}
