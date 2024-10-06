
package Controlador;

import Modelo.Contado;
import Modelo.Credito;


public class VentaController {
    
    public double procesarVentaContado(String nombreCliente, String ruc, String producto, int cantidad) {
        Contado ventaContado = new Contado(nombreCliente, ruc, producto, cantidad);
        double subtotal = ventaContado.calculaSubtotal();
        double descuento = ventaContado.calculaDescuento();
        return subtotal - descuento;
    }
    
    public double[] procesarVentaCredito(String nombreCliente, String ruc, String producto, int cantidad, int letras) {
        Credito ventaCredito = new Credito(nombreCliente, ruc, producto, cantidad, letras);
        double subtotal = ventaCredito.calculaSubtotal();
        double descuento = ventaCredito.calculaDescuento();
        double totalAPagar = subtotal - descuento;
        double montoMensual = ventaCredito.calculaMontoMensual();
        return new double[]{totalAPagar, montoMensual};
    }
}
