package runner;

import dao.impl.AddressDaoImpl;
import dao.impl.PeopleDaoImpl;
import entity.Address;
import entity.People;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        PeopleDaoImpl peopleDaoImpl = new PeopleDaoImpl();
        AddressDaoImpl addressDaoImpl = new AddressDaoImpl();
        People person1 = People.builder()
                .age(20)
                .surname("Makedon")
                .name("Vadim")
                .build();
        People person2 = People.builder()
                .name("Lera")
                .surname("Stepanova")
                .age(21)
                .build();
        List<People> peopleList = new ArrayList<>();
        peopleList.add(person1);
        peopleList.add(person2);
        Address address1 = Address.builder()
                .houseCount(2)
                .street("Partizanskaya")
                .peopleList(peopleList)
                .build();
        peopleDaoImpl.create(person1);
        peopleDaoImpl.create(person2);
        addressDaoImpl.create(address1);
        addressDaoImpl.delete(1, Address.class);


    }
}
