/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yiver
 */
public class Conexion 
{
    Connection Con;
    String url = "jdbc:mysql://localhost:3306/bd_ventas";
    String user = "root";
    String pass = "";
    public Connection Conexion() throws SQLException
    {        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection(url,user,pass);
        } 
        catch (ClassNotFoundException ex) 
        {
            System.out.println("Error de conexion: " + ex.getMessage());
        }
        return Con;
                
    }
            
}
