
package Entidades;

public class Producto {

    private String codigo;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double costo;
    private double precio_venta;

    public Producto(String codigo, String nombre, String descripcion, int cantidad, double costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costo = costo;
        this.precio_venta = (costo <= 100) ? costo * 1.2 : costo * 1.15;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    @Override
    public String toString() {
    return codigo + " | " + nombre + " " + descripcion + 
           " | Stock: " + cantidad + " | Costo: $" + String.format("%.2f",costo) + " | PvP: $" + String.format("%.2f",precio_venta);
    }
    
}
