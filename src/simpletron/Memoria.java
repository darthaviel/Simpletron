
package simpletron;


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
