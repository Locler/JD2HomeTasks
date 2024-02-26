package impl;

import dao.TaskDao;
import entity.Task;

public class TaskDaoImpl extends DaoImpl<Task> implements TaskDao {
    @Override
    protected Class<Task> getCl() {
        return Task.class;
    }
}
