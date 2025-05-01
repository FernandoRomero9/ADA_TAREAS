/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

/**
 *
 * @author Usuario
 */
import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Ingrese la cantidad de números a generar: ");
        int cantidad = scanner.nextInt();

        List<Numero> lista = new ArrayList<>();

        System.out.print("Valores generados: ");
        for (int i = 0; i < cantidad; i++) {
            int valor = random.nextInt(41) - 20; // Números entre -20 y 20
            Numero numero = new Numero(valor, i + 1);
            lista.add(numero);
            System.out.print(valor + " ");
        }

        System.out.println(); // salto de línea

        AlgoritmoMaximaSuma algoritmo = new AlgoritmoMaximaSuma();
        SubsecuenciaMaxima resultado = algoritmo.encontrarMaximaSuma(lista);

        resultado.mostrarResultado();

        // Mostrar subsecuencia
        System.out.print("Subsecuencia máxima: ");
        for (int i = resultado.getInicio(); i <= resultado.getFin(); i++) {
            System.out.print(lista.get(i).getValor() + " ");
        }
        System.out.println();
    }
}