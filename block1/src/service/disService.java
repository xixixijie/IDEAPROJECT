package service;

import DBUtil.DBUtil;
import dao.disDAO;
import dao.disDAOImp;
import entity.Administrator;
import entity.Distribution;
import entity.MissionList;
import entity.Receipt;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 2018/6/15.
 */
public class disService {
    private disService(){

    }

    private static disService service=new disService();

    public static disService getService(){
        return service;
    }

    public List<Distribution> printDis(int[] tid, Administrator administrator) {
        List<Distribution> list=new ArrayList<>();
        for(int i=0;i<tid.length;i++){
            list.add(printDis(tid[i],administrator));
        }

        return list;
    }

    public Distribution printDis(int tid, Administrator administrator){
        Connection connection=DBUtil.getConn();
        disDAO dao=new disDAOImp(connection);
        Distribution dis=dao.getDis(tid);
        if(dis!=null){
            return dis;
        }else {
            //通过毫秒值获得唯一id
            int rid= (int) System.currentTimeMillis();

            recService.getService().generateRec(rid,administrator);

            //新建dis
            generateDis(tid,rid,administrator);
            dis=dao.getDis(tid);
            //生成相应的receipt
            return dis;
        }


    }
    public void generateDis(int tid, int rid, Administrator administrator){
        Connection connection=DBUtil.getConn();
        disDAO dao=new disDAOImp(connection);
        DBUtil.beginTransaction(connection);
        Distribution distribution=new Distribution();

        MissionList missionList=new MissionList();
        missionList.setMissionID(tid);
        distribution.setMissionList(missionList);

        Receipt receipt=new Receipt();
        receipt.setRid(rid);
        distribution.setReceipt(receipt);

        dao.generateDis(distribution,administrator);

        DBUtil.commit(connection);

    }
}
