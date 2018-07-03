package com.bupt.medicine.client;

import com.bupt.medicine.data.CustomerInfo;
import com.bupt.medicine.process.GetToken;
import com.bupt.medicine.process.Publish;


public class ClientImpl implements Client{

    public GetToken getToken = new GetToken();
    public Publish publish = new Publish();
    String token=null;


    public ClientImpl() {
    }


    public void sendBloodPress(Integer systolicPressure, Integer expansionPressure, CustomerInfo customerInfo){
        token = getToken.getToken(customerInfo);
        publish.postBloodPressure(systolicPressure,expansionPressure,token);
        publish.postCustomerInfo(customerInfo,token);
    }

    public void sendBloodSugar(Double bloodSugarValue, CustomerInfo customerInfo){
        token = getToken.getToken(customerInfo);
        publish.postBloodSugar(bloodSugarValue,token);
        publish.postCustomerInfo(customerInfo,token);
    }

    public void sendHeartRate(Integer rateData, CustomerInfo customerInfo){
        token = getToken.getToken(customerInfo);
        publish.postHeartRate(rateData,token);
        publish.postCustomerInfo(customerInfo,token);
    }

    public void sendOxygenInfo(Integer oxygenPercent, CustomerInfo customerInfo){
        token = getToken.getToken(customerInfo);
        publish.postOxygenPercent(oxygenPercent,token);
        publish.postCustomerInfo(customerInfo,token);
    }

    public void sendTemperature(Double temperature, CustomerInfo customerInfo){
        token = getToken.getToken(customerInfo);
        publish.postTemperature(temperature, token);
        publish.postCustomerInfo(customerInfo,token);
    }

    public void weightinfo(Double weightValue, CustomerInfo customerInfo){
        token = getToken.getToken(customerInfo);
        publish.postWeightValue(weightValue,token);
        publish.postCustomerInfo(customerInfo,token);
    }
}
