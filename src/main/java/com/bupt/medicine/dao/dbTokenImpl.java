package com.bupt.medicine.dao;


import com.bupt.medicine.data.CustomerInfo;

/**
 * Created by zyf on 2018/6/13.
 */
public class dbTokenImpl implements dbToken {



    //添加数据
    public void insert(int customerId,String token){
        DAO.insert(customerId, token);
    }

    //删除数据
    public boolean delete(int customerId){
        DAO.delete(customerId);
        return true;
    }

    //更新数据
    public boolean update(int customerId,String token) {
        DAO.update(new CustomerInfo(customerId, token));
        return true;
    }

    //查询数据
    public String get(int customerId) {
        String rs = DAO.getAll(customerId);
        return rs;
    }

}
