package setnotes;

import buynotes.JDBCconnection;
import buynotes.notesDao;
import org.apache.log4j.Logger;
import setnotes.setnumber;

import java.sql.*;

/**
 * Created by ysl on 18-8-7.
 *trade获取被购买人的id---通过id获取cid account date describe-- 传入以新的（用户id生成的）id为zhujian的goods表中
 *
 * 用户通过新的id可以查询自身的交易记录
 *
 * 返回1 说明插入成
 *
 *
 */
public  class setnote {
    Logger logger=Logger.getLogger(setnote.class);
    public  int setnote(getActive active)

    {


        int userid=active.getUserid();//获取购物的用户id
        int tradeid = active.getGoodsid();//获取购买的物品id
        Connection coon = JDBCconnection.getconnection();
        System.out.println("用户的id是 "+userid);
        System.out.println("购买的商品的id是： "+tradeid);


        String newid =new setnumber().setuserid(userid);//这里就是 id


        int i = 0;
        String sql = "select * from trade where id="+tradeid;
         notesDao newnotes=new notesDao();




        {
            try {
                Statement statement=coon.createStatement();
                ResultSet s=statement.executeQuery(sql);
                System.out.println("查询TRADE表的SQL 已经执行");
                System.out.println("SQL=:"+sql);
                while (s.next()){
                    String rr="12112";
                    newnotes.setId(Integer.parseInt(rr));
                    //newnotes.setId(newid)
//                    newnotes.setDate(s.getString("csaledata "));
//                    newnotes.setDescride(s.getString("cdescribe"));
//                    newnotes.setAccount(s.getDouble("caccount "));
                    //newnotes.setId(s.getInt("id"));
                   // newnotes.getCid(s.getInt("cid"));
                   // newnotes.setId(newid);
                  // newnotes.setCaccount(s.getDouble(" caccount"));
                   newnotes.setCdata(s.getString("csaledata"));
                   newnotes.setCdescribe(s.getString("cdescribe"));


                }
            } catch (SQLException e) {
                logger.warn("this is an warn in searching trade table"+e);
            }

        }
//        state1 state=new state1();
//        try {
//            pstmt = (PreparedStatement) conn.prepareStatement(sql);
//            pstmt.setString(1, news.getEnvironmental_type());
//            pstmt.setString(2, news.getContent());
//            i = pstmt.executeUpdate();
//            Statement statement = conn.createStatement();
//            ResultSet rs = statement.executeQuery(mysql);
//            while (rs.next()) {
//                news.setId(rs.getInt("id"));
//            }
//            if (i==1) state.setState(true);
//            else state.setState(false);
//            state.setId(news.getId());
//            statement.close();
//            pstmt.close();
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return state;
//    }
        String sql11="insert into goods(cid,account,date,descride) values( "+newnotes.getId()+","+newnotes.getCaccount()+","+"'"+newnotes.getCdata()+"'"+","+"'"+newnotes.getCdescribe()+"'"+" )";

        try {
            PreparedStatement pstm=coon.prepareStatement(sql11);

            System.out.println("sql已经执行");
            System.out.println("sql=:  "+sql11);
            i=pstm.executeUpdate(sql11);
            System.out.println("订单插入成功  ");
            pstm.close();
            pstm.close();
            coon.close();
        } catch (SQLException e) {
            logger.warn("this is an warn in insert into goods table"+e);
        }
        return i;//返回i表示转化成功
    }



}
