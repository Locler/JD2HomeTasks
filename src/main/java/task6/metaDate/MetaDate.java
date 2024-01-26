package task6.metaDate;

import java.sql.*;

public class MetaDate {

    private static final String QUERY = "SELECT * from Person";

    public static void metaDateInfo(Connection connection) {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(QUERY)
        ) {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int number = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= number; i++) {
                System.out.println("Column Name:" + resultSetMetaData.getColumnName(i));
                System.out.println("Column Type" + resultSetMetaData.getColumnType(i));
                System.out.println("Display Size: " + resultSetMetaData.getColumnDisplaySize(i));
                System.out.println("Precision: " + resultSetMetaData.getPrecision(i));
                System.out.println("Scale:" + resultSetMetaData.getScale(i));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
