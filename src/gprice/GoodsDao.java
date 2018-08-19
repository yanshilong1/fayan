package gprice;
/**
 * Created by ysl on 18-8-3.
 */

public class GoodsDao {
    public  int id;
    public int cid;
    public  double account;
    public String data;
    public  String descride;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescride() {
        return descride;
    }

    public void setDescride(String descride) {
        this.descride = descride;
    }

    public  void GoodsDao(int id, double account){
        this.account=account;
        this.id=id;

    }


}
