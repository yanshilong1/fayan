package gpassword;

import gprice.Getmessage;
import mainServer.InHandler;
import org.apache.log4j.Logger;

import java.sql.*;

/*
* 支付密码比对
* 传入密码getPass
* 数据库密码paypassword
*
返回数据flag=1 密码正确
      flag=0  密码错误
*
* */

public class pass {
    private static Logger log=Logger.getLogger(pass.class);
    public static Connection getConnection() {
        //private static Logger log1=Logger.getLogger(InHandler.class);
        //private static org.apache.log4j.Logger log= org.apache.log4j.Logger.getLogger(InHandler.class);
        String DRIVER_CLASS = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://127.0.0.1:3306/share";
        String USERNAME = "root";
        String PASSWORD = "123456";
        Connection connectionn = null;
        Connection coon = null;
        try {
            Class.forName(DRIVER_CLASS);
            try {
                coon = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
               log.warn("this is a warn in connection "+e);
            }
        } catch (ClassNotFoundException e) {
          //
            //  e.printStackTrace();
            log.warn("this is a warn in found driver"+e);
        }

        return coon;
    }
    //Getmessage  getmessage=new Getmessage();
    public int chack(Getmessage getmessage) {
       // private static Logger log=Logger.getLogger(InHandler.class);
       // int id = 1;
        //int pass =123456;
        int id= getmessage.getuserid;
        int pass= getmessage.getpaypassword;//获取的密码
        int getPass = 0;//正确的密码
        int flag = 0;
        PassDao user;
        PassDao passDao = new PassDao(id,getPass);
        Connection coon = getConnection();
        Statement statement;

        {
            try {
                statement = coon.createStatement();
                String sql = "select paypassword from user where id=" + id;
                ResultSet realpass = statement.executeQuery(sql);
                while (realpass.next()) {
                    getPass = realpass.getInt("paypassword");
                    System.out.println("正确的密码是" + getPass);

                }
                if (getPass == pass) {
                    System.out.println("密码正确");
                    flag = 1;
                } else {
                    System.out.println("密码错误");
                    flag = 0;

                }
            } catch (SQLException e) {
              log.error("this is an error in sql "+e);
            }
        }

      return  flag;
    }
}