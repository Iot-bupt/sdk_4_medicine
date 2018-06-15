package com.bupt.medicine.dao;

import com.bupt.medicine.data.CustomerInfo;

import java.sql.*;

/**
 * Created by zyf on 2018/6/14.
 */
public class DAO {
        private static Connection getConn() {
            Connection conn = null;
            try {
                Class.forName("org.sqlite.JDBC"); //加载对应驱动
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //url为本地创建数据库表的目录文件
            String url = "jdbc:sqlite::resource:medicine.db";

            try{
                conn = DriverManager.getConnection(url);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }
       //增加数据
        public static int insert(int customerId, String token) {
            Connection conn = getConn();
            int i = 0;
            String sql = "insert into medicine (customerId,token) values(?,?)";
            PreparedStatement pstmt;
            try {
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                pstmt.setInt(1, customerId);
                pstmt.setString(2, token);
                i = pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return i;
        }
        //更新数据
        public static int update(CustomerInfo customerInfo) {
            Connection conn = getConn();
            int i = 0;
            String sql = "update medicine set customerId='" + customerInfo.getCustomerId() + "' where token=" + customerInfo.getToken() ;
            PreparedStatement pstmt;
            try {
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                i = pstmt.executeUpdate();
                System.out.println("result: " + i);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return i;
        }
        //获取数据
        public static String getAll(int  customerId) {
            String token = null;
            Connection conn = getConn();
            String sql = "select token from medicine where customerId='" + customerId + "'";
            PreparedStatement pstmt;
            try {
                pstmt = (PreparedStatement)conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    token = rs.getString("token");
                }
                rs.close();
                return token;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
        //删除数据
        public static int delete(int customerId) {
            Connection conn = getConn();
            int i = 0;
            String sql = "delete from medicine where customerId='" + customerId + "'";
            PreparedStatement pstmt;
            try {
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                i = pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return i;
        }
}
