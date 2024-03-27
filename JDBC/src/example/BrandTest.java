package example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import pojo.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandTest {

 /*   @Test
    public void testSelectAll() throws Exception {

        Properties prop=new Properties();
        prop.load(new FileInputStream("D:/屈海洋202207034115/JDBC/src/druid.properties"));

        //获取连接池对象
        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接
        Connection connection=dataSource.getConnection();
        //sql语句
        String sql="select * from tb_brand;";
        //获取pstmt对象
        PreparedStatement pstmt= connection.prepareStatement(sql);
        //设置参数
        //执行sql
        ResultSet rs=pstmt.executeQuery();
        //处理结果List<Brand>封装对相
        Brand brand=null;
        List<Brand> brands=new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            brand=new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);

            brands.add(brand);

        }
        System.out.println(brands);
        rs.close();
        pstmt.close();
        connection.close();

        
    }*/




/*    @Test
    public void testAdd() throws Exception {
        //模拟信息输入
        String brandName="香飘飘";
        String companyName="香飘飘";
        int ordered=1;
        String description="绕地球一圈";
        int status=1;

        Properties prop=new Properties();
        prop.load(new FileInputStream("D:/屈海洋202207034115/JDBC/src/druid.properties"));

        //获取连接池对象
        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接
        Connection connection=dataSource.getConnection();
        //sql语句
        String sql="insert into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?);";
        //获取pstmt对象
        PreparedStatement pstmt= connection.prepareStatement(sql);
        //设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);

        int count=pstmt.executeUpdate();

        System.out.println(count>0);


        pstmt.close();
        connection.close();


    }*/



  /*  public void testUpdate() throws Exception {
        //模拟信息输入
        String brandName="香飘飘";
        String companyName="香飘飘";
        int ordered=1000;
        String description="绕地球三圈";
        int status=1;
        int id=1;

        Properties prop=new Properties();
        prop.load(new FileInputStream("D:/屈海洋202207034115/JDBC/src/druid.properties"));

        //获取连接池对象
        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接
        Connection connection=dataSource.getConnection();
        //sql语句
        String sql="update tb_brand set brand_name=?,company_name=?,ordered=?,description=?,status=? where id=?";
        //获取pstmt对象
        PreparedStatement pstmt= connection.prepareStatement(sql);
        //设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);

        int count=pstmt.executeUpdate();

        System.out.println(count>0);


        pstmt.close();
        connection.close();


    }
*/

    @Test
    public void testDelete() throws Exception {
        //模拟信息输入
        String brandName="香飘飘";
        String companyName="香飘飘";
        int ordered=1000;
        String description="绕地球三圈";
        int status=1;
        int id=1;

        Properties prop=new Properties();
        prop.load(new FileInputStream("D:/屈海洋202207034115/JDBC/src/druid.properties"));

        //获取连接池对象
        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接
        Connection connection=dataSource.getConnection();
        //sql语句
        String sql="delete from tb_brand where id=?";
        //获取pstmt对象
        PreparedStatement pstmt= connection.prepareStatement(sql);
        //设置参数

        pstmt.setInt(1,id);

        int count=pstmt.executeUpdate();

        System.out.println(count>0);


        pstmt.close();
        connection.close();


    }

}
