package util.JdbcMethod;

import org.apache.log4j.Logger;
import pojo.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jingbao on 18-7-6.
 */
public class StoreJdbc {
    private static Logger log = Logger.getLogger(StoreJdbc.class);
    public static int insertGoods(Goods goods) {
        Date date=new Date();
        Long stime=date.getTime();
//        System.out.println(stime);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.format(new Date(stime)));
        log.info("StoreJdbc.insertGoods");
        Connection conn = LoginJdbc.getConn();//Image,Title,Details,Price,
        // Place,Tel,Date
        int i = 0;
        String sql = "insert into  goods(name,price,introduce,stime) values" +
                "(?,?," +
                "?,?);";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,goods.getName());
            pstmt.setString(2,goods.getPrice());
            pstmt.setString(3,goods.getIntroduce());
            pstmt.setString(4,sdf.format(new Date(stime)));
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(sql+":"+i);
        return i;
    }
}
