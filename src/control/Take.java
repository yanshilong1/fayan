package control;

import mainServer.InHandler;
import org.apache.log4j.Logger;
import pojo.User;
import util.JdbcMethod.LoginJdbc;

/**
 * Created by jingbao on 18-7-5.
 */
public class Take {//管理开箱
    private static Logger log = Logger.getLogger(Take.class);
    public int doTake(User user){

        System.out.println("TAKE");
        String sql=" select uid,upsw from User where " +
                "uid='"+user.getUid()+"' " +
                "and tpsw='"+user.getTpsw()+"';";
        Boolean flag= LoginJdbc.select(sql);
        if (flag){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
//        log.debug("this is debug");

        log.info("this is info");
        try {
            int a=7721/0;

        }catch (Exception e){
            log.error("this error is:",e);
        }

        log.error("this is error");

    }
}
