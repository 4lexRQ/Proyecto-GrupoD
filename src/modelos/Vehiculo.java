package modelos;

public class Vehiculo {
    //Declaracion de variables
    private int id_vehiculo;
    private int id_propietario;
    private String marca;
    private String modelo;
    private String anio;
    private String placa;
    private String color;
    private boolean estado;
    // Este atributo se omite ya que en la logica del negocio se enviara este dato automaticamente a la BD
    // private Date fecha_reg;
    
    //GETTERS Y SETTERS de las variables

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }
    
    public int getId_propietario() {
        return id_propietario;
    }
    
    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
