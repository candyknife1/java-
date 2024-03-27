package jdbc;

import com.itheima.pojo.Account;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class test1 {
   /* public void testResultSet() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url="jdbc:mysql://127.0.0.1:3306/itcast";
        String username="root";
        String password="123456";
        Connection conn= DriverManager.getConnection(url,username,password);

        String sql="select * from student";

        Statement stmt=conn.createStatement();

        ResultSet rs=stmt.executeQuery(sql);

        while(rs.next()){

            int id=rs.getInt(1);
            String name=rs.getString(2);
            double gz=rs.getDouble(3);

            System.out.println(id);
            System.out.println(name);
            System.out.println(gz);

            System.out.println("-------------");
        }
            rs.close();
        stmt.close();
        conn.close();
    }
*/
    @Test
    public  void testResultSet2() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url="jdbc:mysql://127.0.0.1:3306/itcast";
        String username="root";
        String password="123456";
        Connection conn= DriverManager.getConnection(url,username,password);

        String sql="select * from student";

        Statement stmt=conn.createStatement();

        ResultSet rs=stmt.executeQuery(sql);

        List<Account> list=new ArrayList<>();

        while(rs.next()){

            Account account=new Account();

            int id=rs.getInt(1);
            String name=rs.getString(2);
            double gz=rs.getDouble(3);

            /*System.out.println(id);
            System.out.println(name);
            System.out.println(gz);*/


            account.setId(id);
            account.setName(name);
            account.setGz(gz);

            list.add(account);

        }
        System.out.println(list);

        rs.close();
        stmt.close();
        conn.close();
    }
}

