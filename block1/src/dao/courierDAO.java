package dao;

import entity.Courier;

import java.util.List;

/**
 * Created by xixi on 2018/6/20.
 */
public interface courierDAO {
    String getCourierName(int cid);

    List<Courier> getCouriers();
}
