package menus;

public class LoanModule {
    static void typeWriter(String text, int delay) throws Exception {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(delay);
        }
        System.out.println();
    }

    public void loanModule() throws Exception {

        typeWriter("1. Apply Loan", 40);
        typeWriter("2. Check Eligibility", 40);
        typeWriter("3. Portfolio Optimization", 40);

    }
}
