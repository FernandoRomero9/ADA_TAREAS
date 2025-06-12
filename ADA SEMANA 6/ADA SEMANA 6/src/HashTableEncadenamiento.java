/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
import java.util.LinkedList;

public class HashTableEncadenamiento {
    private NodoArbol[] tabla;
    private int size;

    public HashTableEncadenamiento(int capacidad) {
        tabla = new NodoArbol[capacidad];
        size = capacidad;
    }

    private int hash(String clave) {
        return Math.abs(clave.hashCode() % size);
    }

    public void insertar(Cliente cliente) {
        String clave = cliente.claveUnica();
        int index = hash(clave);
        tabla[index] = insertarArbol(tabla[index], cliente);
    }

    private NodoArbol insertarArbol(NodoArbol nodo, Cliente cliente) {
        if (nodo == null) return new NodoArbol(cliente);
        int cmp = cliente.claveUnica().compareTo(nodo.cliente.claveUnica());
        if (cmp < 0) nodo.izq = insertarArbol(nodo.izq, cliente);
        else nodo.der = insertarArbol(nodo.der, cliente);
        return nodo;
    }

    public Cliente buscar(String nombreCompleto) {
        String clave = Utilidades.normalizar(nombreCompleto);
        int index = hash(clave);
        return buscarArbol(tabla[index], clave);
    }

    private Cliente buscarArbol(NodoArbol nodo, String clave) {
        if (nodo == null) return null;
        int cmp = clave.compareTo(nodo.cliente.claveUnica());
        if (cmp == 0) return nodo.cliente;
        else if (cmp < 0) return buscarArbol(nodo.izq, clave);
        else return buscarArbol(nodo.der, clave);
    }

    class NodoArbol {
        Cliente cliente;
        NodoArbol izq, der;

        public NodoArbol(Cliente c) {
            cliente = c;
        }
    }
}

