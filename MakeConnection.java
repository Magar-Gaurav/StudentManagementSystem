package StudentManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MakeConnection {
    public Connection getDBConnection() throws ClassNotFoundException, SQLException {
        // Load MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Replace 'student_db' with your actual database name
        String url = "jdbc:mysql://localhost:3306/studentsdata";
        String user = "root";
        String password = ""; // Use your MySQL root password here

        return DriverManager.getConnection(url, user, password);
    }
}
