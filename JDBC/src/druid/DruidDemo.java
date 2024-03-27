package druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //导入jarbao
        //定义配置文件
        //加载配置文件
        Properties prop=new Properties();
        prop.load(new FileInputStream("D:/屈海洋202207034115/JDBC/src/druid.properties"));

        //获取连接池对象
        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);

        Connection connection=dataSource.getConnection();

        System.out.println(connection);
   /* System.out.println(System.getProperty("user.dir"));*/


    }
}
