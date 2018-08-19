package mysevlete;


import buynotes.getnotes;
import com.google.gson.Gson;
import control.Login;
import control.State;
import control.Store;
import control.Take;
import gbuy.Pay;
import gprice.Getmessage;
import myshop.getmyshops;
import pojo.Goods;
import pojo.User;
import setnotes.getActive;
import setnotes.setnote;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by jingbao on 18-4-22.
 */
interface MyServlet{
     void doGet();
     void doPost();

}

class ServeletFirst implements MyServlet{
    public ServeletFirst(){}

    @Override
    public void doGet() {
        System.out.println("doGet");
    }

    @Override
    public void doPost() {
        System.out.println("doPost");

    }
}

class ServeletSecond implements MyServlet{
    public ServeletSecond(){}

    @Override
    public void doGet() {
        System.out.println("doGet2");
    }

    @Override
    public void doPost() {
        System.out.println("doPost2");
    }
}

public class ServletTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//       String url="https://www.baidu.com/ServeletFirst/doGet";
//       String []result=url.split("/");
//       Class cls=Class.forName("mysevlete."+result[3]);
//       Constructor con=cls.getConstructor();
//       MyServlet servlet= (MyServlet) con.newInstance();
//        Method doGet=cls.getMethod(result[4]);
//        doGet.invoke(servlet);
//        doServlet("https://www.baidu.com/Store/doStore");
        Goods goods=new Goods();
        Gson g=new Gson();
        System.out.println(g.toJson(goods));

        User user=new User();
        user.setTpsw("507721");
        user.setUpsw("507721");
        user.setUname("17602648919");
        System.out.println(g.toJson(user));

    }

    public static String doServlet(String url,String gson){//     /Pay/pay
        String response="{\"state\":01111}";
        String []result=url.split("/");
        Class cls= null;
        Gson g=new Gson();
        Constructor con=null;
        State s=new State();
        ArrayList arrayList=new ArrayList();
        int state;
        try {
//            cls = Class.forName("control."+result[1]);
//            Constructor con=cls.getConstructor();
            System.out.println(result[1]+"----"+result[2]);
            switch (result[1]){
                case "Store":


                    cls = Class.forName("control."+result[1]);
                    con=cls.getConstructor();
                    Store store= (Store) con.newInstance();
                    Method doStore=cls.getMethod(result[2],Goods.class);
                    state= (int) doStore.invoke(store,new
                            Gson().fromJson(gson,Goods.class));
                    s.setState(state);
                    response=g.toJson(s);
//                    System.out.println(doStore.invoke(store,object));
                    return response;
                case "Take"://1

                    cls = Class.forName("control."+result[1]);
                    con=cls.getConstructor();
                    Take take= (Take) con.newInstance();
                    Method doTake=cls.getMethod(result[2], User.class);
                    state= (int) doTake.invoke(take,new
                            Gson().fromJson(gson,User.class));
                    s=new State();
                    s.setState(state);
                    response=g.toJson(s);
//                    System.out.println(doStore.invoke(store,object));
                    return response;

                    //======================================================================================================================
                case  "Pay"://2 支付请求 by  yanshilong

                    con=cls.getConstructor();
                    cls=Class.forName("gbuy."+result[1]);
                    Pay pay=(Pay) con.newInstance();
                    Method dopay=cls.getMethod(result[2],Getmessage.class);
                    arrayList= (ArrayList) dopay.invoke(pay,new Gson().fromJson(gson,Getmessage.class));
                    response=g.toJson(arrayList);
                    return  response;


                //=========================================================================================================================

                case "getnotes"://3 查看购买的记忆  by  yanshilong
                    cls=Class.forName("buynotes."+result[1]);
                     con=cls.getConstructor();
                    getnotes gnote=(getnotes) con.newInstance();
                    Method getp=cls.getMethod(result[2],User.class);
                    String [] rrr;
                    rrr=(String[]) getp.invoke(gnote,new Gson().fromJson(gson,User.class));
                    arrayList.add(rrr);
                    response=g.toJson(arrayList);
                    return  response;


               //=========================================================================================================================
                case "setnote"://4 购买完成后生成订单  by  yanshilong
                     cls=Class.forName("setnotes."+result[1]);//info
                     con=cls.getConstructor();//shiti
                     setnote duixiang=(setnote) con.newInstance();//duixinag
                     Method fangfa=cls.getMethod(result[2], getActive.class);//fangfa
                      state=(int)fangfa.invoke(duixiang,new Gson().fromJson(gson,getActive.class));
                      s=new State();
                      s.setState(state);
                      response=g.toJson(s);
                      return response;

                //=========================================================================================================================
                case "getmyshops"://5  查看我的shop商品  yanshilong
                      cls=Class.forName("myshop"+result[1]);
                      con=cls.getConstructor();
                    getmyshops  duixiang1=(getmyshops) con.newInstance();
                    Method fangfa1=cls.getMethod(result[2],User.class);
                    String [] eee;
                    eee=(String[]) fangfa1.invoke(duixiang1,new Gson().fromJson(gson,User.class));
                     response=g.toJson(eee);
                     return  response;
                //=========================================================================================================================


                case "Login":

                    cls = Class.forName("control."+result[1]);
                    con=cls.getConstructor();
                    Login login= (Login) con.newInstance();
                    Method doLogin=cls.getMethod(result[2], User.class);
                    state= (int) doLogin.invoke(login,new
                            Gson().fromJson(gson,User.class));
                    s=new State();
                    s.setState(state);
                    response=g.toJson(s);
//                    System.out.println(doStore.invoke(store,object));
                    return response;






            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return response;
    }
}
