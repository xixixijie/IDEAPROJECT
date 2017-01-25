package client;

import dao.Dao;
import service.Service;
import service.ServiceImpl;

/**
 * Created by xixi on 21/01/2017.
 */
public class Client {
    public static void main(String[] args) {
        //实例化Service实现
        Service service = new ServiceImpl();
        //调用Service实现的方法
        service.serviceMethod();
    }
}
