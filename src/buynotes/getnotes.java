package buynotes;
import com.alibaba.fastjson.JSON;

import org.apache.log4j.Logger;
import setnotes.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by ysl on 18-8-7.
 * 通过id 获取自己的全部记录
 * 这个id是用户的id
 *
 */

public class getnotes {
      static Logger logger=Logger.getLogger(getnotes.class);
    static Connection conn=JDBCconnection.getconnection();

    public String getnotes(User user){//用户传入id

        setnumber s=new setnumber();
        int iii=user.getId();
        String id= s.setuserid(iii);//转化的id
         int trueid=Integer.parseInt(id);
        String sql="select * from goods where id like "+trueid;

        System.out.println("sql=select * from goods where cid like "+trueid);
          logger.info("这是请求的sql "+sql);
        ArrayList<notesDao> list=new ArrayList();
        try {
            Statement statement=conn.createStatement();

            ResultSet set=statement.executeQuery(sql);

            while (set.next()){
                notesDao Dao=new notesDao();
                 Dao.setId(set.getInt("cid"));
                // Dao.setCtype(set.getString("ctype"));
                 Dao.setCdescribe(set.getString("descride"));
                 Dao.setCaccount(set.getDouble("account"));
                 Dao.setCdata(set.getString("date"));
             list.add(Dao);
            }
        } catch (SQLException e) {
           logger.error("获取购买的memory:"+e);
        }
//        String json=JSON.toJSONString(arrayList);
//        System.out.println("这是对象数组的JSON"+json);
//        ArrayList aa=JSON.parseObject(json,ArrayList.class);
//        System.out.println(aa);
//        JsonArray json=
         String json= JSON.toJSONString(list);
        System.out.println("用户共有 "+list.size()+" 条购买记录");
        System.out.println("返回的数据是 "+json);

          return json ;


    }





}
