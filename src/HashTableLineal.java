/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class HashTableLineal {
    private Cliente[] tabla;
    private int size;

    public HashTableLineal(int capacidad) {
        tabla = new Cliente[capacidad];
        size = capacidad;
    }

    private int hash(String clave) {
        return Math.abs(clave.hashCode() % size);
    }

    public void insertar(Cliente cliente) {
        String clave = cliente.claveUnica();
        int index = hash(clave);
        while (tabla[index] != null) {
            index = (index + 1) % size;
        }
        tabla[index] = cliente;
    }

    public Cliente buscar(String nombreCompleto) {
        String clave = Utilidades.normalizar(nombreCompleto);
        int index = hash(clave);
        int intentos = 0;
        while (tabla[index] != null && intentos < size) {
            if (tabla[index].claveUnica().equals(clave)) {
                return tabla[index];
            }
            index = (index + 1) % size;
            intentos++;
        }
        return null;
    }
}

