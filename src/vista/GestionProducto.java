/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.CRUD_Productos;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Producto;
import modelo.Usuario;
import utils.AccionesEnum;

/**
 *
 * @author Prueba
 */
public class GestionProducto extends javax.swing.JFrame {

    private AccionesEnum accion;
    private Producto producto;
    private CRUD_Productos crudProductos = new CRUD_Productos();
    private Usuario usuario;

    public GestionProducto(Usuario usuario, Producto producto, AccionesEnum accion) {
        setLocationRelativeTo(null);
        this.producto = producto;
        this.usuario = usuario;
        this.accion = accion;

        initComponents();

        if (AccionesEnum.BAJA.equals(accion)) {
            mostrarDatosDeshabilitados(producto);
        } else if (AccionesEnum.MODIFICACION.equals(accion)) {
            mostrarDatosHabilitados(producto);
        }
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
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabelApellidos = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        jTextFieldPrecio = new javax.swing.JTextField();
        jLabelUSuario = new javax.swing.JLabel();
        jTextFieldStock = new javax.swing.JTextField();
        jButtonVolver = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        jLabelNombre.setText("Id:");

        jTextFieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdActionPerformed(evt);
            }
        });

        jLabelApellidos.setText("Nombre:");

        jLabelDireccion.setText("Precio:");

        jLabelUSuario.setText("Stock:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNombre)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabelApellidos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelUSuario)
                            .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDireccion)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jLabelApellidos)
                    .addComponent(jLabelDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelUSuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAceptar)
                .addGap(28, 28, 28)
                .addComponent(jButtonVolver)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonVolver))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        if (AccionesEnum.ALTA.equals(accion)) {
            BienvenidoUsuario hola = new BienvenidoUsuario(usuario);
            dispose();
            hola.setVisible(true);
        } else {
            ListarProducto listarProducto = new ListarProducto(usuario, this, true);
            dispose();
            listarProducto.setVisible(true);

        }
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // validamos que no haya una cuenta con el mismo numero ya existente

        // si no hay ninguna cuenta con el mismo número la damos de alta
        if (AccionesEnum.ALTA.equals(accion)) {
            Producto producto = recogerDatos();

            Integer numero = Integer.parseInt(jTextFieldId.getText());
            List<Producto> misProductos = crudProductos.search(new Producto(numero, null, null, null));
            if (misProductos.isEmpty()) {
                if (producto != null && crudProductos.add(producto)) {
                    JOptionPane.showMessageDialog(this, "Operación realizada correctamente.");
                    BienvenidoUsuario hola = new BienvenidoUsuario(usuario);
                    dispose();
                    hola.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Se ha producido un error.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ya hay un producto con el mismo número dada de alta.");
            }
        }
        if (AccionesEnum.BAJA.equals(accion)) {
            if (producto != null && crudProductos.delete(producto)) {
                JOptionPane.showMessageDialog(this, "Operación realizada correctamente.");
                ListarProducto listarProducto = new ListarProducto(usuario, this, true);
                dispose();
                listarProducto.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Se ha producido un error.");
            }

        }
        if (AccionesEnum.MODIFICACION.equals(accion)) {
            Producto producto = recogerDatos();
            if (producto != null && crudProductos.update(producto)) {
                JOptionPane.showMessageDialog(this, "Operación realizada correctamente.");
                ListarProducto listarProducto = new ListarProducto(usuario, this, true);
                dispose();
                listarProducto.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Se ha producido un error.");
            }
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelUSuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldStock;
    // End of variables declaration//GEN-END:variables

    private void mostrarDatosDeshabilitados(Producto producto) {
        jTextFieldNombre.setText(producto.getNombre());
        jTextFieldNombre.setEnabled(false);
        jTextFieldId.setText(String.valueOf(producto.getId()));
        jTextFieldId.setEnabled(false);
        jTextFieldPrecio.setText(String.valueOf(producto.getPrecio()));
        jTextFieldPrecio.setEnabled(false);
        jTextFieldStock.setText(String.valueOf(producto.getStock()));
        jTextFieldStock.setEnabled(false);

    }

    private void mostrarDatosHabilitados(Producto producto) {

        jTextFieldNombre.setText(producto.getNombre());
        jTextFieldId.setText(String.valueOf(producto.getId()));
        jTextFieldPrecio.setText(String.valueOf(producto.getPrecio()));
        jTextFieldStock.setText(String.valueOf(producto.getStock()));

    }

    private Producto recogerDatos() {
        boolean correcto = true;
        String errores = "";
        Producto producto = null;
        Integer id = Integer.parseInt(jTextFieldId.getText());
        if (id == null) {
            errores = errores + "- El campo id es obligatorio.\n";
            correcto = false;
        }
        String nombre = jTextFieldNombre.getText();
        if (nombre.isEmpty()) {
            errores = errores + "- El campo nombre es obligatorio.\n";
            correcto = false;
        }
        Float precio = Float.parseFloat(jTextFieldPrecio.getText());
        if (precio == null) {
            errores = errores + "- El campo precio es obligatorio.\n";
            correcto = false;
        }

        Integer stock = Integer.parseInt(jTextFieldStock.getText());
        if (stock == null) {
            errores = errores + "- El campo stock es obligatorio.\n";
            correcto = false;
        }

        if (correcto == true) {
            producto = new Producto(id, nombre, precio, stock);
        }else{
            JOptionPane.showMessageDialog(this, errores);
        }

        return producto;
    }
}
