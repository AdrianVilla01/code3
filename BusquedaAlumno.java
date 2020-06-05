package Clases;

import Controlador.Conexion;
import java.sql.*;

public class BusquedaAlumno extends Conexion{
    
    
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
    
    public void busquedaAlumno(String sNombre, String sPaterno, String sMaterno, int nCarrera_Id, int matricula){
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
        args[0] = nCarrera_Id;
        args[1] = matricula;
        
        int rep = 0, pstCount = 1;
        
        String SQL = "SELECT * FROM alumnos";
        String[] campos = new String[5];
        campos[0] = "sNombre";
        campos[1] = "sPaterno";
        campos[2] = "sMaterno";
        campos[3] = "nCarrera_Id";
        campos[4] = "sMatricula";
        
        
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
                SQL = SQL+ " " + campos[i] + " LIKE ? ";
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
                    if("nCarrera_Id".equals(campos[i])){
                        pst.setInt(pstCount, args[i-3]);
                    } else if("sMatricula".equals(campos[i])){
                        pst.setString(pstCount, String.valueOf(args[i-3]));
                    } else {
                        pst.setString(pstCount, strs[i]);
                    }
                    pstCount++;
                }
            }
            rs = pst.executeQuery();
            
            System.out.println("ID\tMatricula\tNombre\t\tPaterno\t\tMaterno\t\tFch\t\tCarrera");
            
            while(rs.next()){
                Alumno a = new Alumno();
                a.setNombre(rs.getString("sNombre"));
                a.setApellidoP(rs.getString("sPaterno"));
                a.setApellidoM(rs.getString("sMaterno"));
                a.setCarreraID(rs.getInt("nCarrera_Id"));
                a.setMatricula(rs.getString("sMatricula"));
                a.setID(rs.getInt("nPersonal_Id"));
                a.setFechaNacimiento(rs.getString("dFchNacimiento"));
                System.out.println(a.getID() + "\t" + a.getMatricula() + "\t\t" + a.getNombre() + "\t\t" + a.getApellidoP() + "\t\t" + a.getApellidoP() + "\t\t" + a.getFechaNacimiento() + "\t" + inter.mostrarCarrera(a.getCarreraID()));
            }
        } catch (SQLException | NumberFormatException e){
            System.err.println("Error en la clase 'Busqueda Alumno' metodo 'busquedaAlumno' " + e);
        } finally {
            
        }
    }
}

