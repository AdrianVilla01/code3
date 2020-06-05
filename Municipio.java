package Clases;

// @author Luis Alberto Alonso Mendoza 1664442

public class Municipio {
    
    private int municipioID;
    private String nombreMunicipio;
    private Estado estado = new Estado();

    public int getMunicipioID() {
        return municipioID;
    }

    public void setMunicipioID(int municipioID) {
        this.municipioID = municipioID;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }
    
    public int getEstadoID(){
        return estado.getEstadoID();
    }
    
    public void setEstadoID(int ID){
        estado.setEstadoID(ID);                
    }
    
    public String getEstadoNombre(){
        return estado.getEstadoNombre();
    }
    
    public void setEstadoNombre(String nombre){
        estado.setEstadoNombre(nombre);
    }
}

