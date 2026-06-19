package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;

import database.DBConnection;
import models.Account;

public class AccountRepository {

    DBConnection db = new DBConnection();

    public void initializeDB() throws Exception {

        Connection connection = db.getConnection();

        Statement st = connection.createStatement();

        String sql = """
                CREATE TABLE IF NOT EXISTS accounts(
                    account_id BIGINT PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    balance BIGINT NOT NULL,
                    account_number VARCHAR(200) NOT NULL,
                    email VARCHAR(200) NOT NULL
                )
                """;

        st.execute(sql);

        st.close();
        connection.close();
    }

    public boolean saveAccount(Account account) {

        try {

            initializeDB();

            Connection connection = db.getConnection();

            String sql = """
                    INSERT INTO accounts
                    (account_id,name,balance,account_number,email)
                    VALUES(?,?,?,?,?)
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setLong(1, account.getAccountId());
            ps.setString(2, account.getName());
            ps.setLong(3, account.getBalance());
            ps.setString(4, account.getAccountNumber());
            ps.setString(5, account.getEmail());

            int rows = ps.executeUpdate();

            ps.close();
            connection.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Account findByAccountId(long id) {

        try {

            initializeDB();

            Connection connection = db.getConnection();

            String sql = "SELECT * FROM accounts WHERE account_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Account account = new Account();

                account.setAccountId(rs.getLong("account_id"));
                account.setName(rs.getString("name"));
                account.setBalance(rs.getLong("balance"));
                account.setAccountNumber(rs.getString("account_number"));
                account.setEmail(rs.getString("email"));

                return account;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Account updateBalance(long id, long newBalance) {

        try {

            initializeDB();
            Connection connection = db.getConnection();

            String sql = "UPDATE accounts SET balance = ? WHERE account_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setLong(1, newBalance);
            ps.setLong(2, id);

            ps.executeUpdate();

            String sql2 = "SELECT * FROM accounts WHERE account_id = ?";
            PreparedStatement ps2 = connection.prepareStatement(sql2);

            ps2.setLong(1, id);

            ResultSet rs = ps2.executeQuery();

            if (rs.next()) {

                Account account = new Account();

                account.setAccountId(rs.getLong("account_id"));
                account.setName(rs.getString("name"));
                account.setBalance(rs.getLong("balance"));
                account.setAccountNumber(rs.getString("account_number"));
                account.setEmail(rs.getString("email"));

                return account;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public HashSet<Account> getAllAccounts() throws Exception {

        initializeDB();

        String sql = "SELECT * FROM accounts";

        Connection connection = db.getConnection();

        Statement st = connection.createStatement();

        HashSet<Account> set = new HashSet<>();

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {

            Account account = new Account();

            account.setAccountId(rs.getLong("account_id"));
            account.setName(rs.getString("name"));
            account.setBalance(rs.getLong("balance"));
            account.setAccountNumber(rs.getString("account_number"));
            account.setEmail(rs.getString("email"));

            set.add(account);
        }

        rs.close();
        st.close();
        connection.close();

        return set;
    }
}