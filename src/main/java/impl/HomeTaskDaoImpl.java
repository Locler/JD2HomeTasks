package impl;

import dao.HomeTaskDao;
import entity.HomeTask;

public class HomeTaskDaoImpl extends DaoImpl<HomeTask> implements HomeTaskDao {
    @Override
    protected Class<HomeTask> getCl() {
        return HomeTask.class;
    }
}
