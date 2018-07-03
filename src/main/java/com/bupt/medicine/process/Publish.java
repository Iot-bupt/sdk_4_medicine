package com.bupt.medicine.process;

import com.bupt.medicine.data.CustomerInfo;
import com.bupt.medicine.mqtt.DataMqttClient;
import com.google.gson.Gson;
import org.json.simple.JSONObject;

public class Publish {

    private DataMqttClient dataMqttClient;


    /*
   作为customerId的属性发送
    */
    public void postCustomerInfo(CustomerInfo customerInfo, String token) {
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
    public void postBloodPressure(Integer systolicPressure, Integer expansionPressure, String token){
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

    public void postBloodSugar(Double bloodSugarValue,String token){
        try {
            JSONObject info = new JSONObject();
            //放入高压低压数据
            info.put("bloodSugar", bloodSugarValue);
            String data = info.toString();
            dataMqttClient.publishData(token,data);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void postHeartRate(Integer rateData,String token){
        try {
            JSONObject info = new JSONObject();
            //放入高压低压数据
            info.put("heartRate", rateData);
            String data = info.toString();
            dataMqttClient.publishData(token,data);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void postOxygenPercent(Integer oxygenPercent,String token){
        try {
            JSONObject info = new JSONObject();
            //放入高压低压数据
            info.put("oxygenPercent", oxygenPercent);
            String data = info.toString();
            dataMqttClient.publishData(token,data);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void postTemperature(Double temperature,String token){
        try {
            JSONObject info = new JSONObject();
            //放入高压低压数据
            info.put("temperature", temperature);
            String data = info.toString();
            dataMqttClient.publishData(token,data);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void postWeightValue(Double weightValue, String token){
        try {
            JSONObject info = new JSONObject();
            //放入高压低压数据
            info.put("weight", weightValue);
            String data = info.toString();
            dataMqttClient.publishData(token,data);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
