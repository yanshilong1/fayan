package buynotes;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by ysl on 18-8-7.
 */

public class JDBCconnection {
    static Logger logger=Logger.getLogger(JDBCconnection.class);
    public static Connection  getconnection(){


        String DRIVER_CLASS = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://127.0.0.1:3306/share";
        String USERNAME = "root";
        String PASSWORD = "123456";
        Connection connectionn = null;
        Connection coon = null;

        try {
            Class.forName(DRIVER_CLASS);


        } catch (ClassNotFoundException e) {
            logger.warn("JDBC驱动加载错误"+e);
        }
        try {
            coon= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            logger.warn("JDBC连接错误"+e);
        }

        return coon;
    }
}
