package controladores;

/**
 * En el paquete DAO (Data Access Object) se encuentran las entidades de conexion a base de datos.
 * Esta clase en particular permite la conexion y desconexion a la BD haciendo uso del driver oficial de MySQL para Java.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class ConexionDB {
    // Cada atributo representa un elemento necesario para lograr la conexion
    String db = "proyectoconst";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;
    
    public ConexionDB(){
    
    }
    
    /**
     * Este metodo abre la conexion a la BD especificada previamente, ademas esta controlada en caso de fallos.
     * @return cx la conexion a la base de datos
     */
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url + db, user, password);
            System.out.println("\033[32m" + "Conexion exitosa a la BD " + db);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("No se pudo conectar a la BD " + db + ", vuelva a intentar.");
            //Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx; 
    }
    
    // Este metodo realiza la desconexion a la BD especificada previamente, tambien esta controlada de posibles fallos.
    public void desconectar(){
        try {
            cx.close();
            System.out.println("\033[33m" + "Se ha desconectado de la BD " + db);
        } catch (SQLException ex) {
            System.err.println("Surgio un error al intentar desconectar la BD, vuelva a intentar.");
            //Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
