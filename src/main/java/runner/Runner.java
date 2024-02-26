package runner;

import dao.impl.AddressDaoImpl;
import dao.impl.PeopleDaoImpl;
import entity.Address;
import entity.People;


import java.util.HashSet;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        PeopleDaoImpl peopleDaoImpl = new PeopleDaoImpl();
        AddressDaoImpl addressDaoImpl = new AddressDaoImpl();
        Set<People> peopleList = new HashSet<>();
        Set<Address> addressList = new HashSet<>();

        People person1 = People.builder()
                .age(20)
                .surname("Makedon")
                .name("Vadim")
                .build();
        Address address1 = Address.builder()
                .houseCount(2)
                .street("Partizanskaya")
                .build();
        Address address2 = Address.builder()
                .houseCount(6)
                .street("Golololv")
                .build();
        People person2 = People.builder()
                .age(23)
                .surname("Stepanova")
                .name("Valery")
                .build();
        addressDaoImpl.create(address1);
        addressDaoImpl.create(address2);
        peopleDaoImpl.create(person1);
        peopleDaoImpl.create(person2);
        addressList.add(address1);
        addressList.add(address2);
        peopleList.add(person1);
        peopleList.add(person2);
        person2.setAddresses(addressList);
        address2.setPeople(peopleList);
        person1.setAddresses(addressList);
        address1.setPeople(peopleList);
        peopleDaoImpl.update(person2);
        addressDaoImpl.update(address2);
        peopleDaoImpl.update(person1);
        addressDaoImpl.update(address1);


    }
}
