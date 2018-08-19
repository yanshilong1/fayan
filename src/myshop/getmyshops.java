package myshop;
import buynotes.JDBCconnection;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @Author: yanshilong
 * @Date: 18-8-13 下午6:47
 * @Version 1.0
 */
public class getmyshops {
    int phonenumber;
    String date;
     static Logger logger=Logger.getLogger(getmyshops.class);
     static Connection coon=JDBCconnection.getconnection();

      ArrayList<ShopDao> list=new ArrayList<>();

     public String getmyshop(User user){

          phonenumber=user.getPhonenumber();
           String sql="select * from trade where columnphone="+phonenumber;
           logger.debug("this is search sql "+sql);
         try {
             Statement statement=coon.createStatement();
             ResultSet aaaa=statement.executeQuery(sql);
             while (aaaa.next()){
                 ShopDao shopDao=new ShopDao();
                 shopDao.setCaccount(aaaa.getDouble("caccount"));
                 shopDao.setCdata(aaaa.getString("cdata"));
                 shopDao.setCsaledate(aaaa.getString("csaledata"));
                 shopDao.setCaccount(aaaa.getDouble("csaleaccount"));
                 shopDao.setCtype(aaaa.getString("ctype"));
                 shopDao.setCdescribe(aaaa.getString("cdescribe"));
                 shopDao.setCstate(aaaa.getString("cstate"));
                 shopDao.setPhone(aaaa.getInt("columnphone"));
                 list.add(shopDao);
             }



         } catch (SQLException e) {
             logger.debug("this is createstatement "+e);
         }

         String json=JSON.toJSONString(list);
         logger.info("this is return json"+json);


        return json;
     }
}
