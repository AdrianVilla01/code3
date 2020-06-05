package Clases;

// @author Luis Alberto Alonso Mendoza 1664442
import Controlador.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EditarAlumnos extends Conexion {

    public void editarAlumno() {
        Scanner sc = new Scanner(System.in);
        Interfaces inter = new Interfaces();
        Alumno a = new Alumno();
        int id = 0;
        String[] campos = new String[14];
        campos[0] = "sNombre";
        campos[1] = "sPaterno";
        campos[2] = "sMaterno";
        campos[3] = "dFchNacimiento";
        campos[4] = "sCalle";
        campos[5] = "sColonia";
        campos[6] = "sEmail";
        campos[7] = "sMatricula";
        campos[8] = "nGenero";
        campos[9] = "nMunicipio_Id";
        campos[10] = "nEstado_Id";
        campos[11] = "nCarrera_Id";
        campos[12] = "nTipo_Id";
        campos[13] = "nNivel_Id";
        try {

            String searchQuery = "SELECT * FROM cursojava.alumnos WHERE nPersonal_Id=";
            System.out.println("Ingrese el ID del alumno que desea modificar (El ID no puede ser negativo ni 0):");
            id = sc.nextInt();
            searchQuery = searchQuery + id;
            PreparedStatement pst = getConexion().prepareStatement(searchQuery);
            ResultSet rs = pst.executeQuery();
            rs.next();
            a.setID(rs.getInt("nPersonal_Id"));
            a.setNombre(rs.getString("sNombre"));
            a.setApellidoP(rs.getString("sPaterno"));
            a.setApellidoM(rs.getString("sMaterno"));
            a.setCarreraID(rs.getInt("nCarrera_Id"));
            a.setMatricula(rs.getString("sMatricula"));
            a.setFechaNacimiento(rs.getString("dFchNacimiento"));
            a.setGenero(rs.getByte("nGenero"));
            a.setCalle(rs.getString("sCalle"));
            a.setColonia(rs.getString("sColonia"));
            a.setEstadoID(rs.getInt("nEstado_Id"));
            a.setMunicipioID(rs.getInt("nMunicipio_Id"));
            a.setEmail(rs.getString("sEmail"));
            a.setTipoID(rs.getInt("nTipo_Id"));
            a.setNivel(rs.getInt("nNivel_Id"));
        } catch (SQLException e) {
            System.err.println("ERROR! ");
            System.err.println(e.getMessage());
        }
        System.out.println("Datos actuales\n");
        System.out.println("ID: " + a.getID() + "\tMatrícula: " + a.getMatricula() + "\tNombre: " + a.getNombre() + "\tApellido Paterno: " + a.getApellidoP()
                + "\tApellido Materno: " + a.getApellidoM() + "\tFecha de Nacimiento: " + a.getFechaNacimiento() + "\nGénero: " + a.getGenero() + "\tCalle: "
                + a.getCalle() + "\tColonia: " + a.getColonia() + "\nEstado: " + inter.mostrarEstado(a.getEstadoID()) + "\tMunicipio: " + inter.mostrarMunicipio(a.getEstadoID(), a.getMunicipioID()) + "\tEmail: " + a.getEmail()
                + "\tCarrera: " + inter.mostrarCarrera(a.getCarreraID()) + "\tTipo: " + inter.mostrarTipo(a.getTipoID()) + "\tNivel: " + inter.mostrarNivel(a.getNivel()) + "\n");
        Validaciones val = new Validaciones();
        boolean vali;
        String nombre, paterno, materno, matricula, fecha, calle, colonia, email;
        int matric, genero, estado, municipio, tipoNom, carrera, nivel;
        System.out.println("Actualización de datos de un Alumno");
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
            sc.nextLine();
            fecha=sc.nextLine();
        }while(vali==true);
        //FECHA DE NACIMIENTO
        
        
        
        System.out.println("\nNombre(s): ");
        //NOMBRE(S)
        do{
            vali=false;
            nombre=sc.nextLine();
            
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
            paterno=sc.nextLine();
            
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
            materno=sc.nextLine();
            
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
            vali=false;
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
            vali=false;
            email=sc.nextLine();
            
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
        strs[7] = matricula;
        int[] nums = new int[6];
        nums[0] = genero;
        nums[1] = municipio;
        nums[2] = estado;
        nums[3] = carrera;
        nums[4] = tipoNom;
        nums[5] = nivel;
        String updateQuery = "UPDATE cursojava.alumnos SET ";
        for (int i = 0; i < 14; i++) {
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
            if (i != 13) {
                updateQuery = updateQuery + "\",";
            } else {
                updateQuery = updateQuery + "\"";
            }
        }
        updateQuery = updateQuery + " WHERE nPersonal_Id=" + id + "";
        try {
            
            pst = getConexion().prepareStatement(updateQuery);
            pst.execute();
            System.out.println("Alumno actualizado.");
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }

}
