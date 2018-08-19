package myshop;

/**
 * @Author: yanshilong
 * @Date: 18-8-13 下午7:38
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        User user=new User();
        user.setPhonenumber(176955693);
        user.setId(1);


        getmyshops gg=new getmyshops();
        //gg.getmyshops(user);
        String aa=gg.getmyshop(user);
        System.out.println("这是返回的数据"+aa);
    }
}
