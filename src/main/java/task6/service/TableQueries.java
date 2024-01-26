package task6.service;

import task6.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableQueries {

    private static final String SQL_INSERT = "INSERT INTO Person(age,salary,passport,adress,dateOfBirthday,dateTimeCreate,timeToLunch,letter) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SORT_BY_AGE = "SELECT * FROM Person WHERE age>21 ORDER BY dateTimeCreate";

    public static void insert(Connection connection, Person person) throws SQLException {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)){
        preparedStatement.setInt(1, person.getAge());
        preparedStatement.setFloat(2, person.getSalary());
        preparedStatement.setString(3, person.getPassport());
        preparedStatement.setString(4, person.getAdress());
        preparedStatement.setDate(5, person.getDateOfBirthday());
        preparedStatement.setTimestamp(6, person.getDateTimeCreate());
        preparedStatement.setTime(7, person.getTimeToLunch());
        preparedStatement.setString(8, person.getLetter());
        preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

    }

    public static void sortByAge(Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SORT_BY_AGE)){
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Id\tAge\tSalary\t\tPassport\t\tAdress\t\tDateOfBirthday\t\tDateTimeCreate\t\tTimeToLunch\t\tLetter");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t" + resultSet.getInt(2) + "\t" + resultSet.getInt(3) + "\t\t" + resultSet.getString(4) + "\t\t" + resultSet.getString(5) + "\t\t" + resultSet.getDate(6) + "\t\t" + resultSet.getTimestamp(7) + "\t\t" + resultSet.getTime(8) + "\t\t" + resultSet.getString(9));
            }
            resultSet.close();
        }
        catch (SQLException se){
            se.printStackTrace();
        }
    }
}
