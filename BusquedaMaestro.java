package Clases; //Paquete de proyecto

import Controlador.Conexion; //Seleccionen el paquete en el que tengan la clase de conexion
import java.sql.*;

public class BusquedaMaestro extends Conexion{
    public int cont = 0;
    
    public static int verificarNuloString(String dato){
        if(dato.equals("nulo")) {
            return 0;
        }
        return 1;
    }
    
    public static int verificarNuloInt(int dato){
        if(dato == 0) {
            return 0;
        }
        return 1;
    }
    
    public void busquedaMaestro(String sNombre, String sPaterno, String sMaterno, int nDepartamento_Id, int sClave){
        Interfaces inter = new Interfaces();
        
        ResultSet rs;
        PreparedStatement pst;
        int subCont = 0;
        int[] datos = new int[5];
        String[] strs = new String[3];
        strs[0] = sNombre;
        strs[1] = sPaterno;
        strs[2] = sMaterno;
        
        int[] args = new int[2];
        args[0] = nDepartamento_Id;
        args[1] = sClave;
        
        int rep = 0, pstCount = 1;
        
        String SQL = "SELECT * FROM maestros";
        String[] campos = new String[5];
        campos[0] = "sNombre";
        campos[1] = "sPaterno";
        campos[2] = "sMaterno";
        campos[3] = "nDepartamento_Id";
        campos[4] = "sClave";
        
        
        for(int i = 0; i < 3; i++){
            rep = rep + verificarNuloString(strs[i]);
            if(verificarNuloString(strs[i]) == 1){
                datos[subCont] = 1;
            } else {
                datos[subCont] = 0;
            }
            subCont++;
        }
        
        for(int i = 3; i < 5; i++){
            rep = rep + verificarNuloInt(args[i-3]);
            if(verificarNuloInt(args[i-3]) == 1){
                datos[subCont] = 1;
            } else {
                datos[subCont] = 0;
            }
            subCont++;
        }
       
        if(rep == 0){
            System.out.println("\nNo se ingreso ningun parametro de busqueda\n");
        } else {
            SQL = SQL + " WHERE ";
        }
        
        for(int i = 0; i < 5; i++){
            if(datos[i] == 1){
                SQL = SQL + " " + campos[i] + " LIKE ? ";
                if (rep > 1){
                    SQL = SQL + "AND";
                }
                rep--;
            }
        }
        
        try{
            pst = getConexion().prepareStatement(SQL);
            for (int i = 0; i < 5; i++){
                if(datos[i] == 1){
                    if("nDepartamento_Id".equals(campos[i])){
                        pst.setInt(pstCount, args[i-3]);
                    } else if("sClave".equals(campos[i])){
                        pst.setString(pstCount, String.valueOf(args[i-3]));
                    } else {
                        pst.setString(pstCount, strs[i]);
                    }
                    pstCount++;
                }
            }
            rs = pst.executeQuery();
            
            System.out.println("ID\tClave\tNombre\t\tPaterno\t\tMaterno\t\tFch\t\tDepartamento");
            
            while(rs.next() && cont < 5000){
                Maestro m = new Maestro();
                m.setNombre(rs.getString("sNombre"));
                m.setApellidoP(rs.getString("sPaterno"));
                m.setApellidoM(rs.getString("sMaterno"));
                m.setDepartamentoID(rs.getInt("nDepartamento_Id"));
                m.setClave(rs.getString("sClave"));
                m.setID(rs.getInt("nPersonal_Id"));
                m.setFechaNacimiento(rs.getString("dFchNacimiento"));
                System.out.println(m.getID() + "\t" + m.getClave() + "\t" + m.getNombre() + "\t\t" + m.getApellidoP() + "\t\t" + m.getApellidoP() + "\t\t" + m.getFechaNacimiento() + "\t" + inter.mostrarDepartamento(m.getDepartamentoID()));
            }
        } catch (SQLException | NumberFormatException e){
            System.err.println("Error en la clase 'BusquedaMaestros' metodo 'busquedaMaestro' " + e);
        } finally {
            
        }
    }
}