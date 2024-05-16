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
public class JDBCDatabaseMetaDataMain {

    public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/books"; // url pentru o baza de date locala mysql denumita books, folosind portul 3306
            try {
                Connection connection = DriverManager.getConnection(url); // obtine conexiunea
                DatabaseMetaData databaseMetaData = connection.getMetaData(); // obtinem metadata despre driver/baza de date
                if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                    System.out.println("Supports TYPE FORWARD ONLY");
                }
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" and supports CONCUR_UPDATABLE");
                }
                if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                    System.out.println("Supports TYPE SCROLL INSENSITIVE");
                }
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" and supports CONCUR_UPDATABLE");
                }

                if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                    System.out.println("Supports TYPE SCROLL SENSITIVE");
                }
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" and supports CONCUR_UPDATABLE");

                    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); // obtinem un statement cu tipul de cursor si concurenta dorite
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
