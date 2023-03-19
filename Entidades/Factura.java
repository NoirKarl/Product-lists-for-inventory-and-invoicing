
package Entidades;

import java.util.ArrayList;

public class Factura {

    private String codigo;
    Cliente cliente;
    private ArrayList<Compra> compras; 
    private String fecha_emision;
    private boolean activa;
    private double total;

    public Factura(String codigo, Cliente cliente, ArrayList<Compra> compras, String fecha_emision) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.compras = compras;
        this.fecha_emision = fecha_emision;
        this.activa = true;
        this.total = calcularTotal();
    }

    public String getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public String getFecha_emision() {
        return fecha_emision;
    }

    public boolean isActiva() {
        return activa;
    }

    public double getTotal() {
        return total;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    private double calcularTotal() {
        double sumatoria = 0;
        for (Compra compra : compras){
            sumatoria += compra.getProducto().getPrecio_venta() * compra.getCantidad();
        }
        return sumatoria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nFactura No. ").append(codigo).append("\n");
        sb.append("Fecha: ").append(fecha_emision).append("\n\n");
        sb.append("Datos del cliente\n").append(cliente.toString()).append("\n\n");
        sb.append("Detalles de compra:\n");
        for (Compra compra : compras) {
            sb.append(compra.toString()).append("\n");
        }
        sb.append("\nTotal: $").append(String.format("%.2f", total));
        sb.append("\n################################################################");
        return sb.toString();
        }
    
    
    
    
    
}
