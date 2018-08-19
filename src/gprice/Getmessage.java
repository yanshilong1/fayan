package gprice;

import java.math.BigDecimal;

/**
 * @Author: yanshilong
 * @Date: 18-8-12 下午1:32
 * @Version 1.0
 */
public class Getmessage {
    public int getgoodsid;
    public int getuserid;
public Getmessage(int getgoodsid,int getuserid){
    this.getuserid=getuserid;
    this.getgoodsid=getgoodsid;
}

    public int getGetgoodsid() {
        return getgoodsid;
    }



    public void setGetgoodsid(int getgoodsid) {
        this.getgoodsid = getgoodsid;
    }

    public int getGetuserid() {
        return getuserid;
    }

    public void setGetuserid(int getuserid) {
        this.getuserid = getuserid;
    }

    public int getGetpaypassword() {
        return getpaypassword;
    }

    public void setGetpaypassword(int getpaypassword) {
        this.getpaypassword = getpaypassword;
    }

    public  int getpaypassword;

}
