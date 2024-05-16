package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Carolina Cretu
 */
public class JDBCMain2 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/books"; // url pentru o baza de date locala mysql denumita books, folosind portul 3306
        try {
            Connection connection = DriverManager.getConnection(url); // obtine conexiunea
            Statement statement = connection.createStatement(); // creare de Statement
            ResultSet rs;
            int numRows;
            boolean status = statement.execute(""); // true daca este un ResultSet
            if (status) {
                rs = statement.getResultSet(); //luam ResultSet ul
                //procesam result setul..
            } else {
                numRows = statement.getUpdateCount(); // daca e false, luam nr de randuri afectate
                if (numRows == -1) { // nu avem rezultate
                    System.out.println("No results");
                } else { // altfel, printam numarul de randuri afectate
                    System.out.println(numRows + (" randuri afectate"));
                }
            }


        } catch (SQLException e) {
            System.out.println("Error when trying to get the customer data");
            e.printStackTrace();
        }
    }
}
