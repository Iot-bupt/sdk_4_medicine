package com.bupt.medicine.client;

import com.bupt.medicine.data.CustomerInfo;

public interface Client {
    public abstract void sendBloodPress(Integer systolicPressure, Integer expansionPressure, CustomerInfo customerInfo);
}
