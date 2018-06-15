package com.bupt.medicine.process;

import com.bupt.medicine.dao.dbTokenImpl;
import com.bupt.medicine.data.CustomerInfo;
import com.bupt.medicine.http.HttpControl;

public class GetToken {
    public HttpControl hc;
    public dbTokenImpl db;
    String id=null,token=null;

    public String getToken(CustomerInfo customerInfo){
        int customerId = customerInfo.getCustomerId();
        if(db.get(customerId) == null){ //数据库中customerId判断
            //SQLite里没有token
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        hc.httplogin();
                        id = hc.httpcreate(customerInfo.getCustomerName());
                        token = hc.httpfind(id);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    //存入DB
                    db.insert(customerId,token);
                }
            }).start();
            return token;
        }else{
            //SQLite里有token，从表中拿token
            String token = db.get(customerId);
            return token;
        }
    }
}
