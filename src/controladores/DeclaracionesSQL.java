package controladores;

import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import modelos.Propietario;
import modelos.Vehiculo;
import modelos.cuentaPropietario;

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
    
    //Metodo que valida si existe un usuario
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
    //metodo que retorna la contraseña 
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
    //Metodo que retorna objeto propietario
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
    //ArryLista de vehiculos de propietario
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
    //metodo que ejecuta sentencia sql para eliminar vehiculo
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
    //Metodo que actualiza los campos de vehiculo 
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
    //Metodo que crea vehiculo 
    public boolean crearVehiculo( int idpropietario,String marca,String modelo,String anio, String placa,boolean estado,String color ) {
    boolean flag = false;
        try {
            CallableStatement cs = conexion.conectar().prepareCall("{CALL sp_creaVehiculo(?,?,?,?,?,?,?)}");
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
    //metodo que retorna objeto de cuenta propietario
    public cuentaPropietario retornaCPropietario(String cedula) {
        cuentaPropietario cp = null;
        
        try {
            CallableStatement cs = conexion.conectar().prepareCall("{CALL sp_retornaCuentaPropietario(?)}");
            cs.setString(1, cedula);
   
            ResultSet resp = ejecutarSP(cs);
            
            if(resp != null){
                while(resp.next()){
                    cp = new cuentaPropietario();
                    cp.setIdPropietario(resp.getInt("id_cpropietario"));
                }
            }
            
        } catch (SQLException ex) {
            System.err.println("Ha ocurrido un error en la creacion de vehiculo");
        } finally {
            conexion.desconectar();
        }
    
        return cp;
    }
    //Metodo que crea objeto cuenta de propietario
    public boolean crearCPropietario(String cedula, String clave) {
    boolean flag = false;
        try {
            CallableStatement cs = conexion.conectar().prepareCall("{CALL sp_crearCuentaPropietario(?,?,?)}");
            cs.setString(1, cedula);
            cs.setString(2, clave);
            cs.setBoolean(3, true);
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
    // Metodo que crea propietario de vehiculo
    public boolean crearPropietario( int  id_cpropietario, String nombre, String cedula, String licencia, String correo, String direccion, String fecha, String telefono, boolean estado) {
    boolean flag = false;
        try {
            CallableStatement cs = conexion.conectar().prepareCall("{CALL sp_crearPropietario(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, id_cpropietario);
            cs.setString(2, nombre);
            cs.setString(3, cedula);
            cs.setString(4, licencia);
            cs.setString(5, correo);
            cs.setString(6, direccion);
            cs.setString(7, fecha);
            cs.setString(8, telefono);
            cs.setBoolean(9, estado);
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
