package testutils;
import utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @package:testutils
 * @Description:
 * @author: JoeSion
 * @date: 2019/7/27 14:56
 */
public class Main {
    public static void main(String[] args) throws SQLException {

        DBUtils utils=new DBUtils();
        String sql="select * from student";
        ResultSet rs= utils.queryByWhere(sql,null);
        System.out.println("姓名   年龄");
        while (rs.next()){
            System.out.println(rs.getObject(2)+"  "+rs.getObject(3));
        }
        utils.closeALL();
       /* DBUtils utils=new DBUtils();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要查询大于多少的年龄的学生年龄");
        //判断用于输入的值能不能被转换为int类型
        if (input.hasNextInt()) {
            int age =input.nextInt();
            String sql="select name,age,score from student where age>=?";
            Object[] objs={age};
            ResultSet rs=   utils.queryByWhere(sql,objs);
            System.out.println("姓名  年龄  分数");
            while (rs.next()){
                System.out.println(rs.getObject(1)+"   "+rs.getObject(2)+"  "+rs.getObject(3));
            }
            utils.closeALL();
        }else{
            System.out.println("输入错误，程序退出");
            System.exit(0);
        }*/



        /*StudentManager studentManager = new StudentManager();
        studentManager.add();*/

    }
}
