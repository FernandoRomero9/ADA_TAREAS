/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

/**
 *
 * @author Usuario
 */
public class Numero {
    private int valor;
    private int posicion;

    public Numero(int valor, int posicion) {
        this.valor = valor;
        this.posicion = posicion;
    }

    public int getValor() {
        return valor;
    }

    public int getPosicion() {
        return posicion;
    }

    @Override
    public String toString() {
        return valor + "";
    }
}
