import database.DBConnection;
import greeting.Welcome;

public class Main {

    public static void main(String[] args) throws Exception {
        Welcome welcome = new Welcome();
        DBConnection connection = new DBConnection();

        // =============================FUNCTION CALLS==================================

        // javac -cp ".;lib\postgresql-42.7.7.jar" Main.java
        // java -cp ".;lib\postgresql-42.7.7.jar" Main

        // for all
        // javac -cp ".;lib\*" Main.java
        // java -cp ".;lib\*" Main.java

        try {
            connection.connect();
        } catch (Exception e) {
            System.out.println("ERROR WHILE DB CONNECTION");
            return;
        }
        while (true) {
            welcome.welcomeScreen();
        }

    }
}
