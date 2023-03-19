
package Entidades;

public class Compra {

    private Producto producto;
    private int cantidad;

    public Compra(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return producto.getNombre() + " | " + producto.getDescripcion() +
               " | $" + String.format("%.2f", producto.getPrecio_venta())  + " | " + cantidad +
               " | $" + String.format("%.2f", producto.getPrecio_venta() * cantidad);
    }
    
    
    
}
