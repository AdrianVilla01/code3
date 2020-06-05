package Clases;

// @author Luis Alberto Alonso Mendoza 1664442

public class Personal {
    
    private int ID;
    private String nombre;
    private String apellidoM;
    private String apellidoP;
    private String fechaNacimiento;
    private String calle;
    private String colonia;
    private String email;
    private int genero; //Uno femenino y dos masculino
    private Municipio municipio = new Municipio();

    public Personal() {
        this.ID = 0;
        this.nombre = "N/A";
        this.apellidoM = "N/A";
        this.apellidoP = "N/A";
        this.fechaNacimiento = "N/A";
        this.calle = "N/A";
        this.colonia = "N/A";
        this.email = "N/A";
        this.genero = 0;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
    
    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }
    
    public int getMunicipioID(){
        return municipio.getMunicipioID();
    }
    
    public void setMunicipioID(int ID){
        municipio.setMunicipioID(ID);
    }
    
    public String getMunicipioNombre(){
        return municipio.getNombreMunicipio();
    }
    
    public void setMunicipioNombre(String nombre){
        municipio.setNombreMunicipio(nombre);
    }
    
    public int getEstadoID(){
        return municipio.getMunicipioID();
    }
    
    public void setEstadoID(int ID){
        municipio.setEstadoID(ID);
    }
    
    public String getEstadoNombre(){
        return municipio.getEstadoNombre();
    }
    
    public void setEstadoNombre(String nombre){
        municipio.setEstadoNombre(nombre);
    }
}

