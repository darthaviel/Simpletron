/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletron_v1.pkg0;

/**
 *
 * @author J
 */
public class Memoria {

    int[] cubetas = new int[100];
    int[] apartado = new int[50];

    public void guardar(int entrada, int campo) {

        cubetas[campo] = entrada;

    }

    public void guardarApartado(int campo) {
        for (int i = 0; i < apartado.length; i++) {
            if (i == 0) {
                apartado[i] = campo;
            }
        }

    }
}
