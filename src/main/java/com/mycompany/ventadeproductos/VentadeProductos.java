/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ventadeproductos;

import Vista.SeleccionVenta;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author USER 17
 */
public class VentadeProductos {

    public static void main(String[] args) {
        // Establecer el Look and Feel
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Iniciar la GUI en el hilo de despacho de eventos
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Crear y mostrar la ventana de SeleccionVenta
                SeleccionVenta ventana = new SeleccionVenta();
                ventana.setVisible(true);
            }
        });
    }
}