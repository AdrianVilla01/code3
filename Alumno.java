package Clases;

public class Alumno extends Personal{
    private String matricula;
    private Carrera carrera = new Carrera();
    private Tipo tipo = new Tipo();
    private int nivel;
    private String nomCompleto;

    public Alumno() {
        super();
        this.matricula = "N/A";
        this.nivel = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public int getCarreraID(){
        return carrera.getCarreraID();
    }
    
    public void setCarreraID(int ID){
        carrera.setCarreraID(ID);
    }
    
    public String getCarreraNombre(){
        return carrera.getCarreraNombre();
    }
    
    public void setCarreraNombre(String nombre){
        carrera.setCarreraNombre(nombre);
    }
    
    public int getTipoID(){
        return tipo.getTipoID();
    }
    
    public void setTipoID(int ID){
        tipo.setTipoID(ID);
    }
    
    public String getTipoNombre(){
        return tipo.getNombreTipo();
    }
    
    public void setNombreTipo(String nombre){
        tipo.setNombreTipo(nombre);
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public String getNomCompleto(){
        return  nomCompleto;
    }
    
    public void setNomCompleto(String nomCompleto){
        this.nomCompleto = nomCompleto;
    }
}

