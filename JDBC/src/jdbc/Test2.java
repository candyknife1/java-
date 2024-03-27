package jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Test2 {
@Test
    public void Userlogin() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url="jdbc:mysql://127.0.0.1:3306/itcast";
        String username="root";
        String password="123456";
        Connection conn= DriverManager.getConnection(url,username,password);

         String name="张三";
         String pass="123";

          String sql="select * from student where name='"+name+"'and password='"+pass+"'";

          Statement stmt=conn.createStatement();

          ResultSet rs=stmt.executeQuery(sql);

          if(rs.next()){
              System.out.println("登陆成功");
          }else System.out.println("登陆失败");
        /*rs.close();
        stmt.close();
        conn.close();*/
    }
}
