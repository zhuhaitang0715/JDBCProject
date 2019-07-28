package testutils;

import utils.DBUtils;

import java.sql.SQLException;

/**
 * @package:testutils
 * @Description:
 * @author: JoeSion
 * @date: 2019/7/27 15:13
 */
public class StudentManager extends DBUtils {
        public  void add() throws SQLException {
            String sql="INSERT INTO `student`(`name`,`age`,`score`,`birthday`) VALUES(?,?,?,?)";
            Object[] objects={"妲己",17,100,"2002-10-10"};
            if (addOrDelOrUpdate(sql,objects)>0) {
                System.out.println("增加成功");
                query();
            }else{
                System.out.println("增加失败");
            }
        }


        public  void query() throws SQLException {
            String sql="select * from student";
            queryByWhere(sql,null);
            System.out.println("姓名   年龄");
            while (rs.next()){
                System.out.println(rs.getObject(2)+"  "+rs.getObject(3));
            }
           closeALL();
        }
}
