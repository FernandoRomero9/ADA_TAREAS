/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

/**
 *
 * @author Usuario
 */
import java.util.List;

public class AlgoritmoMaximaSuma {

    public SubsecuenciaMaxima encontrarMaximaSuma(List<Numero> numeros) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        int start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < numeros.size(); i++) {
            maxEndingHere += numeros.get(i).getValor();

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                tempStart = i + 1;
            }
        }

        return new SubsecuenciaMaxima(maxSoFar, start, end);
    }
}
