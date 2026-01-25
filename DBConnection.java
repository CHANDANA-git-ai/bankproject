package bank;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Creates and returns database connection
 */
public class DBConnection {
    // Method to get database connection
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
    
        // Database connection details
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bank_db",
                "root",
                "cd177257"
        );
    }
}
