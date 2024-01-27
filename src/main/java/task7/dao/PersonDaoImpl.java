package task7.dao;

import task7.entity.Person;
import task7.connection.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDAO {
    private static final String SQL_SAVE = "INSERT INTO Person(age,salary,passport,adress,dateOfBirthday,dateTimeCreate,timeToLunch,letter) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Person set age=?,salary=?,passport=?,adress=?,dateOfBirthday=?,dateTimeCreate=?,timeToLunch=?,letter=? WHERE id=?";
    public static final String SQL_DELETE = "DELETE FROM Person WHERE id=?";
    public static final String SQL_GET_BY_ID = "SELECT*FROM Person WHERE id=?";
    public static final String SQL_SELECT_ALL = "SELECT * FROM Person";

    @Override
    public void save(Person person) {
        quieryMethod(person, SQL_SAVE);
    }

    @Override
    public void update(Person person, int id) {
        try (Connection connection = JDBC.connect(); PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, person.getAge());
            preparedStatement.setFloat(2, person.getSalary());
            preparedStatement.setString(3, person.getPassport());
            preparedStatement.setString(4, person.getAdress());
            preparedStatement.setDate(5, person.getDateOfBirthday());
            preparedStatement.setTimestamp(6, person.getDateTimeCreate());
            preparedStatement.setTime(7, person.getTimeToLunch());
            preparedStatement.setString(8, person.getLetter());
            preparedStatement.setInt(9, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void quieryMethod(Person person, String quiery) {
        try (Connection connection = JDBC.connect(); PreparedStatement preparedStatement = connection.prepareStatement(quiery)) {
            preparedStatement.setInt(1, person.getAge());
            preparedStatement.setFloat(2, person.getSalary());
            preparedStatement.setString(3, person.getPassport());
            preparedStatement.setString(4, person.getAdress());
            preparedStatement.setDate(5, person.getDateOfBirthday());
            preparedStatement.setTimestamp(6, person.getDateTimeCreate());
            preparedStatement.setTime(7, person.getTimeToLunch());
            preparedStatement.setString(8, person.getLetter());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = JDBC.connect(); PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Person buildPerson(ResultSet resultSet) throws SQLException {
        return Person.builder()
                .age(resultSet.getInt(2))
                .salary(resultSet.getFloat(3))
                .passport(resultSet.getString(4))
                .adress(resultSet.getString(5))
                .dateOfBirthday(resultSet.getDate(6))
                .dateTimeCreate(resultSet.getTimestamp(7))
                .timeToLunch(resultSet.getTime(8))
                .letter(resultSet.getString(9))
                .build();
    }

    @Override
    public Person getById(int id) {
        try (Connection connection = JDBC.connect(); PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next() ? buildPerson(resultSet) : null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> getAll() {
        List<Person> personList = new ArrayList<>();
        try (Connection connection = JDBC.connect(); PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL)) {
            try (ResultSet resultSet=preparedStatement.executeQuery()){
                while (resultSet.next()){
                    personList.add(buildPerson(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personList;
    }
}