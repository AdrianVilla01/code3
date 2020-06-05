package Clases;

// @author Luis Alberto Alonso Mendoza 1664442
import Controlador.Conexion;
import java.sql.*;

public class Interfaces extends Conexion {

    public void interfazEstados() {
        try {
            PreparedStatement pst;
            ResultSet rs;
            String sql = "SELECT * FROM estados";
            pst = getConexion().prepareStatement(sql);
            rs = pst.executeQuery();
            System.out.println("ID\tEstado");

            while (rs.next()) {
                System.out.println(rs.getInt("nEstado_Id") + "\t" + rs.getString("sDescEstado"));
            }
        } catch (Exception e) {
            System.err.println("Error en la clase 'Interfaces' metodo 'interfazEstados' " + e);
        }
    }

    public void interfazMunicipios(int nEstado_Id) {
        try {
            PreparedStatement pst;
            ResultSet rs;
            String sql = "SELECT * FROM municipios WHERE nEstado_Id = ?";
            pst = getConexion().prepareStatement(sql);
            pst.setInt(1, nEstado_Id);
            rs = pst.executeQuery();
            System.out.println("ID\tMunicipio");

            while (rs.next()) {
                System.out.println(rs.getInt("nMunicipio_Id") + "\t" + rs.getString("sDescMunicipio"));
            }
        } catch (Exception e) {
            System.err.println("Error en la clase 'Interfaces' metodo 'interfazMunicipios' " + e);
        }
    }

    public void interfazCarreras() {
        try {
            PreparedStatement pst;
            ResultSet rs;
            String sql = "SELECT * FROM carreras";
            pst = getConexion().prepareStatement(sql);
            rs = pst.executeQuery();
            System.out.println("ID\tCarrera");

            while (rs.next()) {
                System.out.println(rs.getInt("nCarrera_Id") + "\t" + rs.getString("sDescCarrera"));
            }
        } catch (Exception e) {
            System.err.println("Error en la clase 'Interfaces' metodo 'interfazCarreras' " + e);
        }
    }

    public void interfazDepartamentos() {
        try {
            PreparedStatement pst;
            ResultSet rs;
            String sql = "SELECT * FROM departamentos";
            pst = getConexion().prepareStatement(sql);
            rs = pst.executeQuery();
            System.out.println("ID\tDepartamento");

            while (rs.next()) {
                System.out.println(rs.getInt("nDepartamento_Id") + "\t" + rs.getString("sDescDepartamento"));
            }
        } catch (Exception e) {
            System.err.println("Error en la clase 'Interfaces' metodo 'interfazCarreras' " + e);
        }
    }

    public String mostrarCarrera(int nCarrera_Id) {
        String sCarrera = "";
        try {
            PreparedStatement pst;
            ResultSet rs;
            String sql = "SELECT * FROM carreras WHERE nCarrera_Id = ?";
            pst = getConexion().prepareStatement(sql);
            pst.setInt(1, nCarrera_Id);
            rs = pst.executeQuery();

            while (rs.next()) {
                sCarrera = rs.getString("sDescCarrera");
            }
        } catch (Exception e) {
            System.err.println("Error en la clase 'Interfaces' metodo 'interfazCarreras' " + e);
        }

        return sCarrera;
    }

    public String mostrarMunicipio(int nEstado_Id, int nMunicipio_Id) {
        String sCarrera = "";
        try {
            PreparedStatement pst;
            ResultSet rs;
            String sql = "SELECT * FROM municipios WHERE nEstado_Id = ? AND nMunicipio_Id = ?";
            pst = getConexion().prepareStatement(sql);
            pst.setInt(1, nEstado_Id);
            pst.setInt(2, nMunicipio_Id);
            rs = pst.executeQuery();

            while (rs.next()) {
                sCarrera = rs.getString("sDescMunicipio");
            }
        } catch (Exception e) {
            System.err.println("Error en la clase 'Interfaces' metodo 'mostrarMunicipio' " + e);
        }

        return sCarrera;
    }

    public String mostrarEstado(int nEstado_Id) {
        String sCarrera = "";
        try {
            PreparedStatement pst;
            ResultSet rs;
            String sql = "SELECT * FROM estados WHERE nEstado_Id = ?";
            pst = getConexion().prepareStatement(sql);
            pst.setInt(1, nEstado_Id);
            rs = pst.executeQuery();

            while (rs.next()) {
                sCarrera = rs.getString("sDescEstado");
            }
        } catch (Exception e) {
            System.err.println("Error en la clase 'Interfaces' metodo 'mostrarEstado' " + e);
        }

        return sCarrera;
    }

    public String mostrarTipo(int nTipo_Id) {
        String sCarrera = "";
        try {
            PreparedStatement pst;
            ResultSet rs;
            String sql = "SELECT * FROM tipos WHERE nTipo_Id = ?";
            pst = getConexion().prepareStatement(sql);
            pst.setInt(1, nTipo_Id);
            rs = pst.executeQuery();

            while (rs.next()) {
                sCarrera = rs.getString("sDescTipo");
            }
        } catch (Exception e) {
            System.err.println("Error en la clase 'Interfaces' metodo 'interfazCarreras' " + e);
        }

        return sCarrera;
    }

    public String mostrarNivel(int nNivel_Id) {
        String sCarrera = "";
        try {
            PreparedStatement pst;
            ResultSet rs;
            String sql = "SELECT * FROM niveles WHERE nNivel_Id = ?";
            pst = getConexion().prepareStatement(sql);
            pst.setInt(1, nNivel_Id);
            rs = pst.executeQuery();

            while (rs.next()) {
                sCarrera = rs.getString("sDescNivel");
            }
        } catch (Exception e) {
            System.err.println("Error en la clase 'Interfaces' metodo 'interfazCarreras' " + e);
        }

        return sCarrera;
    }

    public String mostrarDepartamento(int nDepartamento_Id) {
        String sCarrera = "";
        try {
            PreparedStatement pst;
            ResultSet rs;
            String sql = "SELECT * FROM departamentos WHERE nDepartamento_Id = ?";
            pst = getConexion().prepareStatement(sql);
            pst.setInt(1, nDepartamento_Id);
            rs = pst.executeQuery();

            while (rs.next()) {
                sCarrera = rs.getString("sDescDepartamento");
            }
        } catch (Exception e) {
            System.err.println("Error en la clase 'Interfaces' metodo 'mostrarDepartamento' " + e);
        }

        return sCarrera;
    }

    public String mostrarSindicalizado(int nSindicalizado) {
        String sCarrera = "";

        if (nSindicalizado == 2) {
            sCarrera = "Si";
        } else {
            sCarrera = "No";
        }

        return sCarrera;
    }
}
