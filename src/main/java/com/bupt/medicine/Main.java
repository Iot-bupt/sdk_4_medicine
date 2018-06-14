package com.bupt.medicine;

import com.bupt.medicine.client.ClientImpl;
import com.bupt.medicine.data.CustomerInfo;

public class Main {
    public static void main(String args[]){
        Integer systolicPressure = 143;
        Integer expansionPressure = 120;
        CustomerInfo customerInfo = new CustomerInfo(1, "李尤");

        ClientImpl client = new ClientImpl();
        client.sendBloodPress(systolicPressure,expansionPressure,customerInfo);

    }
}
