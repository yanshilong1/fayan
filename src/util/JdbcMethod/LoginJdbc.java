package util.JdbcMethod;
import mainServer.InHandler;
import org.apache.log4j.Logger;
import pojo.User;
import java.sql.*;
import java.util.*;

/**
 * Created by jingbao on 18-7-5.
 */
public class LoginJdbc {//登录
    private static Logger log = Logger.getLogger(LoginJdbc.class);
    public static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/share?useUnicode" +
                "=true&characterEncoding=utf8";
        String username = "root";
        String password = "507721";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Boolean  select(String sql){
        log.info("LoginJdbc.select");
        Connection conn = getConn();
        System.out.println(sql);
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
           if(rs.next()){
               return true;
           }else {
               return false;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public static int insert(User user){
        log.info("StoreJdbc.insertGoods");
        Connection conn = LoginJdbc.getConn();//Image,Title,Details,Price,
        // Place,Tel,Date
        int i = 0;
        String sql = "insert into  user(uname,upsw,tpsw,uid) values" +
                "(?,?," +
                "?,?);";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,user.getUname());
            pstmt.setString(2,user.getUpsw());
            pstmt.setString(3,user.getTpsw());
            pstmt.setString(4,user.getUid());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

}
