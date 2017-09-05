/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;
import util.Constants;
import util.EnumConnectionType;

/**
 *
 * @author DusanT
 */
public class ConnectionFactory {
    private static Connection connection;
    
    public static Connection createConnection(EnumConnectionType type) throws IOException, FileNotFoundException, SQLException{
        if(connection != null)
            return connection;
        else
            connection = getConnection(type);
        
        return connection;
    }

    private static Connection getConnection(EnumConnectionType type) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("db.config"));
        
        switch(type){
            case DRIVER_MANAGER:
                return  DriverManager.getConnection(
                        properties.getProperty(Constants.DB_CONFIG_URL), 
                        properties.getProperty(Constants.DB_CONFIG_USERNAME), 
                        properties.getProperty(Constants.DB_CONFIG_PASSWORD));
            case DATASOURCE:
                MysqlDataSource mysql_data_source = new MysqlDataSource();
                mysql_data_source.setURL(properties.getProperty(Constants.DB_CONFIG_URL));
                mysql_data_source.setUser(properties.getProperty(Constants.DB_CONFIG_USERNAME));
                mysql_data_source.setPassword(properties.getProperty(Constants.DB_CONFIG_PASSWORD));
                return mysql_data_source.getConnection();
            case DRIVER:
                Driver driver = DriverManager.getDriver(properties.getProperty(Constants.DB_CONFIG_URL));
                System.out.println("Driver: " + driver.getClass().getName());
                Properties dbproperty = new Properties();
                dbproperty.put("user", properties.getProperty("username"));
                dbproperty.put("password", properties.getProperty("password"));
                return driver.connect(properties.getProperty(Constants.DB_CONFIG_URL), dbproperty);
            default : 
                return null;
        }
       
    }
}
