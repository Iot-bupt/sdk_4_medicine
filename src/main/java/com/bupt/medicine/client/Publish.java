package com.bupt.medicine.client;

import com.bupt.medicine.data.CustomerInfo;
import com.bupt.medicine.mqtt.DataMqttClient;
import com.google.gson.Gson;
import org.json.simple.JSONObject;

public class Publish {

    private DataMqttClient dataMqttClient;


    /*
   作为customerId的属性发送
    */
    protected void postCustomerInfo(CustomerInfo customerInfo, String token) {
        // TODO Auto-generated method stub
        try{
            Gson gson = new Gson();
            String deviceDataStr = gson.toJson(customerInfo);
            //进行发送
            dataMqttClient.publishAttribute(token,deviceDataStr);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    /*
    作为customerId的血压数值发送
     */
    protected void postBloodPressure(Integer systolicPressure, Integer expansionPressure, String token){
        try {
            JSONObject info = new JSONObject();
            //放入高压低压数据
            info.put("systolicPressure", systolicPressure);
            info.put("expansionPressure",expansionPressure);
            String data = info.toString();
            dataMqttClient.publishData(token,data);
        } catch (Exception e){
            e.printStackTrace();
        }

    }


}
