package gpassword;
/**
 * Created by ysl on 18-7-28.
 */

public class PassDao {//获取密码方法
 public int  id;
 public int paypassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaypassword() {
        return paypassword;
    }

    public void setPaypassword(int paypassword) {
        this.paypassword = paypassword;
    }


    public PassDao(int id,int paypassword){
        this.id=id;
        this.paypassword=paypassword;
    }
    //    public  PassDao(int id,int password){
//        this.id=id;
//        this.password=password;
//    }

//    public static void main(String[] args) {
//        PassDao passDao=new PassDao(1,2);
//        System.out.println(passDao.getId());
//    }
}
