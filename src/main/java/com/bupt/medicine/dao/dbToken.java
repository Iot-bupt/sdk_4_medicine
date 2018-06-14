package com.bupt.medicine.dao;

/**
 * Created by zyf on 2018/6/13.
 */
public interface dbToken {

    public void insert(int customerId,String token);
    public boolean delete(int customerId);
    public boolean update(int customerId,String token);
    public void get(int customerId);
}
