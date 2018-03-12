/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ConnectionFactory {
    
    public static java.sql.Connection getConnection() {  
        Connection connection = null;  
  
        try {  
          
            Class.forName("com.mysql.jdbc.Driver");  
  
            String url = "jdbc:mysql://localhost:3306/pwe";
            String username = "root";   
            String password = "";
              
            connection = DriverManager.getConnection(url, username, password);  
  
            return connection;  
              
        } catch (ClassNotFoundException e) {              
            System.out.println("O driver expecificado nao foi encontrado. " + e.toString());  
            return null;  
              
        } catch (SQLException e) {  
            System.out.println("Nao foi possivel conectar ao banco de dados.");  
            return null;  
        }  
    }  
}