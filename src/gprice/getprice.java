package gprice;

import java.sql.*;
import  org.apache.log4j.Logger;

import  gpassword.*;
import mainServer.InHandler;
/**
 * Created by ysl on 18-7-29.
 */

public class getprice {

  private static  Logger log=Logger.getLogger(getprice.class);
    public static Connection getconnection() throws SQLException {
        String DRIVER_CLASS = "com.mysql.jdbc.Driver";
         String URL = "jdbc:mysql://127.0.0.1:3306/share";
         String USERNAME = "root";
          String PASSWORD = "123456";
          Connection coon=null;
        try {
            Class.forName(DRIVER_CLASS);
            coon=(Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            log.warn("this is an warn in found driver"+e);
        }

        return coon;
    }
          pass p=new pass();


    public double getprce(Getmessage goods){//传入参数为商品的
        //GoodsDao ss=new GoodsDao();//获取物品价格
        double account=0;
       // ss.setId(1);
        int id=goods.getgoodsid;
        GoodsDao ss=new GoodsDao();

        try {

            Connection coon=getconnection();
            String sql="select caccount from trade where id ="+id;
            System.out.println(sql);
            Statement statement=coon.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                 account=resultSet.getDouble("caccount");
//                 ss.setAccount(account);
//                 ss.setId(id);
               // ss.setId(resultSet.getInt("id"));
               // ss.setDescride(resultSet.getString("descride"));

            }
           // UserDao userDao=new UserDao();
        } catch (SQLException e) {
           log.error("this is an error in dosql "+e);
        }
      //  System.out.println("物品的id是"+ss.getId());
        System.out.println("返回的物品价格是  "+account);
      //  System.out.println("物品的简介是"+ss.getDescride());

     return  account;
    }
}
