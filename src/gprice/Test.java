package gprice;

import gbuy.UserDao;

/**
 * Created by ysl on 18-8-3.
 */
public class Test {
    public static void main(String[] args) {
        getprice test=new getprice();

     Getmessage getmessage=new Getmessage(1,1);
     //getmessage.setGetgoodsid(1);
        test.getprce(getmessage);
    }
}