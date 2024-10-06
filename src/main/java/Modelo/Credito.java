
package Modelo;

public class Credito extends Venta {
    private int letras;
    
    public Credito(String nombreCliente, String ruc, String producto, int cantidad, int letras) {
        super(nombreCliente, ruc, producto, cantidad);
        this.letras = letras;
    }
    
    public double calculaDescuento() {
        double subtotal = this.calculaSubtotal();
        if (subtotal < 1000) {
            return subtotal * 0.03;
        } else if (subtotal <= 3000) {
            return subtotal * 0.05;
        } else {
            return subtotal * 0.08;
        }
    }
    
    public double calculaMontoMensual() {
        double subtotal = this.calculaSubtotal();
        double descuento = this.calculaDescuento();
        double totalAPagar = subtotal - descuento;
        return totalAPagar / this.letras;
    }

    public int getLetras() {
        return letras;
    }

    public void setLetras(int letras) {
        this.letras = letras;
    }
    
 
}
