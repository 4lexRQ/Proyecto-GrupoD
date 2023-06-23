package proyectogrupog;

import vistas.acceso.FAcceso;

/**
 * @author Jose Franco (Proyecto CS Grupo G)
 * @version 1.0
 */
public class ProyectoGrupoG {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FAcceso().setVisible(true);
            }
        });
        
        System.out.println("Registro de eventos de conexion");
    }
    
}
