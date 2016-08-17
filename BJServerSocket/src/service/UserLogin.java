package service;

import assist.DBConnection;

import java.io.*;
import java.sql.*;


public class UserLogin {
    private String user_id = null;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private Connection con=null;
    private ResultSet rs = null;
    private String user_pw=null;

    public UserLogin(BufferedReader in,PrintWriter out){

        try {
            con=new DBConnection().getConnection();
            Statement sta=con.createStatement();
            this.in=in;
            this.out=out;
            rs=sta.executeQuery("SELECT u_id,u_password from user ");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        checkUser();
        checkPassword();
    }


    private void checkUser() {


        while (true) {
            //读取客户端发来的用户id
            try {
                user_id = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //判断是否有此id
            try {
                while(rs.next()){
                    String u_id=rs.getString(1);
                    if(u_id.equals(user_id))
                        out.println(true);
                }
                 out.println(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }


    private void checkPassword() {

        while (true) {
            //读取客户端传来的密码
            try {
                user_pw = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //判断
            try {
                while (rs.next()) {
                    String u_id = rs.getString(1);
                    String u_password = rs.getString(2);
                    if (u_id.equals(user_id) && u_password.equals(user_pw)) {
                        out.println(true);
                        out.flush();

                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            out.println(false);
            out.flush();
        }
    }
}
