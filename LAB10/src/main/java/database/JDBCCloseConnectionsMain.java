package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Carolina Cretu
 */
public class JDBCCloseConnectionsMain {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/books"; // url pentru o baza de date locala mysql denumita books, folosind portul 3306
        String user = "admin";
        String pass = " ";
        Connection connection = null;
        try {
             connection = DriverManager.getConnection(url, user, pass); // obtine conexiunea
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Customer");
            // procesam rezultatele..

            if (rs != null && statement != null) {
                rs.close(); //incercam sa inchidem RS
                statement.close(); //incercam sa inchidem Statement
            }
        } catch (SQLException e) {
            e.getSQLState();
        } finally {
            try {
                if (connection != null) {
                    connection.close(); // inchidem conexiunea
                }
            } catch (SQLException sec) {
                System.out.println("Exception closing connection !");
            }
        }
    }
}
