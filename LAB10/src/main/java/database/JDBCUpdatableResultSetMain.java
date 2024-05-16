package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Carolina Cretu
 */
public class JDBCUpdatableResultSetMain {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/books"; // url pentru o baza de date locala mysql denumita books, folosind portul 3306
        try {
            Connection connection = DriverManager.getConnection(url); // obtine conexiunea
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); // creare de Statement cu result set care poate fi modificat si cursor care poate fi mutat
            String query = "SELECT UnitPrice FROM Book " +
                    "WHERE Format = 'Audiobook'";
            ResultSet rs = statement.executeQuery(query); // populam result set ul
            while (rs.next()) {
                if (rs.getFloat("UnitPrice") == 10.95f) { // verificam fiecare rand sa vedem daca are pretul pe care il cautam
                    rs.updateFloat("UnitPrice", 11.95f); // setam noul pret
                    rs.updateRow(); // updatam randul in baza de date; metoda aceasta scrie randul in db
                    //rs.cancelRowUpdates(); // in caz ca ne razgandim, apelam asta in loc de updateRow()
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
