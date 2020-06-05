package Clases;

// @author Luis Alberto Alonso Mendoza 1664442
import Controlador.Conexion;
import java.sql.PreparedStatement;

public class Eliminar extends Conexion {

    public void eliminarMaestro() {
        Personal al = new Personal();
        Validaciones val = new Validaciones();
        int id;

        try {

            String query = "DELETE FROM cursojava.maestros WHERE nPersonal_Id = ?";
            PreparedStatement pst = getConexion().prepareStatement(query);

            do {
                System.out.println("Introduzca el ID del maestro que desea eliminar (El ID no puede ser negativo ni 0):");
                id = val.readInteger();
                al.setID(id);
            } while (id < 1 || id > 99999999);

            pst.setInt(1, al.getID());
            pst.execute();
            System.out.println("Maestro borrado exitosamente\n\n");
        } catch (Exception e) {
            System.err.println("ERROR! ");
            System.err.println(e.getMessage());
        }
    }

    public void eliminarAlumno() {
        Personal al = new Personal();
        Validaciones val = new Validaciones();
        int id;

        try {
            String query = "delete from cursojava.alumnos where nPersonal_Id = ?";
            PreparedStatement pst = getConexion().prepareStatement(query);
            
            do {
                System.out.println("Introduzca el ID del alumno que desea eliminar (El ID no puede ser negativo ni 0):");
                id = val.readInteger();
                al.setID(id);
            } while (id < 1 || id > 99999999);
            
            pst.setInt(1, al.getID());
            pst.execute();
            System.out.println("Alumno borrado exitosamente\n\n");
        } catch (Exception e) {
            System.err.println("ERROR! ");
            System.err.println(e.getMessage());
        }
    }
}
