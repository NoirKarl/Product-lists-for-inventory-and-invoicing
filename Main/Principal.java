
package Main;

import Entidades.Inventario;
import java.util.Scanner;

public class Principal {

    static Scanner in = new Scanner(System.in);
    
    static Inventario miInventario = new Inventario();
    
    public static void main(String[] args) {

        
        
        /*
        Producto shampoo = new Producto("213", "Shampoo", "Antibacterial", 25, 36);
        Producto shampoo2 = new Producto("441", "Teclado", "gamer", 2, 200);
        
        ArrayList<Compra> compras = new ArrayList<>();
        
        Compra compra1 = new Compra(shampoo2, 2);
        Compra compra2 = new Compra(shampoo, 5);
        
        
        compras.add(compra1);
        compras.add(compra2);
        
        Factura factura = new Factura ("001", new Cliente("0750920159", "Molina Cisneros", "Xavier", "095953800", "Eloy Alfaro", "xeavi@hotmail.com"), compras, "25 Dic 2022");
        
        System.out.println(shampoo);
        */ 
        int opcion;
       
        do {
            System.out.println("""
                               \nInventario: 
                               1.- Administrar productos
                               2.- Administrar facturas
                               3.- Administrar clientes
                               4.- Salir""");
            
            System.out.print("\nOpcion: ");   opcion = in.nextInt();
            
            switch(opcion){
                case 1 -> administrarProductos();
                case 2 -> {
                    if (miInventario.accesoFacturacion()){
                        administrarFacturas();
                    } else {
                        System.out.println("\n[!] No existen productos o clientes registrados.");
                    }
                }
                case 3 -> administrarClientes();
                case 4 -> {
                    System.out.println("\n[!] Cerrando aplicacion...");
                    System.exit(0);
                }
                default -> System.out.println("\n[!] Opcion incorrecta");
            }
            
        } while(opcion != 4); 

    }
    
    private static void administrarProductos(){
        int opcion;
        
        do {
            System.out.println("""
                               \nAdministrar productos: 
                               1.1.- Ingresar producto
                               1.2.- Consultar producto
                               1.3.- Mostrar todos los productos
                               1.4.- Eliminar producto
                               1.5.- Regresar""");
            
            System.out.print("\nOpcion: ");   opcion = in.nextInt();
            
            switch(opcion){
                case 1 -> {
                    System.out.println("\n[!] Ingresar producto:");
                    miInventario.insertarProducto();
                }
                
                case 2 -> {
                    System.out.println("\n[!] Consultar producto:");
                    miInventario.consultarProducto();
                }
                
                case 3 -> {
                    System.out.println("\n[!] Mostrar todos los productos:");
                    miInventario.mostrarProductos();
                }
                
                case 4 -> {
                    System.out.println("\n[!] Eliminar producto:");
                    miInventario.eliminarProducto();
                }
                
                case 5 -> System.out.println("\n[!] Regresando...");
                
                default -> System.out.println("\n[!] Opcion incorrecta");
            }
            
        } while(opcion != 5); 
    }
    
    private static void administrarFacturas(){
        int opcion;
        
        do {
            System.out.println("""
                               \nAdministrar facturas: 
                               2.1.- Emitir factura
                               2.2.- Consultar factura
                               2.3.- Mostrar todas las facturas
                               2.4.- Anular factura
                               2.5.- Regresar""");
            
            System.out.print("\nOpcion: ");   opcion = in.nextInt();
            
            switch(opcion){
                case 1 -> {
                    System.out.println("\n[!] Emitir factura:");
                    miInventario.insertarFactura();
                }
                
                case 2 -> {
                    System.out.println("\n[!] Consultar factura:");
                    miInventario.consultarFactura();
                }
                
                case 3 -> {
                    System.out.println("\n[!] Mostrar todas las facturas:");
                    miInventario.mostrarFacturas();
                }
                
                case 4 -> {
                    System.out.println("\n[!] Anular factura:");
                    miInventario.anularFactura();
                }
                
                case 5 -> System.out.println("\n[!] Regresando...");
                
                default -> System.out.println("\n[!] Opcion incorrecta");
            }
            
        } while(opcion != 5); 
    }
    
    private static void administrarClientes(){
        int opcion;
        
        do {
            System.out.println("""
                               \nAdministrar clientes: 
                               3.1.- Ingresar cliente
                               3.2.- Consultar cliente
                               3.3.- Mostrar todos los clientes
                               3.4.- Eliminar cliente
                               3.5.- Regresar""");
            
            System.out.print("\nOpcion: ");   opcion = in.nextInt();
            
            switch(opcion){
                case 1 -> {
                    System.out.println("\n[!] Ingresar cliente:");
                    miInventario.insertarCliente();
                }
                
                case 2 -> {
                    System.out.println("\n[!] Consultar cliente:");
                    miInventario.consultarCliente();
                }
                
                case 3 -> {
                    System.out.println("\n[!] Mostrar todos los clientes:");
                    miInventario.mostrarClientes();
                }
                
                case 4 -> {
                    System.out.println("\n[!] Eliminar cliente:");
                    miInventario.eliminarCliente();
                }
                
                case 5 -> System.out.println("\n[!] Regresando...");
                
                default -> System.out.println("\n[!] Opcion incorrecta");
                
            }
            
        } while(opcion != 5); 
    }

}
