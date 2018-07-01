package dao;

import entity.Administrator;
import entity.MissionList;

import java.util.Date;
import java.util.List;

/**
 * Created by xixi on 2018/6/15.
 */
public interface taskDAO {
    List<MissionList> consultTasks(int TID, Date date, int type, int state, String courierName, int pageSize, int pageNum);

    MissionList consultDetail(int TID);

    void disCourier(int tid, int cid, Administrator administrator);

    List<MissionList> consultTasks(Date beginDate, Date endDate, String goodName);

    int selectCount(int tid, Date date, int type, int state, String courierName, int pageSize);
}
