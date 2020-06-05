package Clases;

import Controlador.Conexion;
import java.sql.*;
import java.util.*;

public class Insertar extends Conexion {
    
    public void insertarAlumno(){
        Scanner leer = new Scanner(System.in);
        Validaciones val = new Validaciones();
        Interfaces inter = new Interfaces();
        Alumno alumno = new Alumno();
        boolean vali = false;
        String nombre, paterno, materno, matricula, fecha,calle,colonia,email;
        int matric,genero,estado,municipio,tipoNom,carrera,nivel;
        
        System.out.println("Registro de Alumno");
        System.out.println("\nMatricula: ");
        
        //MATRICULA
        do{
            vali=false;
            matric = val.readInteger();
            matricula = Integer.toString(matric);
            
            if(matricula.length()>25){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali=true;
            }
        }while(vali==true);
        //MATRICULA
        
        
        
        System.out.println("\nFecha de Nacimiento(AAAA-MM-DD): ");
        //FECHA DE NACIMIENTO
        do{
            vali=false;
            fecha=leer.nextLine();
        }while(vali==true);
        //FECHA DE NACIMIENTO
        
        
        
        System.out.println("\nNombre(s): ");
        //NOMBRE(S)
        do{
            vali=false;
            nombre=leer.nextLine();
            
            if(nombre.length()>50){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali=true; 
            }
        }while(vali==true);
        //NOMBRE(S)
        
        
        System.out.println("\nApellido Paterno:");
        //APELLIDO PATERNO
        do{
            vali=false;
            paterno=leer.nextLine();
            
            if(paterno.length()>50){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali=true;
            }
        }while(vali==true);
        //APELLIDO PATERNO
        
        
        
        System.out.println("\nApellido Materno:");
        //APELLIDO MATERNO
        do{
            vali=false;
            materno=leer.nextLine();
            
            if(materno.length()>50) {
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali=true;
            }
        }while(vali==true);
        //APELLIDO MATERNO
        
        
        System.out.println("\nGenero:\n(Seleccione el numero de opcion)\n1)Mujer\n2)Hombre\n");
        //GENERO
        do{
            vali=false;
            genero=val.readInteger();
            
            if(!(genero==1 || genero==2)) {
                System.out.println("Ingrese una opción válida. Ingrese nuevamente:");
                vali=true; 
            }
        }while(vali==true);
        //GENERO
        
        
        System.out.println("\nCalle:");
        //CALLE
        do{
            vali=false;
            calle=leer.nextLine();
            
            if(calle.length()>100){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali=true;
            }
        }while(vali==true);
        //CALLE
        
        
        
        System.out.println("\nColonia:");
        //COLONIA
        do{
            vali=false;
            colonia=leer.nextLine();
            
            if(colonia.length()>100){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali=true;
            }
        }while(vali==true);
        //COLONIA
        
        
        
        System.out.println("\nEstado:\n(Seleccione el ID del estado)");
        //ESTADO
        inter.interfazEstados();
        do{
            vali=false;
            estado=val.readInteger();
        }while(vali==true);
        //ESTADO
        
        
        
        System.out.println("\nMunicipio:\n(Seleccione el ID del estado");
        //MUNICIPIO
        inter.interfazMunicipios(estado);
        do{
            municipio=val.readInteger();
            vali=false;
        }while(vali==true);
        //MUNICIPIO
        
        
        
        System.out.println("\nEmail:");
        //EMAIL
        do{
            vali=false;
            email=leer.nextLine();
            
            if(email.length()>100){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali=true;
            }
        }while(vali==true);
        //EMAIL
        
        
        
        System.out.println("\nCarrera:\n(Seleccione el ID de la carrera");
        //CARRERA
        inter.interfazCarreras();
        do{
            carrera=val.readInteger();
            vali=false;
        }while(vali==true);
        //CARRERA
        
        
        
        System.out.println("\nTipo de inscripcion:\n(Seleccione el numero de opcion)\n1)Nuevo Ingreso\n2)Reingreso\n3)Regularizacion");
        //TIPO
        do{
            vali=false;
            tipoNom=val.readInteger();
            
            if(!(tipoNom==1 || tipoNom==2 || tipoNom ==3)) {
                System.out.println("Ingrese una opción válida. Ingrese nuevamente:");
                vali=true;   
            }
        }while(vali==true);
        //TIPO
        
        
        
        System.out.println("\nNivel:\n(Seleccione el numero de opcion)\n1)Licenciatura\n2)Maestria\n3)Doctorado");
        //NIVEL
        do{
            vali=false;
            nivel=val.readInteger();
            
            if(!(nivel==1 || nivel==2 || nivel ==3)) {
                System.out.println("Ingrese una opción válida. Ingrese nuevamente:");
                vali=true;   
            }
        }while(vali==true);
        //NIVEL
        
        
        
        //INSERCION
        PreparedStatement pst;
        ResultSet rs;
        
        try{
            String consulta = "INSERT INTO cursojava.alumnos (sNombre, sPaterno, sMaterno, nGenero, dFchNacimiento, nMunicipio_Id, nEstado_Id, sCalle, sColonia, sEmail, sMatricula, nCarrera_Id, nTipo_Id, nNivel_Id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, nombre);
            pst.setString(2,paterno);
            pst.setString(3,materno);
            pst.setInt(4,genero);
            pst.setString(5,fecha);
            pst.setInt(6,municipio);
            pst.setInt(7,estado);
            pst.setString(8,calle);
            pst.setString(9,colonia);
            pst.setString(10,email);
            pst.setString(11,matricula);
            pst.setInt(12, carrera);
            pst.setInt(13, tipoNom);
            pst.setInt(14, nivel);
            pst.executeUpdate();
            System.out.println("Alumno registrado exitosamente\n");
        }catch(Exception e){
            System.err.println("ERROR " + e);
        } finally{
            
        }
        //INSERCION
    }
    
    public void insertarMaestro(){
        Scanner leer = new Scanner(System.in);
        Interfaces inter = new Interfaces();
        Validaciones val = new Validaciones();
        boolean vali = false;
        String nombre, paterno, materno, sclave, fecha, calle, colonia, email;
        int clave, genero, estado, municipio, sindicalizado, departamento;
        
        System.out.println("Registro de Maestro");
        System.out.println("\nClave: ");
        
        //CLAVE
        do{
            clave = val.readInteger();
            sclave = Integer.toString(clave);
            
            if(sclave.length()>25){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali = true;
            }
        }while(vali==true);
        //CLAVE
        
        
        
        System.out.println("\nFecha de Nacimiento(AAAA-MM-DD): ");
        //FECHA DE NACIMIENTO
        do{
            vali = false;
            fecha=leer.nextLine();
        }while(vali == true);
        //FECHA DE NACIMIENTO
        
        
        
        System.out.println("\nNombre(s): ");
        //NOMBRE(S)
        do{
            vali = false;
            nombre = leer.nextLine();
            
            if(nombre.length()>50){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali=true;
            }
        }while(vali==true);
        //NOMBRE(S)
        
        
        
        System.out.println("\nApellido Paterno:");
        //APELLIDO PATERNO
        do{
            vali = false;
            paterno=leer.nextLine();
            
            if(paterno.length()>50){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali=true;
            }
        }while(vali==true);
        //APELLIDO PATERNO
        
        
        System.out.println("\nApellido Materno:");
        //APELLIDO MATERNO
        do{
            vali = false;
            materno=leer.nextLine();
            
            if(materno.length()>50){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali=true;
            }
        }while(vali==true);
        //APELLIDO MATERNO
        
        
        
         System.out.println("\nGenero:\n(Seleccione el numero de opcion)\n1)Mujer\n2)Hombre\n");
        //GENERO
        do{
            vali=false;
            genero=val.readInteger();
            
            if(!(genero==1 || genero==2)) {
                System.out.println("Ingrese una opción válida. Ingrese nuevamente:");
                vali=true; 
            }
        }while(vali==true);
        //GENERO
        
        
        
        System.out.println("\nCalle:");
        //CALLE
        do{
            vali = false;
            calle=leer.nextLine();
            
            if(calle.length()>100){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali=true;
            }   
        }while(vali==true);
        //CALLE
        
        
        
        System.out.println("\nColonia:");
        //COLONIA
        do{
            vali = false;
            colonia=leer.nextLine();
            
            if(colonia.length()>100){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali=true;
            }   
        }while(vali==true);
        //COLONIA
        
        
        
        System.out.println("\nEstado:\n(Seleccione el ID del estado)");
        //ESTADO
        inter.interfazEstados();
        do{
            vali=false;
            estado=val.readInteger();
        }while(vali==true);
        //ESTADO
        
        
        
        System.out.println("\nMunicipio:\n(Seleccione el ID del estado");
        //MUNICIPIO
        inter.interfazMunicipios(estado);
        do{
            municipio=val.readInteger();
            vali=false;
        }while(vali==true);
        //MUNICIPIO
        
        
        
        System.out.println("\nEmail:");
        //EMAIL
        do{
            vali = false;
            email=leer.nextLine();
            
            if(email.length()>100){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali=true;
            } 
        }while(vali==true);
        //EMAIL
        
        
        
        System.out.println("\nDepartamento:\n(Seleccione el numero de opcion)\n1)Física\n2)Matematicas\n3)Computación\n4)CSI");
        //DEPARTAMENTO
        do{
            vali = false;
            departamento=val.readInteger();
            if(departamento<1 || departamento>4){
                System.out.println("Ingrese una opción válida. Ingrese nuevamente:");
                vali=true;
            }
        }while(vali==true);
        //DEPARTAMENTO
        
        
        
        System.out.println("\nSindicalizado:\n(Seleccione el numero de opcion)\n1)No\n2)Si");
        //SINDICALIZADO
        do{
            vali = false;
            sindicalizado=val.readInteger();
            if(!(sindicalizado==1 || sindicalizado==2)){
                System.out.println("Ingrese una opción válida. Ingrese nuevamente:");
                vali=true;
            }   
        }while(vali==true);
        //SINDICALIZADO
        
        
        //INSERCION
        PreparedStatement pst;
        ResultSet rs;
        
        try{
            String consulta = "INSERT INTO cursojava.maestros (sNombre, sPaterno, sMaterno, nGenero, dFchNacimiento, nMunicipio_Id, nEstado_Id, sCalle, sColonia, sEmail, sClave, nSindicalizado, nDepartamento_Id) VALUES (?, ?, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, nombre);
            pst.setString(2,paterno);
            pst.setString(3,materno);
            pst.setInt(4,genero);
            pst.setString(5,fecha);
            pst.setInt(6,municipio);
            pst.setInt(7,estado);
            pst.setString(8,calle);
            pst.setString(9,colonia);
            pst.setString(10,email);
            pst.setString(11,sclave);
            pst.setInt(12,sindicalizado);
            pst.setInt(13,departamento);
            pst.executeUpdate();
            System.out.println("Maestro registrado");
        }catch(Exception e){
            System.err.println("ERROR " + e);
        } finally{
            
        }
        //INSERCION
    }
}

