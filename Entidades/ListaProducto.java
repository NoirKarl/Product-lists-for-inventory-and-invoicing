
package Entidades;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ListaProducto {

    private LinkedList<Producto> listaproducto;
    
    public ListaProducto(){
        listaproducto = new LinkedList<>();
    }
    
    public boolean isVacia(){
        return listaproducto.isEmpty();
    }
    
    public void insertarProducto(Producto p){
        for (Producto producto : listaproducto) {
            if (producto.getCodigo().equals(p.getCodigo())) {
                System.out.println("\n[!] El código del producto ya existe en la lista. No se puede crear el producto.");
                return;
            }
        }
        
        int i = Collections.binarySearch(listaproducto, p, Comparator.comparing(Producto::getCodigo));

        if (i < 0) 
            listaproducto.add(-i - 1, p);
        
        System.out.println("\n[!] Nuevo producto ingresado.");
        System.out.println(p);
    }
    
    public Producto consultarProducto(String codigo){
        int izq = 0;
        int der = listaproducto.size() - 1;
        while(izq <= der){
            int central = (izq + der) / 2;
            int aux = codigo.compareTo(listaproducto.get(central).getCodigo());
            if(aux < 0){
                der = central - 1;
            } else if(aux > 0){
                izq = central + 1;
            } else {
                return listaproducto.get(central);
            }
        }
        return null;
    }
    
    public void mostrarProducto(){
        if (listaproducto.isEmpty()) {
            System.out.println("\n[!] La lista de productos se encuentra vacia");
            return;
        }
        for(Producto producto: listaproducto){
            System.out.println(producto);
        }
    }
    
    public void eliminarProducto(String codigo){
        Producto producto = consultarProducto(codigo);
        if (producto != null) {
            listaproducto.remove(producto);
            System.out.println("\n[!] Producto eliminado:\n" + producto);
        }else{
            System.out.println("\n[!] Producto no Encontrado");
        }
    }
    
}
