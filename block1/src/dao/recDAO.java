package dao;

import entity.Administrator;
import entity.Receipt;

/**
 * Created by xixi on 2018/6/15.
 */
public interface recDAO {
    Receipt getReceipt(int rid);

    void generateRec(int rid, Administrator administrator);
}
