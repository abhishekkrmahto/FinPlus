package greeting;

import database.DBConnection;
import menus.MainMenu;

public class Welcome {

    static void typeWriter(String text, int delay) throws Exception {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(delay);
        }
        System.out.println();
    }

    static MainMenu mainMenu = new MainMenu();

    public void welcomeScreen() throws Exception {

        System.out.println();
        typeWriter("==============================================", 5);
        typeWriter("            FINPLUS BANKING SYSTEM", 30);
        System.out.println();

        System.out.println();

        typeWriter("Welcome to FinPlus.", 40);

        System.out.println();

        mainMenu.mainMenu();

        System.out.println("\n==============================================");
    }
}
