package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Carolina Cretu
 */
public class JDBCUpdatableResultSetMain2 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/books"; // url pentru o baza de date locala mysql denumita books, folosind portul 3306
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM Book " +
                    "WHERE ISBN = '1234567UYW'";
            ResultSet rs = statement.executeQuery(query);
           rs.next(); // mutam cursorul
           rs.updateObject("PubDate", "2005-04-23"); // Modificare pe PubDate folosind un String pentru tipul de date SQL DATE. De observat ca String-ul respecta formatul java.sql.Date "yyyy-[m]m-[d]d" si poate fi convertit si stocat ca Date
           rs.updateRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
