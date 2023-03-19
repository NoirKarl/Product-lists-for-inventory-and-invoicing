
package Entidades;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ListaFactura {
    
    private LinkedList<Factura> listafactura;

    public ListaFactura() {
        this.listafactura = new LinkedList<>();
    }
    
    public void insertarFactura(Factura f){ 
        for (Factura factura : listafactura) {
            if (factura.getCodigo().equals(f.getCodigo())) {
                System.out.println("\n[!] El código de la factura ya existe en la lista. No se puede crear la factura.");
                return;
            }
        }
        
        int i = Collections.binarySearch(listafactura, f, Comparator.comparing(Factura::getCodigo));

        if (i < 0) 
            listafactura.add(-i - 1, f);
        
        System.out.println("\n[!] Nueva factura ingresada.");
        System.out.println(f);
    }
    
    public Factura consultarFactura(String codigo){
        int izq = 0;
        int der = listafactura.size() - 1;
        while(izq <= der){
            int central = (izq + der) / 2;
            int aux = codigo.compareTo(listafactura.get(central).getCodigo());
            if(aux < 0){
                der = central - 1;
            } else if(aux > 0){
                izq = central + 1;
            } else {
                return listafactura.get(central);
            }
        }
        return null;
    }
    
    public void mostrarFactura(){
        if (listafactura.isEmpty()) {
            System.out.println("\n[!] La lista de facturas se encuentra vacia");
            return;
        }
        
        boolean hayActivas = false;
        for(Factura factura: listafactura){
            if (factura.isActiva()){
                hayActivas = true;
                System.out.println(factura);
            }
        }

        if (!hayActivas){
            System.out.println("\n[!] No hay facturas activas.");
        }
    }
    
    public void mostrarFacturaAnuladas(){
        if (listafactura.isEmpty()) {
            System.out.println("\n[!] La lista de facturas se encuentra vacia");
            return;
        }
        
        boolean hayAnuladas = false;
        for(Factura factura: listafactura){
            if (!factura.isActiva()){
                hayAnuladas = true;
                System.out.println(factura);
            }
        }

        if (!hayAnuladas){
            System.out.println("\n[!] No hay facturas anuladas.");
        }
    }

    public void anularFactura(String codigo){
        Factura factura = consultarFactura(codigo);
        if (factura != null) {
            factura.setActiva(false);
            System.out.println("\n[!] Factura anulada:\n" + factura);
        }else{
            System.out.println("\n[!] Factura no encontrada");
        }
    }
    
}
