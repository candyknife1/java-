package jdbc;

import org.junit.Test;

import java.sql.*;

public class Test3_PreparedStatement {
    @Test
    public void Userlogin() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url="jdbc:mysql://127.0.0.1:3306/itcast?useSSL=false&useServerPrepStmts=true";
        String username="root";
        String password="123456";
        Connection conn= DriverManager.getConnection(url,username,password);

        String name="张三";
        String pass="'or'1'='1";

//        String sql="select * from student where name='"+name+"'and password='"+pass+"'";
//
//        Statement stmt=conn.createStatement();
//
//        ResultSet rs=stmt.executeQuery(sql);

        String sql="select * from student where name = ? and password = ?";

        PreparedStatement pstmt= conn.prepareStatement(sql);//对输入的内容(敏感字符)进行转义

        pstmt.setString(1,name);
        pstmt.setString(2,pass);

        ResultSet rs= pstmt.executeQuery();

        if(rs.next()){
            System.out.println("登陆成功");
        }else System.out.println("登陆失败");
        rs.close();
        pstmt.close();
        conn.close();
    }
}
