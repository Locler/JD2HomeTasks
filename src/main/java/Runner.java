import entity.Address;
import entity.HomeTask;
import entity.Task;
import impl.TaskDaoImpl;


public class Runner {
    public static void main(String[] args) {
        TaskDaoImpl taskDao = new TaskDaoImpl();
        Address address = Address.builder()
                .city("asdasdad")
                .street("Asdasdad")
                .build();
        Task task = HomeTask.builder()
                .description("asdad")
                .name("adadad")
                .address(address)
                .build();
        taskDao.save(task);
    }
}
