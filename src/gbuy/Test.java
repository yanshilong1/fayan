package gbuy;

import gprice.Getmessage;

/**
 * Created by ysl on 18-7-25.
 */
public class Test {

    public static void main(String[] args) {
        Getmessage getmessage=new Getmessage(1,123456);
//        getmessage.setGetgoodsid(1);
//        getmessage.setGetpaypassword(123456);
        getmessage.setGetuserid(1);
      Pay p=new Pay();
       p.pay(getmessage);



    }
}
