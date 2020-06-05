package Controlador;

import java.sql.*;


public class Consultas extends Conexion{
    
    public boolean autenticacion(String Usuario, String Contrasenia){
        PreparedStatement pst;
        ResultSet rs;
        
        try{
            String consulta = "SELECT * FROM usuarios WHERE usuario = ? AND contrasenia = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, Usuario);
            pst.setString(2, Contrasenia);
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                return true;
            }
        }catch(Exception e){
            System.err.println("ERROR " + e);
        }
        return false;
    }
}

