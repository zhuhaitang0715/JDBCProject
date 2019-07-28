package com.jiazhong.testjdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @package:com.jiazhong.testjdbc.test
 * @Description:
 * @author: JoeSion
 * @date: 2019/7/27 9:43
 */
public class MainDel {
    public static void main(String[] args) {
        /** 步骤：
        1. 导入驱动jar包 mysql-connector-java-5.1.37-bin.jar
            1.复制mysql-connector-java-5.1.37-bin.jar到项目的libs目录下
            2.右键-->Add As Library
        2. 注册驱动
        3. 获取数据库连接对象 Connection
        4. 定义sql
        5. 获取执行sql语句的对象 Statement
        6. 执行sql，接受返回结果
        7. 处理结果
        8. 释放资源*/
        //注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功！！！！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 获取数据库连接对象 Connection
        //jdbc:mysql://localhost:3306/数据库名字
        Connection conn=null;
        Statement st=null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study","root","root");
            System.out.println("获取连接成功");
            //定义sql
            String sql="DELETE FROM  `student` WHERE  id=5";
            //获取执行sql语句的对象 Statement
            st=conn.createStatement();
            //执行sql语句,接受返回结果
            int num  = st.executeUpdate(sql);
            //处理结果
            if (num >0) {
                System.out.println("成功");
            }else{
                System.out.println("服务器繁忙，请稍后再试.....");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
