package com.bupt.medicine.client;

import com.bupt.medicine.data.CustomerInfo;

public interface Client {
    public abstract void sendBloodPress(Integer systolicPressure, Integer expansionPressure, CustomerInfo customerInfo);

    public abstract void sendBloodSugar(Double bloodSugarValue, CustomerInfo customerInfo);

    public abstract void sendHeartRate(Integer rateData, CustomerInfo customerInfo);

    public abstract void sendOxygenInfo(Integer oxygenPercent, CustomerInfo customerInfo);

    public abstract void sendTemperature(Double temperature, CustomerInfo customerInfo);

    public abstract void weightinfo(Double weightValue, CustomerInfo customerInfo);
}
