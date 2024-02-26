package impl;

import dao.WorkTaskDao;
import entity.WorkTask;

public class WorkTaskDaoImpl extends DaoImpl<WorkTask> implements WorkTaskDao {
    @Override
    protected Class<WorkTask> getCl() {
        return WorkTask.class;
    }
}
