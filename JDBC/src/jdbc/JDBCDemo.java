package jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url="jdbc:mysql://127.0.0.1:3306/itcast";
        String username="root";
        String password="123456";
        Connection conn= DriverManager.getConnection(url,username,password);


        String sql1="update student set gz=1030 where id=1";
        String sql2="update student set gz=1020 where id=2";
        Statement stmt=conn.createStatement();

        try {
            conn.setAutoCommit(false);

            int count1=stmt.executeUpdate(sql1);
            System.out.println(count1);

            int count2=stmt.executeUpdate(sql2);
            System.out.println(count2);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw new RuntimeException(e);
        }

        stmt.close();
        conn.close();



    }
}

