/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

/**
 *
 * @author Usuario
 */
public class SubsecuenciaMaxima {
    private int sumaMaxima;
    private int inicio;
    private int fin;

    public SubsecuenciaMaxima(int sumaMaxima, int inicio, int fin) {
        this.sumaMaxima = sumaMaxima;
        this.inicio = inicio;
        this.fin = fin;
    }

    public void mostrarResultado() {
        System.out.println("La sumatoria máxima consecutiva es de a (" + (inicio + 1) +
                           ") hasta a (" + (fin + 1) + ") con un valor de " + sumaMaxima + ".");
    }

    public int getInicio() {
        return inicio;
    }

    public int getFin() {
        return fin;
    }
}
