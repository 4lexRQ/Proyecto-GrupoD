package proyectogrupog;

import vistas.acceso.FAcceso;

/**
 * @author Jose Franco (Proyecto CS Grupo G)
 * @version 1.0
 */
public class ProyectoGrupoG {
    //Metodo main (PRINCIPAL)
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FAcceso().setVisible(true);
            }
        });
    }
    
}
