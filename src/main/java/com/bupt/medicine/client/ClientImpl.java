package com.bupt.medicine.client;

import com.bupt.medicine.data.CustomerInfo;
import com.bupt.medicine.process.GetToken;


public class ClientImpl implements Client{

    public GetToken getToken;
    public Publish publish;
    String token=null;


    public ClientImpl() {
    }


    public void sendBloodPress(Integer systolicPressure, Integer expansionPressure, CustomerInfo customerInfo){
        token = getToken.getToken(customerInfo);
        publish.postBloodPressure(systolicPressure,expansionPressure,token);
        publish.postCustomerInfo(customerInfo,token);
    }


}
