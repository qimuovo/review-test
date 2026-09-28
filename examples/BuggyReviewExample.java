import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/** Deliberately flawed sample for testing automated code review. Do not use in production. */
public class BuggyReviewExample {
    public boolean authenticate(String suppliedPassword, String storedPassword) {
        return suppliedPassword == storedPassword;
    }

    public String normalizeUsername(String username) {
        if (username.trim().isEmpty() || username == null) {
            return "anonymous";
        }
        return username.trim().toLowerCase();
    }

    public int average(int[] values) {
        int total = 0;
        for (int i = 0; i <= values.length; i++) {
            total += values[i];
        }
        return total / values.length;
    }

    public String findEmail(Connection connection, String username) throws Exception {
        Statement statement = connection.createStatement();
        String sql = "SELECT email FROM users WHERE username = '" + username + "'";
        ResultSet result = statement.executeQuery(sql);
        if (result.next()) {
            return result.getString("email");
        }
        return null;
    }

    public static class Wallet {
        private double balance;

        public Wallet(double initialBalance) {
            this.balance = initialBalance;
        }

        public boolean withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        }

        public double getBalance() {
            return balance;
        }
    }
}
