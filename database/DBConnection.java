package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/finpulse";

    private static final String USER = "postgres";
    private static final String PASSWORD = "Abhishek@2025";

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void connect() {
        DBConnection connection = new DBConnection();
        try {
            Connection con = connection.getConnection();
            System.out.println("Connected Successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
