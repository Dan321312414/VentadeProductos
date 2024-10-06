
package Modelo;

public class Contado extends Venta {
    public Contado(String nombreCliente, String ruc, String producto, int cantidad) {
        super(nombreCliente, ruc, producto, cantidad);
    }
    
    public double calculaDescuento() {
        double subtotal = this.calculaSubtotal();
        if (subtotal < 1000) {
            return subtotal * 0.05;
        } else if (subtotal <= 3000) {
            return subtotal * 0.08;
        } else {
            return subtotal * 0.12;
        }
    }
}
