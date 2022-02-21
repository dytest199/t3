package com.example.demo;

import java.sql.*;

/**
 * @Author: dy
 * @Date: 2021/11/18 14:23
 * @used:
 */
public class jdbc_test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 查询
        se("select * from cb_account where sex=2");
        // 新增
        // ins("INSERT INTO cb_account(username,password,mobile,gqid,token,identity) " +
         //       "VALUES('ly','133','15558795474','11','xxxs','jsjsjsjs')");
    }

   // 加载驱动, 连接数据库
   private static Statement getStatement() throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.cj.jdbc.Driver");
       // 获取数据库连接
       String u="jdbc:mysql://192.168.71.131:3306/kyj";
       String us="root";
       String pwd="123456";
       Connection con = DriverManager.getConnection(u,us,pwd);
       //  System.out.println(con);
       return con.createStatement();
   }
    //查询数据库
    private static void se(String sql) throws ClassNotFoundException, SQLException {
        Statement st = getStatement();
        // 执行sql语句
        ResultSet r = st.executeQuery(sql);
        while (r.next()){
            System.out.println(r.getInt("id")+"   "+r.getString("username"));
        }
        r.close();
        st.close();
    }

    //新增数据库
    private static void ins(String sql) throws ClassNotFoundException, SQLException {
        // 获得语句执行平台
        Statement st = getStatement();
        // 执行sql语句
        int r = st.executeUpdate(sql);
        System.out.println(r);
        st.close();
    }
    

}
