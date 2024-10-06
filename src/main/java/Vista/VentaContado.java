/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Venta;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class VentaContado extends javax.swing.JFrame {
    private List<Venta> ventas = new ArrayList<>();

    public VentaContado() {
        initComponents();
        jPanelMostrarSeleccion.setLayout(new BoxLayout(jPanelMostrarSeleccion, BoxLayout.Y_AXIS)); // Para un diseño vertical   
        mostrarFechaYHora();
        setLocationRelativeTo(null);  
    }

    private void procesarVenta() {
        // Capturar los datos del cliente, RUC, producto, y cantidad
        String nombreCliente = txtCliente.getText();
        String ruc = txtRuc.getText();
        String producto = cbxSeleccionProducto.getSelectedItem().toString();
        int cantidad;

        // Validar que la cantidad sea un número
        try {
            cantidad = Integer.parseInt(txtCantidad.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si la cantidad no es válida
        }

        // Verificar si el producto ya está en la lista de ventas
        boolean encontrado = false; // Bandera para verificar si el producto ya existe
        for (Venta venta : ventas) {
            if (venta.getProducto().equals(producto)) {
                // Si ya existe, actualizar la cantidad
                int nuevaCantidad = venta.getCantidad() + cantidad; // Sumar a la cantidad existente
                venta.setCantidad(nuevaCantidad); // Actualizar la cantidad en el objeto Venta
                encontrado = true; // Indicar que se encontró el producto
                break; // Salir del bucle
            }
        }

        // Si no se encontró el producto, crear una nueva instancia de Venta
        if (!encontrado) {
            Venta nuevaVenta = new Venta(nombreCliente, ruc, producto, cantidad);
            ventas.add(nuevaVenta); // Añadir la nueva venta a la lista
        }

        // Mostrar todos los productos en el panel
        mostrarProductosSeleccionados(); // Llamar al nuevo método

        // Calcular el subtotal y el total a pagar
        double subtotal = calcularSubtotal();
        double totalAPagar = aplicarDescuento(subtotal);

        // Mostrar el total a pagar en lblPrecioFinal
        lblPrecioFinal.setText(String.format("%.2f", totalAPagar));

        // Mostrar el resumen de la venta  
        mostrarResumen(nombreCliente, ruc, totalAPagar); // Solo pasa los parámetros necesarios
    }

    private void mostrarProductosSeleccionados() {
        // Limpiar el panel antes de mostrar los nuevos productos
    jPanelMostrarSeleccion.removeAll(); // Limpiar el panel para evitar duplicados

    // Mostrar todos los productos con sus cantidades
    for (Venta venta : ventas) {
        String producto = venta.getProducto();
        int cantidad = venta.getCantidad();
        double precio = venta.getPrecio(); // Obtener el precio desde el objeto Venta
        JLabel productoInfo = new JLabel(String.format("Producto: %s - Precio: %.2f - Cantidad: %d", producto, precio, cantidad));
        jPanelMostrarSeleccion.add(productoInfo);
    }

    // Refrescar el panel para que los cambios sean visibles
    jPanelMostrarSeleccion.revalidate();
    jPanelMostrarSeleccion.repaint();
    }

    private double calcularSubtotal() {
        double subtotal = 0.0;
        for (Venta venta : ventas) {
            subtotal += venta.calculaSubtotal(); // Usar el método para calcular el subtotal
        }
        return subtotal;
    }

    private double aplicarDescuento(double subtotal) {
        double descuento = 0.0;
        if (subtotal < 1000) {
            descuento = subtotal * 0.05;
        } else if (subtotal <= 3000) {
            descuento = subtotal * 0.08;
        } else {
            descuento = subtotal * 0.12;
        }
        return subtotal - descuento;
    }

    private void mostrarResumen(String nombreCliente, String ruc, double totalAPagar) {
        // Obtener fecha y hora actual
    String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    String hora = new SimpleDateFormat("HH:mm:ss").format(new Date());

    // Crear el resumen de la venta
    StringBuilder resumen = new StringBuilder(); // Usar StringBuilder para mejor rendimiento

    // Información del cliente y separador
    resumen.append(String.format("Cliente: %s\nRUC: %s\nFecha: %s\nHora: %s\n", nombreCliente, ruc, fecha, hora));
    resumen.append("----------------------------------------------\n\n");  // Separador

    // Listar los productos y cantidades
    resumen.append("Productos Comprados:\n");
    for (Venta venta : ventas) {
        resumen.append(String.format("%s - Precio: %.2f - Cantidad: %d\n", venta.getProducto(), venta.getPrecio(), venta.getCantidad()));
    }
    resumen.append("------------------------------------------------ \n\n");  // Separador entre productos y totales

    // Calcular subtotal y descuento
    double subtotal = calcularSubtotal();
    double descuento = subtotal - totalAPagar;

    // Agregar el subtotal y el descuento al resumen
    resumen.append(String.format("Subtotal: %.2f\nDescuento: %.2f\nTotal a Pagar: %.2f", subtotal, descuento, totalAPagar));

    // Mostrar el resumen en el área de texto
    txtAreaResumen.setText(resumen.toString());
    }

    private void mostrarFechaYHora() {
        // Crear un objeto de fecha actual
        Date fechaActual = new Date();

        // Formatear la fecha y la hora
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

        // Obtener la fecha y hora en formato String
        String fecha = formatoFecha.format(fechaActual);
        String hora = formatoHora.format(fechaActual);

        // Mostrar la fecha y hora en las etiquetas lblFecha y lblHora
        lblFecha.setText(fecha);
        lblHora.setText(hora);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxSeleccionProducto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAdquirir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanelMostrarSeleccion = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaResumen = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblPrecioFinal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        panelTranslucido1 = new org.edisoncor.gui.panel.PanelTranslucido();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("DATOS DEL CLIENTE");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("CLIENTE O RAZON SOCIAL");

        txtCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCliente.setName("txtCliente"); // NOI18N
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("DATOS DE LA VENTA");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("SELECCION DEL PRODUCTO");

        cbxSeleccionProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lavadora", "Refrigeradora", "Licuadora", "Extractora", "Radiograbadora", "DVD", "Blue ray" }));
        cbxSeleccionProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbxSeleccionProducto.setName("cbxSeleccionProducto"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("CANTIDAD SOLICITADA");

        txtCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCantidad.setName("txtCantidad"); // NOI18N

        btnAdquirir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdquirir.setText("ADQUIRIR");
        btnAdquirir.setToolTipText("");
        btnAdquirir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAdquirir.setName("btnAdquirir"); // NOI18N
        btnAdquirir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdquirirActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("RUC");

        txtRuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtRuc.setName("txtRuc"); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("FECHA");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("HORA");

        jPanelMostrarSeleccion.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMostrarSeleccion.setBorder(new javax.swing.border.MatteBorder(null));
        jPanelMostrarSeleccion.setName("jPanelMostrarSeleccion"); // NOI18N

        javax.swing.GroupLayout jPanelMostrarSeleccionLayout = new javax.swing.GroupLayout(jPanelMostrarSeleccion);
        jPanelMostrarSeleccion.setLayout(jPanelMostrarSeleccionLayout);
        jPanelMostrarSeleccionLayout.setHorizontalGroup(
            jPanelMostrarSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelMostrarSeleccionLayout.setVerticalGroup(
            jPanelMostrarSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );

        txtAreaResumen.setColumns(20);
        txtAreaResumen.setRows(5);
        txtAreaResumen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAreaResumen.setName("txtAreaResumen"); // NOI18N
        jScrollPane2.setViewportView(txtAreaResumen);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("RESUMEN");

        jLabel11.setFont(new java.awt.Font("Calisto MT", 1, 36)); // NOI18N
        jLabel11.setText("NETO A PAGAR");

        lblPrecioFinal.setFont(new java.awt.Font("Bodoni Bd BT", 0, 36)); // NOI18N
        lblPrecioFinal.setText("---------");
        lblPrecioFinal.setName("lblPrecioFinal"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VENTA DE PRODUCTOS AL CONTADO");

        javax.swing.GroupLayout panelTranslucido1Layout = new javax.swing.GroupLayout(panelTranslucido1);
        panelTranslucido1.setLayout(panelTranslucido1Layout);
        panelTranslucido1Layout.setHorizontalGroup(
            panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTranslucido1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(123, 123, 123))
        );
        panelTranslucido1Layout.setVerticalGroup(
            panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucido1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7))
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxSeleccionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAdquirir, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(125, 125, 125)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9)))))
                            .addComponent(jPanelMostrarSeleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(26, 26, 26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblPrecioFinal)
                                        .addGap(103, 103, 103))
                                    .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator3)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelTranslucido1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxSeleccionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdquirir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelMostrarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void btnAdquirirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdquirirActionPerformed
 // Capturar los datos del cliente, RUC, producto, y cantidad
    String nombreCliente = txtCliente.getText();
    String ruc = txtRuc.getText();
    String producto = cbxSeleccionProducto.getSelectedItem().toString();
    int cantidad;

    // Validar que la cantidad sea un número
    try {
        cantidad = Integer.parseInt(txtCantidad.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingresa una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si la cantidad no es válida
    }

    // Verificar si el producto ya está en la lista de ventas
    boolean encontrado = false; // Bandera para verificar si el producto ya existe
    for (Venta venta : ventas) {
        if (venta.getProducto().equals(producto)) {
            // Si ya existe, actualizar la cantidad
            int nuevaCantidad = venta.getCantidad() + cantidad; // Sumar a la cantidad existente
            venta.setCantidad(nuevaCantidad); // Actualizar la cantidad en el objeto Venta
            encontrado = true; // Indicar que se encontró el producto
            break; // Salir del bucle
        }
    }

    // Si no se encontró el producto, crear una nueva instancia de Venta
    if (!encontrado) {
        Venta nuevaVenta = new Venta(nombreCliente, ruc, producto, cantidad);
        ventas.add(nuevaVenta); // Añadir la nueva venta a la lista
    }

    // Mostrar todos los productos en el panel
    mostrarProductosSeleccionados(); // Llamar al nuevo método

    // Calcular el subtotal y el total a pagar
    double subtotal = calcularSubtotal();
    double totalAPagar = aplicarDescuento(subtotal);

    // Mostrar el total a pagar en lblPrecioFinal
    lblPrecioFinal.setText(String.format("%.2f", totalAPagar));

    // Mostrar el resumen de la venta  
    mostrarResumen(nombreCliente, ruc, totalAPagar); // Solo pasa los parámetros necesarios    
    }//GEN-LAST:event_btnAdquirirActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // Oculta la ventana actual
        this.setVisible(false);

        // Crea una nueva instancia de SeleccionVenta
        SeleccionVenta seleccionVenta = new SeleccionVenta();

        // Muestra la ventana de SeleccionVenta
        seleccionVenta.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      // Habilitar decoraciones del Look and Feel para el JFrame
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        // Aplicar el Look and Feel de JTattoo
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace(); // Muestra cualquier error en la consola
        }   

        // Ejecutar la aplicación en el hilo de despacho de eventos
        java.awt.EventQueue.invokeLater(() -> {
            new VentaContado().setVisible(true); // Muestra la ventana
        });
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdquirir;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxSeleccionProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelMostrarSeleccion;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblPrecioFinal;
    private org.edisoncor.gui.panel.PanelTranslucido panelTranslucido1;
    private javax.swing.JTextArea txtAreaResumen;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtRuc;
    // End of variables declaration//GEN-END:variables

}