package task7.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {
    private static Connection connection = null;

    private JDBCConnector() {
    }

    public static Connection connect() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(DatabaseSettings.getURL(), DatabaseSettings.getUSER(), DatabaseSettings.getPASSWORD());
        }
        return connection;
    }

    public static void close() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            System.out.println("Failes to close connection!");
        }
    }

}