package setnotes;

/**
 * @Author: yanshilong
 * @Date: 18-8-12 下午4:03
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
        getActive active=new getActive();
        active.setGoodsid(1);
        active.setUserid(1);
        setnote ss=new setnote();
        ss.setnote(active);

    }
}
