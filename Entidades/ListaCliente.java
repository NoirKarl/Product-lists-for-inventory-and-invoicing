
package Entidades;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ListaCliente {

    private LinkedList<Cliente> listacliente;
    
    public ListaCliente(){
        listacliente = new LinkedList<>();
    }
    
    public boolean isVacia(){
        return listacliente.isEmpty();
    }
    
    public void insertarcliente(Cliente c){ 
        for (Cliente cliente : listacliente) {
            if (cliente.getCedula().equals(c.getCedula())) {
                System.out.println("\n[!] El código del cliente ya existe en la lista. No se puede crear el cliente.");
                return;
            }
        }
        
        int i = Collections.binarySearch(listacliente, c, Comparator.comparing(Cliente::getCedula));

        if (i < 0) 
            listacliente.add(-i - 1, c);
        
        System.out.println("\n[!] Nuevo cliente ingresado.");
        System.out.println(c);
    }
    
    public Cliente consultarcliente(String cedula){
        int izq = 0;
        int der = listacliente.size() - 1;
        while(izq <= der){
            int central = (izq + der) / 2;
            int aux = cedula.compareTo(listacliente.get(central).getCedula());
            if(aux < 0){
                der = central - 1;
            } else if(aux > 0){
                izq = central + 1;
            } else {
                return listacliente.get(central);
            }
        }
        return null;
    }
    
    public void mostrarcliente(){
        if (listacliente.isEmpty()) {
            System.out.println("\n[!] La lista de clientes se encuentra vacia");
            return;
        }
        for(Cliente cliente: listacliente){
            System.out.println(cliente);
        }
    }
    
    public void eliminarcliente(String codigo){
        Cliente cliente = consultarcliente(codigo);
        if (cliente != null) {
            listacliente.remove(cliente);
            System.out.println("\n[!] Cliente eliminado:\n" + cliente);
        }else{
            System.out.println("\n[!] Cliente no encontrado");
        }
    }
    
}
