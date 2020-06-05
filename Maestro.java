package Clases;

// @author Luis Alberto Alonso Mendoza 1664442

public class Maestro extends Personal{
    
    private String clave;
    private int sindicalizado;
    private Tipo tipo = new Tipo();
    private Departamento departamento = new Departamento();

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int isSindicalizado() {
        return sindicalizado;
    }

    public void setSindicalizado(int sindicalizado) {
        this.sindicalizado = sindicalizado;
    }
    
    public int getDepartamentoID(){
        return departamento.getDepartamentoID();
    }
    
    public void setDepartamentoID(int ID){
        departamento.setDepartamentoID(ID);
    }
    
    public String getDepartamentoNombre(){
        return departamento.getNombreDepartamento();
    }
    
    public void setDepartamentoNombre(String nombre){
        departamento.setNombreDepartamento(nombre);
    }
}

