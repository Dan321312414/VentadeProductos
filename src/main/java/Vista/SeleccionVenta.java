/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionVenta extends javax.swing.JFrame {

    private JButton btnContado;
    private JButton btnCredito;
    private JLabel label;
 public SeleccionVenta() {
     setTitle("Seleccionar tipo de venta");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
        
        // Crear los botones
        btnContado = new JButton("Venta al Contado");
        btnContado.setPreferredSize(new Dimension(150, 50));
        
        btnCredito = new JButton("Venta a Crédito");
        btnCredito.setPreferredSize(new Dimension(150, 50));
        
        label = new JLabel("SELECCIONE EL TIPO DE VENTA");
        label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        
        // Añadir los ActionListeners para manejar los clics
        btnContado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentaContado(); // Abrir ventana de venta al contado
            }
        });
        btnCredito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentaCredito(); // Abrir ventana de venta a crédito
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Usar GridBagLayout para centrar los componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margen entre los componentes

        // Añadir el label en la parte superior
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(label, gbc);

        // Añadir el botón de contado
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(btnContado, gbc);

        // Añadir el botón de crédito
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(btnCredito, gbc);

        // Añadir el panel a la ventana
        add(panel);;
    }
        
 private void abrirVentaContado() {
        VentaContado ventaContado = new VentaContado(); // Ventana de contado
        ventaContado.setVisible(true); // Mostrar la ventana de contado
        dispose(); // Cerrar la ventana actual
    }

    private void abrirVentaCredito() {
        VentaCredito ventaCredito = new VentaCredito(); // Ventana de crédito
        ventaCredito.setVisible(true); // Mostrar la ventana de crédito
        dispose(); // Cerrar la ventana actual
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
         SeleccionVenta seleccionView = new SeleccionVenta();
        seleccionView.setVisible(true); // Mostrar la ventana principal
    
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
            java.util.logging.Logger.getLogger(SeleccionVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
     JFrame.setDefaultLookAndFeelDecorated(true);
        
        // Aplicar el Look and Feel de JTattoo
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace(); // Muestra cualquier error en la consola
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
