
package Modelo;

public class Venta {
    private String nombreCliente;
    private String ruc;
    private String fecha;
    private String hora;
    private String producto;
    private int cantidad;
    private double precio;
    
    public Venta(String nombreCliente, String ruc, String producto, int cantidad) {
        this.nombreCliente = nombreCliente;
        this.ruc = ruc;
        this.producto = producto;
        this.cantidad = cantidad;
        this.asignaPrecio(producto);
    }
    
    public void asignaPrecio(String producto) {
        switch(producto.toLowerCase()) {
            case "lavadora":
                this.precio = 1500.00;
                break;
            case "refrigeradora":
                this.precio = 3500.00;
                break;
            case "licuadora":
                this.precio = 500.00;
                break;
            case "extractora":
                this.precio = 150.00;
                break;
            case "radiograbadora":
                this.precio = 750.00;
                break;
            case "dvd":
                this.precio = 100.00;
                break;
            case "blue ray":
                this.precio = 250.00;
                break;
            default:
                this.precio = 0.0;  // Producto no válido
        }
    }
    
    public double calculaSubtotal() {
        return this.precio * this.cantidad;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

   
}
