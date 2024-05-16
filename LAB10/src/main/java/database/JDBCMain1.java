package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Carolina Cretu
 */
public class JDBCMain1 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/books"; // url pentru o baza de date locala mysql denumita books, folosind portul 3306
        try {
            Connection connection = DriverManager.getConnection(url); // obtine conexiunea
            Statement statement = connection.createStatement(); // creare de Statement
            String query = "SELECT * FROM Customer";
            ResultSet rs = statement.executeQuery(query); // executarea query ului

            while (rs.next()) { // procesarea rezultatului
                System.out.println(rs.getInt("CustomerID" + " ")); // printarea coloanelor
                System.out.println(rs.getString("FirstName" + " "));
                System.out.println(rs.getString("LastName" + " "));
                System.out.println(rs.getString("Email" + " "));
                System.out.println(rs.getString("Phone"));
            }
        } catch (SQLException e) {
            System.out.println("Error when trying to get the customer data");
            e.printStackTrace();
        }
    }
}
