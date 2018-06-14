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
            String url = "jdbc:sqlite::resources:medcine.db";

            try{
                conn = DriverManager.getConnection(url);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }
       //增加数据
        public static int insert(CustomerInfo customerInfo) {
            Connection conn = getConn();
            int i = 0;
            String sql = "insert into medcine (customerId,token) values(?,?)";
            PreparedStatement pstmt;
            try {
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                pstmt.setInt(1, customerInfo.getCustomerId());
                pstmt.setString(2, customerInfo.getToken());
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
            String sql = "update medcine set customerId='" + customerInfo.getCustomerId() + "' where token='" + customerInfo.getToken() ;
            PreparedStatement pstmt;
            try {
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                i = pstmt.executeUpdate();
                System.out.println("resutl: " + i);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return i;
        }
        //获取数据
        public static Integer getAll() {
            Connection conn = getConn();
            String sql = "select * from medcine";
            PreparedStatement pstmt;
            try {
                pstmt = (PreparedStatement)conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                int col = rs.getMetaData().getColumnCount();
                while (rs.next()) {
                    for (int i = 1; i <= col; i++) {
                        System.out.print(rs.getString(i) + "\t");
                        if ((i == 2) && (rs.getString(i).length() < 8)) {
                            System.out.print("\t");
                        }
                    }
                    System.out.println("");
                }
                System.out.println("============================");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
        //删除数据
        public static int delete(int customerId) {
            Connection conn = getConn();
            int i = 0;
            String sql = "delete from medcine where customerId='" + customerId + "'";
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
