/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class NodoABB {
    private Cliente cliente;
    private NodoABB izquierda;
    private NodoABB derecha;

    public NodoABB(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() { return cliente; }
    public NodoABB getIzquierda() { return izquierda; }
    public NodoABB getDerecha() { return derecha; }

    public void setIzquierda(NodoABB izquierda) { this.izquierda = izquierda; }
    public void setDerecha(NodoABB derecha) { this.derecha = derecha; }
}

