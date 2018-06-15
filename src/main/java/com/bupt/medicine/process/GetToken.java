package com.bupt.medicine.process;

import com.bupt.medicine.dao.dbTokenImpl;
import com.bupt.medicine.data.CustomerInfo;
import com.bupt.medicine.http.HttpControl;

public class GetToken {
    public HttpControl hc = new HttpControl();
    public dbTokenImpl db = new dbTokenImpl();


    public String getToken(CustomerInfo customerInfo){
        String token = null;
        int customerId = customerInfo.getCustomerId();
        if(db.get(customerId) == null){ //数据库中customerId判断
            //SQLite里没有token
            try{
                hc.httplogin();
                String id = hc.httpcreate(customerInfo.getCustomerName());
                token = hc.httpfind(id);
            }catch (Exception e){
                e.printStackTrace();
            }//存入DB
            db.insert(customerId,token);
            return token;
        }else{
            //SQLite里有token，从表中拿token
            token = db.get(customerId);
            return token;
        }
    }
}
