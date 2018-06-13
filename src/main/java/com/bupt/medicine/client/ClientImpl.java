package com.bupt.medicine.client;

import com.bupt.medicine.data.CustomerInfo;
import com.bupt.medicine.http.HttpControl;
import com.bupt.medicine.mqtt.DataMqttClient;
import com.google.gson.Gson;
import org.json.simple.JSONObject;


public class ClientImpl implements Client{

    public Publish publish;
    public HttpControl hc;
    public CustomerInfo customerInfo;
    String id=null,token=null;


    public ClientImpl() {
    }


    public void sendBloodPress(Integer systolicPressure, Integer expansionPressure, CustomerInfo customerInfo){
        Integer customerId = customerInfo.getCustomerId();
        if(){ //数据库中customerId判断
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

                    //发送customer血压值
                    publish.postBloodPressure(systolicPressure,expansionPressure,token);
                    publish.postCustomerInfo(customerInfo,token);

                }
            }).start();

        }else{
            //SQLite里有token，从表中拿token
            String token = null;
            //发送customer血压值和info
            publish.postBloodPressure(systolicPressure,expansionPressure,token);
            publish.postCustomerInfo(customerInfo,token);

        }
    }


}
