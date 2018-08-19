package pojo;

/**
 * Created by jingbao on 18-6-23.
 */
public class Goods {
    private String name;
    private String price;
    private String introduce;
    private int gid;
    private String stime;
    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public int getId() {
        return gid;
    }

    public void setId(int id) {
        this.gid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    public Goods(){}
    public Goods(String name,String price,String introduce,int id){
        this.name=name;
        this.price=price;
        this.introduce=introduce;
        this.gid=id;
    }
}
