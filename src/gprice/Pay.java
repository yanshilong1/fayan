//package gprice;
///**
// * Created by ysl on 18-7-21.
// */
//public class Pay {
//
////    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
////    public static final String URL = "jdbc:mysql://127.0.0.1:3306/share";
////    public static final String USERNAME = "root";
////    public static final String PASSWORD = "123456";
////    public static void main(String[] args) throws SQLException {
////        Connection connection=null;
////        Statement statement=null;
////        try {
////            Class.forName(DRIVER_CLASS);
////        } catch (ClassNotFoundException e) {
////            //log.error("This is an error"+e);
////        e.printStackTrace();
////        }
////        try {
////            connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
////            System.out.println("数据库连接成功");
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////
////        statement= connection.createStatement();
////        String str="select * from goods";
////        ResultSet ss=statement.executeQuery(str);
////        while (ss.next()){
////            System.out.println(ss.getString("id"));
////            System.out.println(ss.getString("cid"));
////
////        }
////        ss.close();
////        statement.close();
////        connection.close();
////
////        }
//   // UserDao userDao=new UserDao(01,23.0);
//
//    public static double main(String[] args) {
//        int flag=0;
//
//        UserDao userDao=new UserDao(1,122.0);
//        double balance=userDao.getBalance();
//        int id=userDao.getId();
//     GoodsDao goodsDao=new GoodsDao();
//      int account= 0;
//      if(balance>account){
//          balance=balance-account;
//          flag=1;
//          return balance;
//
//      }else {
//          return balance;
//      }
//
//    }
//
//
//    }
//
//
//
