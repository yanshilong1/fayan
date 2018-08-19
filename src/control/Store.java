package control;

import pojo.Goods;
import util.JdbcMethod.StoreJdbc;

/**
 * Created by jingbao on 18-6-23.
 */
public class Store {
    public int doStore(Goods goods){
        int flag=0;
        flag= StoreJdbc.insertGoods(goods);
        return flag;
    }

}