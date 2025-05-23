/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ada.sem4;

/**
 *
 * @author Fernando Romero Cuyubamba 
 */

import java.util.Scanner;
import java.util.Stack;

class Par {
    int m;
    int n;

    Par(int m, int n) {
        this.m = m;
        this.n = n;
    }
}

public class AckermannIterativa {

    public int calcular(int m, int n) {
        Stack<Par> pila = new Stack<>();
        pila.push(new Par(m, n));

        while (!pila.isEmpty()) {
            Par par = pila.pop();
            m = par.m;
            n = par.n;

            if (m == 0) {
                if (pila.isEmpty()) {
                    return n + 1;
                } else {
                    pila.peek().n = n + 1;
                }
            } else if (n == 0) {
                pila.push(new Par(m - 1, 1));
            } else {
                pila.push(new Par(m - 1, -1));  
                pila.push(new Par(m, n - 1));
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AckermannIterativa ack = new AckermannIterativa();
        String continuar;

        do {
            System.out.print("Ingrese m: ");
            int m = sc.nextInt();
            System.out.print("Ingrese n: ");
            int n = sc.nextInt();

            int resultado = ack.calcular(m, n);
            System.out.println("Ackermann(" + m + ", " + n + ") = " + resultado);

            System.out.print("¿Desea probar con otros valores? (SI/NO): ");
            sc.nextLine(); 
            continuar = sc.nextLine().trim().toUpperCase();

        } while (continuar.equals("SI"));

        System.out.println("Gracias por usar el código.");
    }
}
