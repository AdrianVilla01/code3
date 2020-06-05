package Controlador;

import java.sql.*;


public class Conexion {
    
    private String USERNAME = "root";
    private String PASSWORD = "sesv_09199614"; //Poner la contraseña de MySQL que puesieron cuando instalaron el programa
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "cursojava";
    private String CLASSNAME ="com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
    private static Connection con;
    
    public Conexion() {
        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
        } catch(ClassNotFoundException | SQLException e){
            System.err.println("ERROR " + e);
        }
    }
    
    public static Connection getConexion(){
        return con;
    }
}