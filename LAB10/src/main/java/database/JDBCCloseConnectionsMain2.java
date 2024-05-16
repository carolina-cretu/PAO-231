package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Carolina Cretu
 */
public class JDBCCloseConnectionsMain2 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/books"; // url pentru o baza de date locala mysql denumita books, folosind portul 3306
        String user = "admin";
        String pass = " ";

        //inchidem folosind try with resources
        try {
            Connection connection = DriverManager.getConnection(url, user, pass); // obtine conexiunea
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Customer");
            // procesam rezultatele..
        } catch (SQLException e) {
            e.getSQLState();
        }
    }
}
