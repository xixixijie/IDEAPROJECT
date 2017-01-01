package dao;

import DBconnect.DBconnect;
import Entity.NewsEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jay chen on 2016/9/17.
 */
public class newsAction {
    public static List<NewsEntity> randomSearch(String kind1){
        List<NewsEntity> list=new ArrayList<>();
        Connection conn=DBconnect.getConn();
        String[] a=new String[3];
        //kind1 为主要分类，a 为次分类
        if(kind1.equals("competition")){
            a[0]="item";
            a[1]="team";
            a[2]="corporation";
        }else{
            a[0]="video";
            a[1]="study";
            a[2]="software";
        }
        try {
             Statement sm=conn.createStatement();

            ResultSet rs=null;
            NewsEntity news=new NewsEntity();
            //默认展示6个消息
            for(int i=0;i<6;i++){
                String sql="select * from "+kind1+"_"+a[(int)(Math.random()*3)]+" order by id desc ";
                rs=sm.executeQuery(sql);
                rs.next();
                news.setId(rs.getInt(1));
                news.setTitle(rs.getString(2));
                news.setSrc(rs.getString(3));
                list.add(news);
            }
            DBconnect.closeConn(conn,sm,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<NewsEntity> searchNews(String datebase){
        List<NewsEntity> list=new ArrayList<NewsEntity>();
        Connection conn=DBconnect.getConn();
        String sql="select * from "+datebase+" order by id DESC";
        try {
            Statement sm=conn.createStatement();
            ResultSet rs=sm.executeQuery(sql);
            NewsEntity news=new NewsEntity();
            //默认展示6个消息
            for(int i=0;i<6;i++){
                rs.next();
                news.setId(rs.getInt(1));
                news.setTitle(rs.getString(2));
                news.setSrc(rs.getString(3));
                list.add(news);
            }
            DBconnect.closeConn(conn,sm,rs);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
