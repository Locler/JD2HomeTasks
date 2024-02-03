package task6;

import task6.connection.JdbcConnection;
import task6.entity.Person;
import task6.metaDate.MetaDate;
import task6.service.TableQueries;

import java.sql.*;


public class Runner {
    public static void main(String[] args){
        try  (Connection connection= JdbcConnection.connect()){
            Person person=new Person(25,20.22f,"sadasd","asdasdadasd", Date.valueOf("1994-12-12"),   Timestamp.valueOf("2022-01-01 19:19:22"), Time.valueOf("22:10:10"),"i love java");
            TableQueries.insert(connection,person);
            TableQueries.sortByAge(connection);
            MetaDate.metaDateInfo(connection);
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
}
