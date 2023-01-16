package modelos;

import java.util.Date;

// Esta entidad pertenece a un propietario de vehiculo, sus atributos se almacenaran en BD
public class Propietario {
    
    // Atributos basicos del propietario
    private int id_propietario;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private String licencia;
    private String cedula;
    private Date fecha_nac;
    private boolean estado;

    // Constructor
    public Propietario(int id_propietario, String nombre, String direccion, String telefono, String correo, String licencia, String cedula, Date fecha_nac, boolean estado) {
        this.id_propietario = id_propietario;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.licencia = licencia;
        this.cedula = cedula;
        this.fecha_nac = fecha_nac;
        this.estado = estado;
    }
    
    // Constructor vacio para referenciar sin llenar datos
    public Propietario(){
        
    }
    //GETTERS Y SETTERS de las variables
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public int getId_propietario(){
        return id_propietario;
    }
    
    public void setId_propietario(int id_propietario){
        this.id_propietario = id_propietario;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    
    public boolean getEstado() {
        return estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
