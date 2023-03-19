
package Entidades;

public class Cliente {
        
    private String cedula;
    private String nombres;
    private String apellidos;
    private String celular;
    private String direccion;
    private String correo;

    public Cliente(String cedula, String nombres, String apellidos, String celular, String direccion, String correo) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.direccion = direccion;
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return apellidos + " " + nombres + " | C.I. " + 
               cedula + " | Cel: " + celular + " | " +
               direccion + " | " + correo;
    }    
}
