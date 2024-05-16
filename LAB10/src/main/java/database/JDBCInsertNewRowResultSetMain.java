package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Carolina Cretu
 */
public class JDBCInsertNewRowResultSetMain {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/books"; // url pentru o baza de date locala mysql denumita books, folosind portul 3306
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT AuthorId, FirstName, LastName FROM Author ";
            ResultSet rs = statement.executeQuery(query);
            rs.next(); // mutam cursorul
            rs.moveToInsertRow(); //pasul 1, ne pozitionam pentru a insera randul
            rs.updateInt("AuthorId", 1055); // adaugam valorile pentru randul pe care vrem sa il inseram
            rs.updateString("FirstName", "Emil"); // adaugam valorile pentru randul pe care vrem sa il inseram
            rs.updateString("LastName", "Cioran"); // adaugam valorile pentru randul pe care vrem sa il inseram
            rs.insertRow(); // pasul 3, scriem randul in db
            rs.moveToCurrentRow(); // intoarce cursorul la randul la care era inainte sa apelam moveToInsertRow()
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
