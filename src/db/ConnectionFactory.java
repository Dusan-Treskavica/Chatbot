/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.Connection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import util.EnumConnectionType;

/**
 *
 * @author DusanT
 */
public class ConnectionFactory {
    private static Connection connection;
    
    private static Connection createConnection(EnumConnectionType type) throws IOException, FileNotFoundException, SQLException{
        if(connection != null)
            return connection;
        else
            connection = getConnection(type);
        
        return connection;
    }

    private static Connection getConnection(EnumConnectionType type) throws FileNotFoundException, IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("db.config"));
        
        switch(type){
            case DRIVER_MANAGER:
                return (Connection) DriverManager.getConnection(
                        properties.getProperty("url"), 
                        properties.getProperty("username"), 
                        properties.getProperty("password"));
            case DATASOURCE:
                break;
            case DRIVER:
                break;
            default : 
                return null;
        }
        return null;
    }
}
