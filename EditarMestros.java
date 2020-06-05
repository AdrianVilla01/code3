package Clases;

// @author Luis Alberto Alonso Mendoza 1664442

import Controlador.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class EditarMestros extends Conexion{
    
    public void editarMaestro() {
        Scanner sc = new Scanner(System.in);
        Interfaces inter = new Interfaces();
        Maestro m = new Maestro();
        int id = 0;
        String[] campos = new String[14];
        campos[0] = "sNombre";
        campos[1] = "sPaterno";
        campos[2] = "sMaterno";
        campos[3] = "dFchNacimiento";
        campos[4] = "sCalle";
        campos[5] = "sColonia";
        campos[6] = "sEmail";
        campos[7] = "sClave";
        campos[8] = "nGenero";
        campos[9] = "nMunicipio_Id";
        campos[10] = "nEstado_Id";
        campos[11] = "nSindicalizado";
        campos[12] = "nDepartamento_Id";
        try {

            String searchQuery = "SELECT * FROM cursojava.maestros WHERE nPersonal_Id=";
            System.out.println("Ingrese el ID del alumno que desea modificar (El ID no puede ser negativo ni 0):");
            id = sc.nextInt();
            searchQuery = searchQuery + id;
            PreparedStatement pst = getConexion().prepareStatement(searchQuery);
            ResultSet rs = pst.executeQuery();
            rs.next();
            m.setID(rs.getInt("nPersonal_Id"));
            m.setNombre(rs.getString("sNombre"));
            m.setApellidoP(rs.getString("sPaterno"));
            m.setApellidoM(rs.getString("sMaterno"));
            m.setClave(rs.getString("sClave"));
            m.setFechaNacimiento(rs.getString("dFchNacimiento"));
            m.setGenero(rs.getByte("nGenero"));
            m.setCalle(rs.getString("sCalle"));
            m.setColonia(rs.getString("sColonia"));
            m.setEstadoID(rs.getInt("nEstado_Id"));
            m.setMunicipioID(rs.getInt("nMunicipio_Id"));
            m.setEmail(rs.getString("sEmail"));
            m.setSindicalizado(rs.getInt("nSindicalizado"));
            m.setDepartamentoID(rs.getInt("nDepartamento_Id"));
        } catch (SQLException e) {
            System.err.println("ERROR! ");
            System.err.println(e.getMessage());
        }
        String munic = inter.mostrarMunicipio(m.getEstadoID(), m.getMunicipioID());
        System.out.println("Datos actuales\n");
        System.out.println("ID: " + m.getID() + "\tClave: " + m.getClave() + "\tNombre: " + m.getNombre() + "\tApellido Paterno: " + m.getApellidoP() + "\tApellido Materno: " + m.getApellidoM() + "\tFecha de Nacimiento: " + m.getFechaNacimiento() + "\nGénero: " + m.getGenero() + "\tCalle: "
                + m.getCalle() + "\tColonia: " + m.getColonia() + "\nEstado: " + inter.mostrarEstado(m.getEstadoID()) + "\tMunicipio: " + munic + "\tEmail: " + m.getEmail()
                + "\tDepartamento: " + inter.mostrarDepartamento(m.getDepartamentoID()) + "\nSindicalizado: " + inter.mostrarSindicalizado(m.isSindicalizado()));
        Validaciones val = new Validaciones();
        boolean vali = true;
        String nombre, paterno, materno, sclave, fecha, calle, colonia, email;
        int clave, genero, estado, municipio, sindicalizado, departamento;
        System.out.println("Actualización de datos de un Maestro");
        System.out.println("\nClave: ");
        
        //CLAVE
        do{
            clave = val.readInteger();
            sclave = Integer.toString(clave);
            vali = false;
            
            if(sclave.length()>25){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali = false;
            }
        }while(vali==true);
        //CLAVE
        
        
        
        System.out.println("\nFecha de Nacimiento(AAAA-MM-DD): ");
        //FECHA DE NACIMIENTO
        do{
            vali = false;
            sc.nextLine();
            fecha=sc.nextLine();
        }while(vali == true);
        //FECHA DE NACIMIENTO
        
        
        
        System.out.println("Nombre(s): ");
        //NOMBRE(S)
        do{
            vali = false;
            nombre = sc.nextLine();
            String limpia = sc.nextLine();
            
            if(nombre.length()>50){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali=true;
            }
        }while(vali==true);
        //NOMBRE(S)
        
        
        
        System.out.println("Apellido Paterno:");
        //APELLIDO PATERNO
        do{
            vali = false;
            paterno=sc.nextLine();
            
            if(paterno.length()>50){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali=true;
            }
        }while(vali==true);
        //APELLIDO PATERNO
        
        
        System.out.println("Apellido Materno:");
        //APELLIDO MATERNO
        do{
            vali = false;
            materno=sc.nextLine();
            
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
            calle=sc.nextLine();
            
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
            colonia=sc.nextLine();
            
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
            email=sc.nextLine();
            
            if(email.length()>100){
                System.out.println("Superó el número máximo de caracteres. Ingrese nuevamente:");
                vali=true;
            } 
        }while(vali==true);
        //EMAIL
        
        
        
        System.out.println("Departamento:\n(Seleccione el numero de opcion)\n1)Física\n2)Matematicas\n3)Computación\n4)CSI");
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
        
        
        
        System.out.println("Sindicalizado:\n(Seleccione el numero de opcion)\n1)No\n2)Si");
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
        
        PreparedStatement pst;
        ResultSet rs;
        String[] strs = new String[8];
        strs[0] = nombre;
        strs[1] = paterno;
        strs[2] = materno;
        strs[3] = fecha;
        strs[4] = calle;
        strs[5] = colonia;
        strs[6] = email;
        strs[7] = sclave;
        int[] nums = new int[6];
        nums[0] = genero;
        nums[1] = municipio;
        nums[2] = estado;
        nums[3] = departamento;
        nums[4] = sindicalizado;
        String updateQuery = "UPDATE cursojava.maestros SET ";
        for (int i = 0; i < 13; i++) {
            updateQuery = updateQuery + " " + campos[i] + "=\"";
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    updateQuery = updateQuery + strs[i];
                    break;
                default:
                    updateQuery = updateQuery + nums[i - 8];
            }
            if (i != 12) {
                updateQuery = updateQuery + "\",";
            } else {
                updateQuery = updateQuery + "\"";
            }
        }
        updateQuery = updateQuery + " WHERE nPersonal_Id=" + id + "";
        try {
            
            pst = getConexion().prepareStatement(updateQuery);
            pst.execute();
            System.out.println("Maestro actualizado.");
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }
    
}

