package dao.impl;

import dao.AddressDao;
import connection.HibernateUtils;
import entity.Address;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AddressDaoImpl extends DaoImpl<Address> implements AddressDao {
    private static final String SELECT_TWO = "SELECT * FROM Address ORDER BY id DESC LIMIT 2";
    @Override
    public void increaseHouse() {
        EntityManager entityManager= HibernateUtils.getEntityManger();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery(SELECT_TWO, Address.class);
        List<Address> resultList =  query.getResultList();
        if(resultList.size()>1) {
            Address address = resultList.get(0);
            Address address2 =  resultList.get(1);
            address.setHouseCount(address.getHouseCount() + 1);
            address2.setHouseCount(address2.getHouseCount() + 1);
            entityManager.merge(address);
            entityManager.merge(address2);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        else {
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }
}
