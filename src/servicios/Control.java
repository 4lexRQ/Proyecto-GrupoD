package servicios;

import controladores.DeclaracionesSQL;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelos.Propietario;
import modelos.Vehiculo;
import modelos.cuentaPropietario;

//Esta la clase que valida y controla las los procesos y configuracion de las sentecias SQL de la clase DeclaracionSQL
public class Control {
    
    DeclaracionesSQL dsql = new DeclaracionesSQL();
    //Metodo para el login en el sistema
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
    //Metodo que trae el objeto propietario por medio del parametro cedula
    public Propietario obtenerPropietario(String cedula){
        Propietario propietario = new Propietario();
        try{
            propietario = dsql.retornaPropietario(cedula);
        } catch(Exception ex) {
            System.err.println("Ha ocurrido un error");
        }
        return propietario;
    }
    
    //Lista de pose los vehiculos del prpopietario
    public ArrayList<Vehiculo> listaVehiculos(int id_propietario) {
        return dsql.listaVehiculo(id_propietario);
    }
    
    //Metodo que elimina los vehiculo del propietario
    public boolean eliminarVehiculo(String placa){
        boolean flag = false;
        
        if(dsql.eliminarVehiculo(placa)){
            flag = true;
        }
        
        return flag;
    }
    //Metodo que modifica lo datos del vehiculo del propietario
    public boolean modificarVehiculo(String color, String placa) {
        boolean flag = false;
        
        if(dsql.modificarVehiculo(color, placa)){
            flag = true;
        }
        
        return flag;
    }
    //Metodo que crea los vehiculo de un propietario
    public boolean crearVehiculo(int idpropietario, String marca, String modelo,String anio, String placa, boolean estado,String color ) {
    boolean flag = false;
        
        if(dsql.crearVehiculo(idpropietario, marca, modelo, anio, placa, estado, color)){
            flag = true;
        }
        
        return flag;
    }
    //metodo que retorna objeto de cuenta propietario
    public cuentaPropietario retornaCPropietario(String cedula) {
        cuentaPropietario cpro = new cuentaPropietario();
        cpro = dsql.retornaCPropietario(cedula);
        return cpro;
    }
    //Metodo que crea objeto cuenta de propietario
    public boolean crearCPropietario(String cedula,String clave) {
    boolean flag = false;
        
        if(dsql.crearCPropietario(cedula, clave)){
            flag = true;
        }
        
        return flag;
    }
    
    // Metodo que crea propietario de vehiculo
    public boolean crearPropietario(int id_cpropietario, String nombre, String cedula, String licencia, String correo, String direccion, String fecha, String telefono, boolean estado) {
    boolean flag = false;
        
    if(id_cpropietario !=  0 && !nombre.isEmpty() && !cedula.isEmpty() && !licencia.isEmpty() 
            && !correo.isEmpty() && !direccion.isEmpty() && !fecha.isEmpty() && !telefono.isEmpty() && estado == true){
        if(dsql.crearPropietario(id_cpropietario, nombre, cedula, licencia, correo, direccion, fecha, telefono, estado)){
            flag = true;
        }
    }
        
        return flag;
    }
    
    
}
