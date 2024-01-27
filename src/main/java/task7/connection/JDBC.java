package task7.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBC {
    public static final String DATABASE="database";
    public static final String URL_KEY = "url";
    public static final String USER_KEY= "user";
    public static final String PASSWORD_KEY = "password";
    public static final ResourceBundle RESOURCE_BUNDLE=ResourceBundle.getBundle(DATABASE);
    public static Connection connection=null;
    public static final String URL =getValue(URL_KEY);
    public static final String USER=getValue(USER_KEY);
    public static final String PASSWORD = getValue(PASSWORD_KEY);
    private static String getValue(String key){
        return RESOURCE_BUNDLE.getString(key);
    }
    public static Connection connect() throws SQLException {
        connection= DriverManager.getConnection(URL, USER, PASSWORD);
        if(connection==null){
            throw new SQLException();
        }
        else {
            System.out.println("connected");
        }
        return connection;
    }
    public static void close(){
        try{
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Failes to close connection!");
        }
    }
}
