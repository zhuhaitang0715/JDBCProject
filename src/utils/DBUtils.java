package utils;

import java.sql.*;

/**
 * @package:utils
 * @Description:
 * @author: JoeSion
 * @date: 2019/7/27 14:36
 */
public  class DBUtils {
        private  String driver="com.mysql.jdbc.Driver";
        private  String url="jdbc:mysql://localhost:3306/study";
        private  String userName="root";
        private  String userPwd="root";
        //用于接收获取连接对象的变量
       protected ResultSet rs=null;
       protected PreparedStatement ps=null;
       protected Connection conn=null;
    /**
     * 获取连接
     */
    public void getConnection(){
        try {
            //1.加载驱动
            Class.forName(driver);//加载驱动
            //2.获取连接
            conn= DriverManager.getConnection(url,userName,userPwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询方法
     * @param sql  查询的sql语句
     * @param objs 给sql语句占位符赋值的参数
     * @return 查询到的结果集
     */
    public ResultSet queryByWhere(String sql,Object[] objs){//Object[] objs 参数个数也就是sql语句中？的个数
        //查询语句之前，先获取连接对象
        getConnection();//加载驱动，获取连接
        try {
            ps=conn.prepareStatement(sql);//执行sql语句

            if (objs!=null){
                int size=objs.length;
                for (int i = 0; i <size; i++) {

                    ps.setObject(i+1,objs[i]);
                }
            }
            rs= ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 增加删除修改的方法
     * @param sql 增加或者删除或者修改的sql语句
     * @param objs 给sql语句占位符赋值的参数
     * @return 受影响的行数
     */
    public int addOrDelOrUpdate(String sql,Object[] objs){
        int num=0;
        getConnection();//加载驱动，获取连接
        try {
            ps=conn.prepareStatement(sql);
            if (objs!=null){
                int size=objs.length;
                for (int i = 0; i <size; i++) {
                    ps.setObject(i+1,objs[i]);
                }
            }
            num= ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeALL();
        }
        return  num;
    }

    /**
     * 释放资源的方法
     */
    public  void closeALL(){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
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
