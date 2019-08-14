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
public class Texto {

    int[] codigo = new int[100];

    public void inicioMenu() {
        System.out.printf("\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                " ________________________________ ",
                "|                                |",
                "|          SIMPLETRON 1.0        |",
                "|               TOC              |",
                "|        THE OLYMPUS CODERS      |",
                "|________________________________|",
                "|               Menu             |",
                "|   --------------------------   |",
                "|   > 1 - Nuevo Programa         |",
                "|   > 2 - Mostrar Programa       |",
                "|   > 3 - Ejecutar Programa      |",
                "|   > 4 - Limpiar                |",
                "|   > 5 - Ayuda                  |",
                "|   > 6 - Salir                  |",
                "|________________________________|\n> ");

    }

    public void seleccionIncorrecta() {
        System.out.println("Opcion no valida\n>");
    }

    public void inicioGuardado() {
        System.out.printf("\n%s\n%s",
                "Ingrese el programa",
                "Al terminar ingrese 9999\n");
    }

    public void secuenciaInstruccion(int i) {
        System.out.print(i + " > ");
    }

    public void convNeg(int entrada) {
        System.out.println("Se convirtio la entrada a " + entrada);
    }

    public void advertenciaCampo() {
        System.out.printf("\n%s\n%s\n%s",
                "la ubicacion de memoria indicada en la instruccion podria estar siendo",
                "usada por otra instruccion",
                "para continuar S cualquier otro entrada para reingresar instruccion\n>");
    }

    public void aceptoAdvertencia() {
        System.out.println("ha decidido continuar");
    }

    public void rechazoAdvertencia() {
        System.out.println("ha decidido reingresar instruccion");

    }

    public void instruccionNoValida() {
        System.out.println("asegurese de estar ingresando una instruccion valida");
    }
    
    public void instruccionNoValidaAdvertencia() {
        System.out.printf("\n%s\n%s",
                "instruccion no valida",
                "para continuar S cualquier otro entrada para reingresar instruccion\n>");
    }

    public void terminarGuardado() {
        System.out.println("Su programa se ha guardado");
    }

    public void memoriaAgotada() {
        System.out.println("Se agoto el espacio en memoria");
    }

    public void errorCriticoEntrada() {
        System.out.printf("\n%s\n%s",
                "Erro critico",
                "Entrada invalida\n");
    }

    public void fueraDeRango() {
        System.out.printf("\n%s\n%s",
                "Error critico",
                "Capacidad de acumulador excedida\n");
    }

    public void divisionCero() {
        System.out.printf("\n%s\n%s",
                "Error critico",
                "Division entre cero\n");
    }

    public void programaCulminado() {
        System.out.println("La ejecucion del programa ha terminado");
    }

    public void instruccionDesconocida() {
        System.out.printf("\n%s\n%s",
                "Erro critico",
                "instruccion desconocida");
    }

    public void precargar(int entrada, int posicion) {
        codigo[posicion] = entrada;
    }

    public void cargar() {
        System.out.printf("\n%s\n%s",
                "          0       1       2       3       4       5       6       7       8       9",
                "   ________________________________________________________________________________\n");
        for (int i = 0; i < codigo.length; i = i + 10) {
            switch (i) {
                case 0:
                    System.out.print(" 0|");
                    break;
                case 10:
                    System.out.print(" 1|");
                    break;
                case 20:
                    System.out.print(" 2|");
                    break;
                case 30:
                    System.out.print(" 3|");
                    break;
                case 40:
                    System.out.print(" 4|");
                    break;
                case 50:
                    System.out.print(" 5|");
                    break;
                case 60:
                    System.out.print(" 6|");
                    break;
                case 70:
                    System.out.print(" 7|");
                    break;
                case 80:
                    System.out.print(" 8|");
                    break;
                case 90:
                    System.out.print(" 9|");
                    break;
            }
            for (int a= 0; a < 10; a++) {
                int b;
                b=i+a;
                if (codigo[b] >= 0) {
                    if (codigo[b] > 9) {
                        if (codigo[b] > 99) {
                            if (codigo[b] > 999) {
                                System.out.print("    " + codigo[b]);
                            } else {
                                System.out.print("     " + codigo[b]);
                            }
                        } else {
                            System.out.print("      " + codigo[b]);
                        }
                    } else {
                        System.out.print("       " + codigo[b]);
                    }
                } else {
                    if (codigo[b] <= 0) {
                        if (codigo[b] < -9) {
                            if (codigo[b] < -99) {
                                if (codigo[b] < -999) {
                                    System.out.print("   " + codigo[b]);
                                } else {
                                    System.out.print("    " + codigo[b]);
                                }
                            } else {
                                System.out.print("     " + codigo[b]);
                            }
                        } else {
                            System.out.print("      " + codigo[b]);
                        }
                    }
                }
            }

            System.out.println("");

        }

    }
    
    public void limpieza() {
        System.out.println("limpieza culminada");
    }

    public void ciao() {
        System.out.println("MAY THE FORCE DE WITH YOU");
    }
    
    public void ejecutando(){
        System.out.println("Ejecutando");
    }
    
    public void ayuda(){
        System.out.printf("\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                "\nSimpletron v 1.0",
                "los primeros dos digitos de cada instruccion ingresada indican una palabra",
                "los siguientes dos digitos la localizacion de memoria que se usara en caso",
                "que la palabra lo requiera",
                "palabras:",
                "   LEER          -10                                ESCIBIR        -11",
                "   CARGAR        -20                                ALMACENAR      -21",
                "   SUMAR         -30                                RESTAR         -31",
                "   DIVIDIR       -32                                MULTIPLICAR    -33",
                "   BIFURCAR      -40                                BIFURCARNEG    -41",
                "   BIFURCARCERO  -42                                ALTO           -43",
                "recordad que las operaciones se hacen al acumulador\n");
    }
    
    public void noHayPrograma(){
        System.out.println("No hay prograa guradado");
    }

}
