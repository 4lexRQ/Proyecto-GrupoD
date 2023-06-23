package modelos;

public class Pago {

    int id_pago;
    int cantidad_vehiculo;
    int impuesto_unitario;
    int impuesto_emision_gas;
    double pago_total;
    String fecha_registro;
    Boolean estado;
    
    public Pago() {
    }
    
    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getCantidad_vehiculo() {
        return cantidad_vehiculo;
    }

    public void setCantidad_vehiculo(int cantidad_vehiculo) {
        this.cantidad_vehiculo = cantidad_vehiculo;
    }

    public int getImpuesto_unitario() {
        return impuesto_unitario;
    }

    public void setImpuesto_unitario(int impuesto_unitario) {
        this.impuesto_unitario = impuesto_unitario;
    }

    public int getImpuesto_emision_gas() {
        return impuesto_emision_gas;
    }

    public void setImpuesto_emision_gas(int impuesto_emision_gas) {
        this.impuesto_emision_gas = impuesto_emision_gas;
    }

    public double getPago_total() {
        return pago_total;
    }

    public void setPago_total(double pago_total) {
        this.pago_total = pago_total;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
}
