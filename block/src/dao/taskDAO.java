package dao;

import entity.Task;

import java.util.Date;
import java.util.List;

/**
 * Created by xixi on 2018/6/15.
 */
public interface taskDAO {
    List<Task> consultTasks(int TID, Date date, int type, int state, String courierName);

    Task consultDetail(int TID);

    void disCourier(int tid, int cid);
}
