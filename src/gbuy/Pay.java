package gbuy;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import gprice.*;
import gpassword.*;
import org.apache.log4j.Logger;



/**
 * Created by ysl on 18-7-25.
 *
 *
 *
 * 支付页面 -----支付密码正确————验证余额-----付款成功--返回json数组（成功的对象参数+flag=1）
 *        -------支付密码错误---return=Json的flag'
 */

public class Pay {//数据库连接
   private static Logger log=Logger.getLogger(Pay.class);

    public static Connection getConnection() {
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
               log.warn("this is a warn in link databases"+e);
            }
        } catch (ClassNotFoundException e) {
           log.warn("this is an warn in claa.found"+e);
        }

        return coon;


    }
 //Getmessage getmessage=new Getmessage();

    int id=0;
    int flag;
    int password;//此处为前台获取的密码
    UserDao userDao=new UserDao();


    public String pay(Getmessage getmessage) {//从id获取余额 ，
        id=getmessage.getuserid;
        BigDecimal balance = BigDecimal.valueOf(0.0);

        Connection coon = getConnection();


        //密码验证
        pass user = new pass();
        int flag = user.chack(getmessage);


        if (flag == 1) {

            String sql = "select  balance from user where id=" + id;
            System.out.println("select  balance from User where id=" + id);
            userDao.setId(id);

            try {
                Statement statement = coon.createStatement();
                ResultSet aa = statement.executeQuery(sql);
                System.out.println("sql已经执行");
                while (aa.next()) {
                    balance = BigDecimal.valueOf(aa.getDouble("balance"));




                    System.out.println("这位用户的账户余额为   " + balance);
                }
            } catch (SQLException e) {
               log.warn("this is a exception in ststement"+e);
            }

            //GoodsDao goodsDao=new GoodsDao();
            getprice g = new getprice();
            //调用获取价格的方法
            BigDecimal account = BigDecimal.valueOf(g.getprce(getmessage));//gpricce类里面的商品id传入，获取价格
            int a = balance.compareTo(account);
            if (a == 1 || a == 0) {
                System.out.println("成功支付" + account + "元");
                balance = balance.subtract(account);
                double newbalance = balance.doubleValue();
                Connection connection = getConnection();
                System.out.println("重新存入数据库  金额为  " + newbalance);
                try {
                    String sql1 = "update user set balance=" + newbalance + " where id=" + "1";
                    Statement statement = coon.createStatement();
                    statement.execute(sql1);
                } catch (SQLException e) {
                    log.error("this is is an error in  execute sql "+e);
                }


                try {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                    while (resultSet.next()) {
                        double nowbalance = resultSet.getDouble("balance");
                        System.out.println("剩余金额为" + nowbalance);
                    }
                } catch (SQLException e) {
                    log.error("this is an error in result "+e);
                }
            } else {
                System.out.println("支付失败");
            }
        }else {
            //System.out.println("密码错误");
              String jflag=JSON.toJSONString(flag);
            return jflag;
        }

            //userDao.get
            // (userDao.getBalance()+)

            //(new Gson().toJson();

        ArrayList array=new ArrayList();
        array.add(userDao.getId());
        array.add(userDao.getBalance());
        array.add(userDao.getName());
        array.add(userDao.getPassword());
        array.add(userDao.getPhone());
        array.add(userDao.getSex());
        array.add(flag);//


        String jsonuserDdo=JSON.toJSONString(array);
        System.out.println("返回的JSON数组为：  "+jsonuserDdo);
            return  jsonuserDdo;





            //String("""""""");

        }

    }

