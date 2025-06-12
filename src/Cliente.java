/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Cliente {
    String codigo, nombres, apellidos, telefono, correo, direccion, postal;

    public Cliente(String codigo, String nombres, String apellidos, String telefono, String correo, String direccion, String postal) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.postal = postal;
    }

    public String claveUnica() {
        return Utilidades.normalizar(nombres + " " + apellidos);
    }

    @Override
    public String toString() {
        return nombres + " " + apellidos + " - Tel: " + telefono + " - Email: " + correo;
    }
}


