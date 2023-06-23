
package vistas.menuvehiculo;

import excepciones.excepcionFaltaDatos;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import modelos.Propietario;
import servicios.Control;

/**
 *
 * @author josef
 */
public class DAgregarVehiculo extends javax.swing.JDialog {

    //Creacion de intancias y listas
    ArrayList<String> marcasPopulares = new ArrayList<String>();
    HashMap<String, ArrayList<String>> modelosPorMarca = new HashMap<String, ArrayList<String>>();
    ArrayList<String> colores = new ArrayList<String>();
    Control control = new Control();
    Propietario propietario = new Propietario();
    
    //Metodo que setea el propietarioy de otra clase para ser usado
    public void setPropietario(Propietario propietario){
        this.propietario = propietario;
    }
    
    //Metodo que agrega a una lista los colores
    public void setColores(){
        colores.add("Negro");
        colores.add("Blanco");
        colores.add("Gris");
        colores.add("Rojo");
        colores.add("Azul");
        colores.add("Plateado");
        colores.add("Dorado");
        colores.add("Beige");
        colores.add("Marron");
        colores.add("Verde");
        
        cmbColor.addItem("Seleccionar");
        for(int i = 0; i < colores.size(); i++){
            cmbColor.addItem(colores.get(i));
        }
    }
    
    /**
     * Creates new form DAgregarVehiculo
     */
    public DAgregarVehiculo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setColores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CmbMarca = new javax.swing.JComboBox<>();
        CmbModelo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtanio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        cmbColor = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 134, 190));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AGREGAR VEHICULO");

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MARCA");

        CmbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbMarcaItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MODELO");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("AÑO");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("COLOR");

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PLACA");

        btnAgregar.setBackground(new java.awt.Color(0, 51, 153));
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("AGREGAR");

        javax.swing.GroupLayout btnAgregarLayout = new javax.swing.GroupLayout(btnAgregar);
        btnAgregar.setLayout(btnAgregarLayout);
        btnAgregarLayout.setHorizontalGroup(
            btnAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAgregarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        btnAgregarLayout.setVerticalGroup(
            btnAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtanio, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbColor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CmbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(CmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CmbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbMarcaItemStateChanged
        CmbModelo.removeAllItems();
        if(CmbMarca.getItemCount() != 0){
            if (CmbMarca.getSelectedItem().toString() == null) {
                JOptionPane.showMessageDialog(null, "No hay modelos para mostrar de esta Marca");
            }else{
                String marca = CmbMarca.getSelectedItem().toString();
                if(modelosPorMarca.containsKey(marca)){
                    ArrayList<String> models = modelosPorMarca.get(marca);
                    //Agrega los item al ComboBox
                    CmbModelo.addItem("Seleccionar");
                    for(int i = 0; i < models.size(); i++){
                        CmbModelo.addItem(models.get(i));
                        System.out.println(models.get(i));
                    }
                }else{
                    System.out.println("La marca " + marca + " no se encuentra en la lista");
                }
            }
        }
    }//GEN-LAST:event_CmbMarcaItemStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarMarcaLista();
        llenarModelos();
        //Agrega las marcas y los modelos a los Combo Box
        CmbMarca.addItem("Seleccionar");
        for(int i = 0; i < marcasPopulares.size(); i++){
            CmbMarca.addItem(marcasPopulares.get(i));
        }
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param evt Agrega un vehiculo registado por el usuario
     * @exception excepcionFaltaDatos Se lanza cuando faltan datos por llenar del usuario
     */
    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        try {
            if(CmbMarca.getSelectedIndex() != 0 || CmbModelo.getSelectedIndex() != 0 || cmbColor.getSelectedIndex() != 0 
                    || !txtPlaca.getText().isEmpty() || !txtanio.getText().isEmpty()){
                try {
                    String marca = CmbMarca.getSelectedItem().toString();
                    String modelo = CmbModelo.getSelectedItem().toString();
                    String anio = txtanio.getText();
                    String numplaca = txtPlaca.getText();
                    String color = cmbColor.getSelectedItem().toString();
                    if(control.crearVehiculo(propietario.getId_propietario(), marca, modelo, anio, numplaca, true , color)) {
                        JOptionPane.showMessageDialog(null, "Auto " + marca + " " + modelo + " registrado correctamente.");
                        limpiarTodo();
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage().trim());
                }
            } else {
                throw new excepciones.excepcionFaltaDatos();
            }
        }catch(excepcionFaltaDatos e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarMouseClicked

    //Metodo que llena la lista de Marcas de vehiculo
    public void llenarMarcaLista() {
        marcasPopulares.add("Toyota");
        marcasPopulares.add("Ford");
        marcasPopulares.add("Honda");
        marcasPopulares.add("Nissan");
        marcasPopulares.add("Chevrolet");
        marcasPopulares.add("Volkswagen");
        marcasPopulares.add("Hyundai");
        marcasPopulares.add("Kia");
        marcasPopulares.add("BMW");
        marcasPopulares.add("Mercedes-Benz");
    }
    //Metodo que llena la lista de modelos y los agraga al HashMap de los diferentes 
    //modelos de las marcas de vehiculos
    public void llenarModelos(){        
        ArrayList<String> toyotaModels = new ArrayList<String>();
        toyotaModels.add("Corolla");
        toyotaModels.add("Camry");
        toyotaModels.add("RAV4");
        modelosPorMarca.put("Toyota", toyotaModels);

        ArrayList<String> fordModels = new ArrayList<String>();
        fordModels.add("Fiesta");
        fordModels.add("Focus");
        fordModels.add("Mustang");
        modelosPorMarca.put("Ford", fordModels);

        ArrayList<String> hondaModels = new ArrayList<String>();
        hondaModels.add("Civic");
        hondaModels.add("Accord");
        hondaModels.add("CR-V");
        modelosPorMarca.put("Honda", hondaModels);
        
        ArrayList<String> nissanModels = new ArrayList<String>();
        nissanModels.add("Altima");
        nissanModels.add("Sentra");
        nissanModels.add("Maxima");
        modelosPorMarca.put("Nissan", nissanModels);

        ArrayList<String> chevroletModels = new ArrayList<String>();
        chevroletModels.add("Camaro");
        chevroletModels.add("Silverado");
        chevroletModels.add("Cruze");
        modelosPorMarca.put("Chevrolet", chevroletModels);

        ArrayList<String> volkswagenModels = new ArrayList<String>();
        volkswagenModels.add("Jetta");
        volkswagenModels.add("Golf");
        volkswagenModels.add("Passat");
        modelosPorMarca.put("Volkswagen", volkswagenModels);

        ArrayList<String> hyundaiModels = new ArrayList<String>();
        hyundaiModels.add("Sonata");
        hyundaiModels.add("Elantra");
        hyundaiModels.add("Tucson");
        modelosPorMarca.put("Hyundai", hyundaiModels);

        ArrayList<String> kiaModels = new ArrayList<String>();
        kiaModels.add("Optima");
        kiaModels.add("Sorento");
        kiaModels.add("Sportage");
        modelosPorMarca.put("Kia", kiaModels);

        ArrayList<String> bmwModels = new ArrayList<String>();
        bmwModels.add("3 Series");
        bmwModels.add("5 Series");
        bmwModels.add("X3");
        modelosPorMarca.put("BMW", bmwModels);

        ArrayList<String> mercedesModels = new ArrayList<String>();
        mercedesModels.add("C-Class");
        mercedesModels.add("E-Class");
        mercedesModels.add("S-Class");
        modelosPorMarca.put("Mercedes-Benz", mercedesModels);

        ArrayList<String> selecmodel = new ArrayList<String>();
        chevroletModels.add("Seleccionar");
        modelosPorMarca.put("Seleccionar", selecmodel);

        //Agregar mas marcas y modelos
    }
    
    public void limpiarTodo() {
        CmbMarca.setSelectedIndex(0);
        CmbModelo.setSelectedIndex(0);
        cmbColor.setSelectedIndex(0);
        txtPlaca.setText("");
        txtanio.setText("");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DAgregarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DAgregarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DAgregarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DAgregarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DAgregarVehiculo dialog = new DAgregarVehiculo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbMarca;
    private javax.swing.JComboBox<String> CmbModelo;
    private javax.swing.JPanel btnAgregar;
    private javax.swing.JComboBox<String> cmbColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtanio;
    // End of variables declaration//GEN-END:variables
}
