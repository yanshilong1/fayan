package control;

import pojo.User;
import util.JdbcMethod.LoginJdbc;

/**
 * Created by jingbao on 18-7-15.
 */
public class Login {
    public int doLogin(User user){
        String sql=" select uid,upsw from User where " +
                "uid='"+user.getUid()+"' " +
                "and upsw='"+user.getUpsw()+"';";//？？
        Boolean flag= LoginJdbc.select(sql);
        if (!flag){
            int fleg=LoginJdbc.insert(user);
            System.out.println(fleg+"-+-+--+--+-+-+-+-");
            return fleg;
        }else{
            return 2;//用户已经存在
            //drbd
        }

    }
}
