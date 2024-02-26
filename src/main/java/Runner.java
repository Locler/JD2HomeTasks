import entity.Address;
import entity.HomeTask;
import entity.WorkTask;
import impl.HomeTaskDaoImpl;
import impl.WorkTaskDaoImpl;
import utils.HibernateUtil;

public class Runner {
    public static void main(String[] args) {
        HomeTaskDaoImpl homeTaskDao = new HomeTaskDaoImpl();
        WorkTaskDaoImpl workTaskDao = new WorkTaskDaoImpl();
        Address address = Address.builder()
                .city("Misnk")
                .street("Ivanovka")
                .build();
        HomeTask homeTask = HomeTask.builder()
                .name("task10")
                .description("easy")
                .address(address)
                .build();
        WorkTask workTask = WorkTask.builder()
                .name("task11")
                .description("hard")
                .cost(20.505)
                .build();
        homeTaskDao.save(homeTask);
        workTaskDao.save(workTask);
        HibernateUtil.close();
    }
}
