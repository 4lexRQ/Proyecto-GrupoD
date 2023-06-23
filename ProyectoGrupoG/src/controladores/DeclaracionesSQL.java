package controladores;

import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import modelos.Pago;
import modelos.Propietario;
import modelos.Vehiculo;

public class DeclaracionesSQL {
    ConexionDB conexion = new ConexionDB();
    PreparedStatement ps;
    ResultSet rs;

    /**
     * Metodo que permite la ejecucion de procedimientos almacenados desde el codigo a la BD
     *
     * @param cs {@link CallableStatement} objeto que ejecuta el procedimiento almacenado
     * @return rs con la serie de resultados obtenidos luego de haber ejecutado el SP
     * @throws SQLException
     */
    public static ResultSet ejecutarSP(CallableStatement cs) throws SQLException {
        return cs.executeQuery();
    }
    
    public boolean existeUsuario(String cedula){
        boolean flag = false;
        try {
            CallableStatement cs = conexion.conectar().prepareCall("{CALL sp_retornaCuentaPropietario(?)}");
            cs.setString(1, cedula);
            ResultSet resp = ejecutarSP(cs);
            
            if(resp.next()){
                flag = true;
            }
            
        } catch (SQLException ex) {
            System.err.println("Ha ocurrido un error");
        } finally {
            conexion.desconectar();
        }
        return flag;
    }
    
    public String retornaClave(String cedula){
        String clave = "";
        try {
            CallableStatement cs = conexion.conectar().prepareCall("{CALL sp_retornaClave(?)}");
            cs.setString(1, cedula);
            ResultSet resp = ejecutarSP(cs);
            
            if(resp != null){
                while(resp.next()){
                    clave = resp.getString("clave");
                }
            }
            
        } catch (SQLException ex) {
            System.err.println("Ha ocurrido un error");
        } finally {
            conexion.desconectar();
        }
        return clave;
    }
    
    public Propietario retornaPropietario(String cedula){
        Propietario propietario = null;
        try {
            CallableStatement cs = conexion.conectar().prepareCall("{CALL sp_retornaPropietario(?)}");
            cs.setString(1, cedula);
            ResultSet resp = ejecutarSP(cs);
            
            if(resp != null){
                while(resp.next()){
                    propietario = new Propietario();
                    propietario.setId_propietario(resp.getInt("id_propietario"));
                    propietario.setNombre(resp.getString("nombre"));
                    propietario.setDireccion(resp.getString("direccion"));
                    propietario.setTelefono(resp.getString("telefono"));
                    propietario.setCorreo(resp.getString("correo"));
                    propietario.setLicencia(resp.getString("licencia"));
                    propietario.setCedula(resp.getString("cedula"));
                    propietario.setFecha_nac(resp.getDate("fecha_nac"));
                }
            }
            
        } catch (SQLException ex) {
            System.err.println("Ha ocurrido un error");
        } finally {
            conexion.desconectar();
        }
        
        return propietario;
    }
    
    public ArrayList<Vehiculo> listaVehiculo(int id_propietario){
        ArrayList<Vehiculo> listaVehiculo = new ArrayList<>();
        Vehiculo vehiculo = null;
        
        try {
            CallableStatement cs = conexion.conectar().prepareCall("{CALL sp_retornaVehiculo(?)}");
            cs.setInt(1, id_propietario);
            ResultSet resp = ejecutarSP(cs);
            
            if(resp != null){
                while(resp.next()){
                    vehiculo = new Vehiculo();
                    vehiculo.setId_vehiculo(resp.getInt("id_vehiculo"));
                    vehiculo.setId_propietario(resp.getInt("id_propietario"));
                    vehiculo.setMarca(resp.getString("marca"));
                    vehiculo.setModelo(resp.getString("modelo"));
                    vehiculo.setAnio(resp.getString("anio"));
                    vehiculo.setPlaca(resp.getString("placa"));
                    vehiculo.setEstado(resp.getBoolean("estado"));
                    vehiculo.setColor(resp.getString("color"));
                    listaVehiculo.add(vehiculo);
                }
            }
            
        } catch (SQLException ex) {
            System.err.println("Ha ocurrido un error");
        } finally {
            conexion.desconectar();
        }
        
        return listaVehiculo;
    }
    
    public ArrayList<Pago> listaPagos(int id_propietario){
        ArrayList<Pago> listaPago = new ArrayList<>();
        Pago pago = null;
        
        try {
            CallableStatement cs = conexion.conectar().prepareCall("{CALL sp_obtenerPagos(?)}");
            cs.setInt(1, id_propietario);
            ResultSet resp = ejecutarSP(cs);
            
            if(resp != null){
                while(resp.next()){
                    pago = new Pago();
                    pago.setId_pago(resp.getInt("id_pago"));
                    pago.setCantidad_vehiculo(resp.getInt("cantidad_vehiculo"));
                    pago.setImpuesto_unitario(resp.getInt("impuesto_unitario"));
                    pago.setImpuesto_emision_gas(resp.getInt("impuesto_emision_gas"));
                    pago.setPago_total(resp.getDouble("pago_total"));
                    pago.setFecha_registro(resp.getString("fecha_registro"));
                    pago.setEstado(resp.getBoolean("estado"));
                    listaPago.add(pago);
                }
            }
            
        } catch (SQLException ex) {
            System.err.println("Ha ocurrido un error");
        } finally {
            conexion.desconectar();
        }
        
        return listaPago;
    }
    
    public boolean eliminarVehiculo(String placa){
        boolean flag = false;
        try {
            CallableStatement cs = conexion.conectar().prepareCall("{CALL sp_eliminarVehiculo(?)}");
            cs.setString(1, placa);
            ResultSet resp = ejecutarSP(cs);
            
            if(resp != null){
                flag = true;
            }
            
        } catch (SQLException ex) {
            System.err.println("Ha ocurrido un error");
        } finally {
            conexion.desconectar();
        }
        
        return flag;
    }
    
    public boolean modificarVehiculo(String color, String placa){
        boolean flag = false;
        try {
            CallableStatement cs = conexion.conectar().prepareCall("{CALL sp_modificarVehiculo(?,?)}");
            cs.setString(1, color);
            cs.setString(2, placa);
            ResultSet resp = ejecutarSP(cs);
            
            if(resp != null){
                flag = true;
            }
            
        } catch (SQLException ex) {
            System.err.println("Ha ocurrido un error");
        } finally {
            conexion.desconectar();
        }
        
        return flag;
    }
    
    public ArrayList<Vehiculo> busquedaFiltrada(int id_propietario, String placa, String marca){
        ArrayList<Vehiculo> listaVehiculo = new ArrayList<>();
        Vehiculo vehiculo = null;
        
        try {
            CallableStatement cs = conexion.conectar().prepareCall("{CALL sp_busquedaFiltrada(?, ?, ?)}");
            cs.setInt(1, id_propietario);
            cs.setString(2, placa);
            cs.setString(3, marca);
            ResultSet resp = ejecutarSP(cs);
            
            if(resp != null){
                while(resp.next()){
                    vehiculo = new Vehiculo();
                    vehiculo.setId_vehiculo(resp.getInt("id_vehiculo"));
                    vehiculo.setId_propietario(resp.getInt("id_propietario"));
                    vehiculo.setMarca(resp.getString("marca"));
                    vehiculo.setModelo(resp.getString("modelo"));
                    vehiculo.setAnio(resp.getString("anio"));
                    vehiculo.setPlaca(resp.getString("placa"));
                    vehiculo.setEstado(resp.getBoolean("estado"));
                    vehiculo.setColor(resp.getString("color"));
                    listaVehiculo.add(vehiculo);
                }
            }
            
        } catch (SQLException ex) {
            System.err.println("Ha ocurrido un error");
        } finally {
            conexion.desconectar();
        }
        
        return listaVehiculo;
    }
    
    //Metodo que crea vehiculo 
    public boolean crearVehiculo(int idpropietario, String marca, String modelo,String anio, String placa, boolean estado, String color ) {
    boolean flag = false;
        try {
            CallableStatement cs = conexion.conectar().prepareCall("{CALL sp_crearVehiculo(?,?,?,?,?,?,?)}");
            cs.setInt(1, idpropietario);
            cs.setString(2, marca);
            cs.setString(3, modelo);
            cs.setString(4, anio);
            cs.setString(5, placa);
            cs.setBoolean(6, estado);
            cs.setString(7, color);
            
            ResultSet resp = ejecutarSP(cs);
            
            if(resp != null){
                flag = true;
            }
            
        } catch (SQLException ex) {
            System.err.println("Ha ocurrido un error en la creacion de vehiculo");
        } finally {
            conexion.desconectar();
        }
        
        return flag;
    }
    
    //Metodo que crea vehiculo 
    public boolean crearPago(int id_propietario, int cantidad_vehiculo, double impuesto_unitario, double impuesto_emision_gas, boolean estado, String fecha_registro, double pago_total) {
    boolean flag = false;
        try {
            CallableStatement cs = conexion.conectar().prepareCall("{CALL sp_registroPago(?,?,?,?,?,?,?)}");
            cs.setInt(1, id_propietario);
            cs.setInt(2, cantidad_vehiculo);
            cs.setDouble(3, impuesto_unitario);
            cs.setDouble(4, impuesto_emision_gas);
            cs.setBoolean(5, estado);
            cs.setString(6, fecha_registro);
            cs.setDouble(7, pago_total);
            
            ResultSet resp = ejecutarSP(cs);
            
            if(resp != null){
                flag = true;
            }
            
        } catch (SQLException ex) {
            System.err.println("Ha ocurrido un error en la creacion de vehiculo");
        } finally {
            conexion.desconectar();
        }
        
        return flag;
    }
    
    public boolean modificarPropietario(int id_propietario, String nombre, String direccion, String telefono, String correo){
        boolean flag = false;
        try {
            CallableStatement cs = conexion.conectar().prepareCall("{CALL sp_actualizarPropietario(?,?,?,?,?)}");
            cs.setInt(1, id_propietario);
            cs.setString(2, nombre);
            cs.setString(3, direccion);
            cs.setString(4, telefono);
            cs.setString(5, correo);
            ResultSet resp = ejecutarSP(cs);
            
            if(resp != null){
                flag = true;
            }
            
        } catch (SQLException ex) {
            System.err.println("Ha ocurrido un error");
        } finally {
            conexion.desconectar();
        }
        
        return flag;
    }
    
    
    
    
//    public boolean acceso(String cedula, String clave){
//        boolean flag = false;
//        
//        try{
//            ps = conexion.conectar().prepareStatement("SELECT * FROM cuenta_propietario WHERE cedula = " 
//                    + cedula + " AND clave = " + clave);
//            rs = ps.executeQuery();
//            if(rs.next()){
//                flag = true;
//            }
//        }catch(Exception ex){
//            System.err.println("Ha ocurrido un error al ejecutar");
//        }finally{
//            conexion.desconectar();
//        }
//        
//        return flag;
//    }
    
}
