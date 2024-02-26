package dao;

import entity.Address;

public interface AddressDao extends Dao<Address> {
    void increaseHouse();
}
