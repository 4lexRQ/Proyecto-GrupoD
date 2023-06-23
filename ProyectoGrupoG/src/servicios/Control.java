package servicios;

import controladores.DeclaracionesSQL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Pago;
import modelos.Propietario;
import modelos.Vehiculo;

public class Control {
    
    DeclaracionesSQL dsql = new DeclaracionesSQL();
    
    public boolean controlAccesoUsuario(String cedula, String clave){
        boolean flag = false;
        if(!cedula.isEmpty() && !clave.isEmpty()){
            if(dsql.existeUsuario(cedula)){
                if(Cifrado.getSHA256(clave).equalsIgnoreCase(dsql.retornaClave(cedula))){
                    flag = true;
                } else {
                    JOptionPane.showMessageDialog(null, "La clave es incorrecta, vuelva a intentar.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El usuario ingresado no existe, vuelva a intentar.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llena todos los campos necesarios!");
        }
        return flag;
    }
    
    public Propietario obtenerPropietario(String cedula){
        Propietario propietario = new Propietario();
        try{
            propietario = dsql.retornaPropietario(cedula);
        } catch(Exception ex) {
            System.err.println("Ha ocurrido un error");
        }
        return propietario;
    }
    
    public ArrayList<Vehiculo> listaVehiculos(int id_propietario) {
        return dsql.listaVehiculo(id_propietario);
    }
    
    public ArrayList<Pago> listaPagos(int id_propietario){
        return dsql.listaPagos(id_propietario);
    }
    
    public boolean eliminarVehiculo(String placa){
        boolean flag = false;
        
        if(dsql.eliminarVehiculo(placa)){
            flag = true;
        }
        
        return flag;
    }
    
    public boolean modificarVehiculo(String color, String placa) {
        boolean flag = false;
        
        if(dsql.modificarVehiculo(color, placa)){
            flag = true;
        }
        
        return flag;
    }
    
    public ArrayList<Vehiculo> busquedaFiltrada(int id_propietario, String placa, String marca){
        return dsql.busquedaFiltrada(id_propietario, placa, marca);
    }
    
    //Metodo que crea los vehiculo de un propietario
    public boolean crearVehiculo(int idpropietario, String marca, String modelo, String anio, String placa, boolean estado, String color ) {
        boolean flag = false;
        
        if(dsql.crearVehiculo(idpropietario, marca, modelo, anio, placa, estado, color)){
            flag = true;
        }
        
        return flag;
    }
    
    public boolean registroPago(int id_propietario, int cantidad_vehiculo, double impuesto_unitario, double impuesto_emision_gas, double pago_total) {
        boolean flag = false;
        
        if(dsql.crearPago(id_propietario, cantidad_vehiculo, impuesto_unitario, impuesto_emision_gas, true, retornaFecha(), pago_total)){
            flag = true;
        }
        
        return flag;
    }
    
    public String retornaFecha(){
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Definir el formato deseado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Convertir la fecha a una cadena en el formato deseado
        String fechaFormateada = fechaActual.format(formato);

        return fechaFormateada;
    }
    
    public boolean actualizarPropietario(int id_propietario, String nombre, String direccion, String telefono, String correo) {
        boolean flag = false;
        
        if(dsql.modificarPropietario(id_propietario, nombre, direccion, telefono, correo)){
            flag = true;
        }
        
        return flag;
    }
}
