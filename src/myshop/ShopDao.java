package myshop;

/**
 * @Author: yanshilong
 * @Date: 18-8-13 上午9:57
 * @Version 1.0
 */
public class ShopDao {
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    private int id;
    private double caccount;
    private String cdata;
    private int phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCaccount() {
        return caccount;
    }

    public void setCaccount(double caccount) {
        this.caccount = caccount;
    }

    public String getCdata() {
        return cdata;
    }

    public void setCdata(String cdata) {
        this.cdata = cdata;
    }

    public String getCsaledate() {
        return csaledate;
    }

    public void setCsaledate(String csaledate) {
        this.csaledate = csaledate;
    }

    public double getCsaleaccount() {
        return csaleaccount;
    }

    public void setCsaleaccount(double csaleaccount) {
        this.csaleaccount = csaleaccount;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getCdescribe() {
        return cdescribe;
    }

    public void setCdescribe(String cdescribe) {
        this.cdescribe = cdescribe;
    }

    public String getCstate() {
        return cstate;
    }

    public void setCstate(String cstate) {
        this.cstate = cstate;
    }

    private String csaledate;
    private double csaleaccount;
    private String ctype;
    private String cdescribe;
    private String cstate;
}
