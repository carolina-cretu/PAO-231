package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Carolina Cretu
 */
public class JDBCMetadataMain {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/books"; // url pentru o baza de date locala mysql denumita books, folosind portul 3306
        try {
            Connection connection = DriverManager.getConnection(url); // obtine conexiunea
            Statement statement = connection.createStatement(); // creare de Statement
            String query = "SELECT authorId FROM Author";
            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData(); //obtinerea de metadata
            rs.next();
            int colCount = rsmd.getColumnCount(); // nr de coloane in ResultSet
            System.out.println("Column count: " + colCount);

            for (int i = 1; i <= colCount; i++) {
                System.out.println("TableName: " + rsmd.getTableName(i));
                System.out.println("ColumnName: " + rsmd.getColumnName(i));
                System.out.println("ColumnSize: " + rsmd.getColumnDisplaySize(i));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
