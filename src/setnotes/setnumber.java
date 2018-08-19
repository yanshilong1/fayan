package setnotes;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by ysl on 18-8-9.
 */
public class setnumber {
    Logger logger=Logger.getLogger(setnote.class);
    public String  set(int  userid ){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");

        String str="1"+String.format("%06d",userid);
        String str1=simpleDateFormat.format(new Date()).substring(9,14);
       String sss=str1+str;
       // System.out.println(sss);


       return sss;
    }

    public String setuserid(int id){
        String   str=String.format("%06d",id) ;
        String str1="1"+str;
        return str1;
    }




    public static  void main(String[] args) {
       String ss=new setnumber().set(1);
       System.out.println(ss);

//        String ee=new setnumber().setuserid(1);
//        System.out.println(ee);
    }
}
