package Controllers;

import Model.Scholar;
import Model.ScholarContainer;

import java.sql.*;

public class DatabaseController {

    private static String connectionUrl = "";

    public DatabaseController() {
        connectionUrl = "jdbc:sqlserver://localhost:1433;"
                        + "databaseName=TestDB;"
                        + "user=main;"
                        + "password=hidden;"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=150;";
    }
    public void manageDatabase(ScholarContainer container) throws SQLException {

            insertData(container);
            System.out.println("Transaction committed successfully.");
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl);
    }

    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public static void insertData(ScholarContainer container) {

        String insertSQL = "INSERT INTO Scholars (ID, Theory1, Theory2, Theory3, " +
                "Practice1, Practice2, Practice3, Result) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL,
                     ResultSet.TYPE_SCROLL_SENSITIVE,
                     ResultSet.CONCUR_READ_ONLY)) {

            connection.setAutoCommit(false);

            for (Scholar scholar : container) {

                preparedStatement.setString(1, scholar.getId());
                preparedStatement.setFloat(2, scholar.getTheory1Result());
                preparedStatement.setFloat(3, scholar.getTheory2Result());
                preparedStatement.setFloat(4, scholar.getTheory3Result());
                preparedStatement.setFloat(5, scholar.getPractice1Result());
                preparedStatement.setFloat(6, scholar.getPractice2Result());
                preparedStatement.setFloat(7, scholar.getPractice3Result());
                preparedStatement.setString(8, scholar.getFinalGrade());

                preparedStatement.executeUpdate();
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
