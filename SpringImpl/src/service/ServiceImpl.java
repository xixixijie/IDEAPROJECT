package service;

import Contain.Container;
import dao.Dao;
import dao.DaoImpl;

/**
 * Created by xixi on 20/01/2017.
 */
public class ServiceImpl implements Service {
    //实例化Dao实现
    private Dao dao = (Dao) Container.getComponent("DaoImpl");

    @Override
    public void serviceMethod() {
        //调用Dao实现的方法
        dao.daoMethod();
    }
}
