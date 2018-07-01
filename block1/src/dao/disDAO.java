package dao;

import entity.Administrator;
import entity.Distribution;

/**
 * Created by xixi on 2018/6/15.
 */
public interface disDAO {
    Distribution getDis(int tid);



    void generateDis(Distribution distribution, Administrator administrator);
}
