
package Entidades;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {

    private ListaProducto productos;
    private ListaCliente clientes;
    private ListaFactura facturas;
    Scanner sc = new Scanner(System.in);

    public Inventario() {
        productos = new ListaProducto();
        clientes = new ListaCliente();
        facturas = new ListaFactura();         
    }
    
    // Productos
    
    public void insertarProducto(){
        String codigo, nombre, descripcion;
        int cantidad;
        double costo;
        
        do{
            System.out.print("Ingrese el código del producto: ");
            codigo = sc.next();
            sc.nextLine();
            
            if (!codigo.matches("\\d+"))
                System.out.println("\n[!] El código debe ser numérico.\n");
            
        } while (!codigo.matches("\\d+"));
        
        System.out.print("Ingrese el nombre del producto: ");
        nombre = sc.nextLine();
        
        System.out.print("Ingrese la descripción del producto: ");
        descripcion = sc.nextLine();
        
        do {
            System.out.print("Ingrese la cantidad del producto: ");
            cantidad = sc.nextInt();
            sc.nextLine(); 
            
            if (cantidad < 0) 
                System.out.println("\n[!] La cantidad no puede ser negativa.\n");
            
        } while (cantidad < 0);
        
        do{
            System.out.print("Ingrese el costo del producto: ");
            costo = sc.nextDouble();
            
            if (costo < 0) 
                System.out.println("\n[!] El costo no puede ser negativo.\n");
            
        } while (costo < 0);
        
        sc.nextLine();
        
        Producto nuevoProducto = new Producto(codigo, nombre, descripcion, cantidad, costo);
        productos.insertarProducto(nuevoProducto);
    }
    
    public void consultarProducto(){
        System.out.print("Ingrese el código del producto: ");
        String codigo = sc.next();
        
        Producto busqueda = productos.consultarProducto(codigo);
        
        if (busqueda != null){
            System.out.println("\n[!] Producto encontrado");
            System.out.println(busqueda);
        } else {
            System.out.println("\n[!] No se ha encontrado el producto.");
        }
    }
    
    public void mostrarProductos(){
        productos.mostrarProducto();
    }
    
    public void eliminarProducto(){
        System.out.print("Ingrese el código del producto: ");
        String codigo = sc.next();
        
        productos.eliminarProducto(codigo);
    }
    
    // Facturas
    
    public void insertarFactura(){
        String codigo;
        do{
            System.out.print("Ingrese el código de la factura: ");
            codigo = sc.next();
            sc.nextLine();
            
            if (!codigo.matches("\\d+"))
                System.out.println("\n[!] El código debe ser numérico.\n");
            
        } while (!codigo.matches("\\d+"));

        Cliente cliente;

        do {
            System.out.println("\nLista de Clientes\n");
            clientes.mostrarcliente();
            System.out.print("\nIngrese la cédula del cliente: ");
            String cedula = sc.nextLine();
            cliente = clientes.consultarcliente(cedula);

            if (cliente == null) {
                System.out.println("\n[!] No se encontró un cliente con esa cédula. Intente de nuevo.");
            } else {
                break;
            }
        } while (true);

        ArrayList<Compra> compras = new ArrayList<Compra>();

        do {
            System.out.println("\nLista de Productos\n");
            productos.mostrarProducto();
            System.out.print("\nIngrese el código del producto que desea agregar a la factura: ");
            String codigoProducto = sc.nextLine();

            Producto producto = productos.consultarProducto(codigoProducto);

            if (producto == null) {
                System.out.println("\n[!] No se encontró un producto con ese código. Intente de nuevo.");
            } else {
                System.out.print("Ingrese la cantidad que desea agregar: ");
                int cantidad = sc.nextInt();
                sc.nextLine();

                if (cantidad > producto.getCantidad()) {
                    System.out.println("\n[!] La cantidad ingresada supera el stock del producto. Intente de nuevo.");
                } else {
                    Compra compra = new Compra(producto, cantidad);
                    compras.add(compra);

                    producto.setCantidad(producto.getCantidad()- cantidad);

                    System.out.print("¿Desea agregar más compras a la factura? (S/N): ");
                    String respuesta = sc.nextLine();

                    if (respuesta.equalsIgnoreCase("N")) 
                        break;
                }
            } 
        } while (true);

        System.out.print("Ingrese la fecha de emisión de la factura (DD/MM/AAAA): ");
        String fechaEmision = sc.nextLine();

        Factura nuevaFactura = new Factura(codigo, cliente, compras, fechaEmision);
        facturas.insertarFactura(nuevaFactura);
    }
    
    public void consultarFactura(){
        System.out.print("Ingrese el código de la factura: ");
        String codigo = sc.next();
        
        Factura busqueda = facturas.consultarFactura(codigo);
        
        if (busqueda != null){
            System.out.println("\n[!] Factura encontrada");
            System.out.println(busqueda);
        } else {
            System.out.println("\n[!] No se ha encontrado la factura.");
        }
    }
    
    public void mostrarFacturas(){
        int opcion;
        System.out.println("""
                           [1] Ver facturas activas
                           [2] Ver facturas anuladas""");
        
        opcion = sc.nextInt();
        
        switch(opcion) {
            case 1 -> facturas.mostrarFactura();
            case 2 -> facturas.mostrarFacturaAnuladas();
            default -> System.out.println("\n[!] Opción incorrecta.");
        }
    }
    
    public void anularFactura(){
        System.out.print("Ingrese el código de la factura: ");
        String codigo = sc.next();
        
        facturas.anularFactura(codigo);
    }
    
    // Clientes
    
    public void insertarCliente(){
        String cedula, nombres, apellidos, celular, direccion, correo;

        do{
            System.out.print("Ingrese la cedula del cliente: ");
            cedula = sc.next();
            sc.nextLine();
            
            if (!cedula.matches("\\d+"))
                System.out.println("\n[!] la cedula debe ser numérica.\n");
            
        } while (!cedula.matches("\\d+"));

        System.out.print("Ingrese los nombres: ");
        nombres = sc.nextLine();

        System.out.print("Ingrese los apellidos: ");
        apellidos = sc.nextLine();

        System.out.print("Ingrese el celular: ");
        celular = sc.nextLine();

        System.out.print("Ingrese la dirección: ");
        direccion = sc.nextLine();

        do{
            System.out.print("Ingrese el correo electrónico: ");
            correo = sc.nextLine();
            
            if (!correo.matches(".+@.+\\..+"))
                System.out.println("\n[!] El correo debe tener un formato válido (ejemplo: usuario@dominio.com)\n");
            
        } while (!correo.matches(".+@.+\\..+"));
        
        Cliente nuevoCliente = new Cliente(cedula, nombres, apellidos, celular, direccion, correo);
        clientes.insertarcliente(nuevoCliente);
    }
    
    public void consultarCliente(){
        System.out.print("Ingrese la cedula del cliente: ");
        String cedula = sc.next();
        
        Cliente busqueda = clientes.consultarcliente(cedula);
        
        if (busqueda != null){
            System.out.println("\n[!] Cliente encontrado");
            System.out.println(busqueda);
        } else {
            System.out.println("\n[!] No se ha encontrado el cliente.");
        }
    }
    
    public void mostrarClientes(){
        clientes.mostrarcliente();
    }
    
    public void eliminarCliente(){
        System.out.print("Ingrese la cédula del cliente: ");
        String cedula = sc.next();
        
        clientes.eliminarcliente(cedula);
    }
    
    // Validacion
    
    public boolean accesoFacturacion(){
        return !clientes.isVacia() && !productos.isVacia();
    }
    
}
