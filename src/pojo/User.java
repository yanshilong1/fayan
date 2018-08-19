package pojo;

/**
 * Created by jingbao on 18-7-5.
 */
public class User {
    private String uname;//用户名
    private String upsw;//用户登录密码
    private String tpsw;//用户开箱密码
    private String uid;//用户id
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpsw() {
        return upsw;
    }

    public void setUpsw(String upsw) {
        this.upsw = upsw;
    }

    public String getTpsw() {
        return tpsw;
    }

    public void setTpsw(String tpsw) {
        this.tpsw = tpsw;
    }

    public User(String uid,String tpsw,String upsw){
        this.uid=uid;
        this.upsw=upsw;
        this.tpsw=tpsw;
    }

    public User(){}


    public User(String uid,String tpsw,String upsw,String uname){
        this.uid=uid;
        this.upsw=upsw;
        this.tpsw=tpsw;
        this.uname=uname;
    }



}
