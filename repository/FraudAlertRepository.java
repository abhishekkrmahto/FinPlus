package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DBConnection;
import models.Account;
import models.FraudAlert;

public class FraudAlertRepository {

    DBConnection db = new DBConnection();

    public void initializeDB() throws Exception {

        Connection connection = db.getConnection();

        Statement st = connection.createStatement();

        String sql = """
                CREATE TABLE IF NOT EXISTS fraud_alerts(
                    account_id BIGINT PRIMARY KEY,
                    risk_level BIGINT
                )
                """;

        st.execute(sql);

        st.close();
        connection.close();
    }

    public FraudAlert getFraudData(long senderAccountNumber) {
        try {

            initializeDB();

            Connection connection = db.getConnection();

            String sql = "SELECT * FROM fraud_alerts WHERE account_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setLong(1, senderAccountNumber);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                FraudAlert fraudAlert = new FraudAlert();
                fraudAlert.setAccountId(rs.getLong("account_id"));
                fraudAlert.setRiskScore(rs.getInt("risk_level"));
                return fraudAlert;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateFraud(long id, int newRiskLevel) {
        try {

            initializeDB();
            Connection connection = db.getConnection();

            String sql = "UPDATE fraud_alerts SET risk_level = ? WHERE account_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setLong(1, newRiskLevel);
            ps.setLong(2, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
