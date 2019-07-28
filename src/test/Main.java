package test;

import utils.DBUtils;

import java.sql.*;

/**
 * @package:test
 * @Description: 测试事务管理
 * @author: JoeSion
 * @date: 2019/7/27 16:17
 */
public class Main {
    public static void main(String[] args) throws  ClassNotFoundException {
            Class.forName("com.mysql.jdbc.Driver");
        Connection conn= null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?useUnicode=true&characterEncoding=utf8","root","root");
            //开启事务
          conn.setAutoCommit(false);
            String sql="UPDATE `bankmoney` SET `money`=`money`-500 WHERE `name`='张三'";
            String sql1="UPDATE `bankmoney` SET `money`=`money`+500 WHERE `name`='李斯'";
            ps=conn.prepareStatement(sql);
            ps1=conn.prepareStatement(sql1);
             ps.executeUpdate();
           //int num=8/0;
              ps1.executeUpdate();
           // System.out.println(num);
            //System.out.println(num1);
            //提交事务
            conn.commit();
        } catch (SQLException e) {
            try {
                //事务的回滚
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
