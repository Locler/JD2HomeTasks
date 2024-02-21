package runner;

import dao.impl.AddressDaoImpl;
import dao.impl.PeopleDaoImpl;
import entity.Address;
import entity.People;

public class Runner {
    public static void main(String[] args) {
        PeopleDaoImpl peopleDaoImpl = new PeopleDaoImpl();
        AddressDaoImpl addressDaoImpl = new AddressDaoImpl();
        People person1 = People.builder()
                .age(20)
                .surname("Makedon")
                .name("Vadim")
                .build();
        Address address1 = Address.builder()
                .houseCount(2)
                .street("Partizanskaya")
                .build();
        peopleDaoImpl.create(person1);
        addressDaoImpl.create(address1);
        peopleDaoImpl.increaseAge();
        addressDaoImpl.increaseHouse();
        addressDaoImpl.delete(1, Address.class);
        peopleDaoImpl.delete(1, People.class);


    }
}
