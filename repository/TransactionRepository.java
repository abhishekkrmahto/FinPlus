package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import database.DBConnection;
import models.Transaction;

public class TransactionRepository {
    DBConnection db = new DBConnection();

    public void initializeDB() throws Exception {

        Connection connection = db.getConnection();

        Statement st = connection.createStatement();

        String sql = """
                CREATE TABLE IF NOT EXISTS transactions(
                    sender_id BIGINT,
                    receiver_id BIGINT NOT NULL,
                    amount BIGINT NOT NULL,
                    date_time TEXT,
                    transaction_id BIGINT NOT NULL PRIMARY KEY
                )
                """;

        st.execute(sql);

        st.close();
        connection.close();
    }

    public boolean addTransaction(Transaction transaction) {
        try {

            initializeDB();

            Connection connection = db.getConnection();

            String sql = """
                    INSERT INTO transactions
                    (sender_id,receiver_id,amount,date_time,transaction_id)
                    VALUES(?,?,?,?,?)
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setLong(1, transaction.getSenderAccountNumber());
            ps.setLong(2, transaction.getReceiverAccountNumber());
            ps.setLong(3, transaction.getAmount());
            ps.setString(4, String.valueOf(transaction.getTimestamp()));
            ps.setLong(5, transaction.getTransactionId());

            int rows = ps.executeUpdate();

            ps.close();
            connection.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Transaction> getAllTransactions() throws Exception {

        initializeDB();

        String sql = "SELECT * FROM transactions";

        Connection connection = db.getConnection();

        Statement st = connection.createStatement();

        ArrayList<Transaction> list = new ArrayList<>();

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {

            Transaction transaction = new Transaction();
            transaction.setSenderAccountNumber(rs.getLong("sender_id"));
            transaction.setReceiverAccountNumber(rs.getLong("receiver_id"));
            transaction.setAmount(rs.getLong("amount"));
            transaction.setTransactionId(rs.getLong("transaction_id"));
            transaction.setTimestamp(
                    java.time.LocalDateTime.parse(rs.getString("date_time")));

            list.add(transaction);
        }

        rs.close();
        st.close();
        connection.close();

        return list;
    }

    public ArrayList<Transaction> getAllTransactionsOfAccount(long senderAccountNumber) throws Exception {
        initializeDB();

        String sql = "SELECT * FROM transactions WHERE sender_id = ?";

        Connection connection = db.getConnection();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, senderAccountNumber);

        ArrayList<Transaction> list = new ArrayList<>();

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Transaction transaction = new Transaction();
            transaction.setSenderAccountNumber(rs.getLong("sender_id"));
            transaction.setReceiverAccountNumber(rs.getLong("receiver_id"));
            transaction.setAmount(rs.getLong("amount"));
            transaction.setTransactionId(rs.getLong("transaction_id"));
            transaction.setTimestamp(
                    java.time.LocalDateTime.parse(rs.getString("date_time")));

            list.add(transaction);
        }

        rs.close();
        ps.close();
        connection.close();

        return list;
    }
}