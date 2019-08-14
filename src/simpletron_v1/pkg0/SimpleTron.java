/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletron_v1.pkg0;

import java.util.Scanner;

/**
 *
 * @author J
 */
public class SimpleTron {

    // entradas - salidas
    final int LEER = 10;
    final int ESCRIBIR = 11;
    // cargar - almacenar
    final int CARGAR = 20;
    final int ALMACENAR = 21;
    // aritmetica
    final int SUMAR = 30;
    final int RESTAR = 31;
    final int DIVIDIR = 32;
    final int MULTIPLICAR = 33;
    // control
    final int BIFURCAR = 40;
    final int BIFURCARNEG = 41;
    final int BIFURCARCERO = 42;
    final int ALTO = 43;

    Memoria memoria = new Memoria();
    Texto texto = new Texto();
    boolean hayprograma = false;

    Scanner scann = new Scanner(System.in);
    Scanner scanns = new Scanner(System.in);

    public void menu() {

        String selec;
        String c = "6";
        do {
            texto.inicioMenu();

            selec = scanns.nextLine();

            switch (selec) {
                case "1":
                    limpiar();
                    guardar();
                    break;
                case "2":
                    cargar();
                    break;
                case "3":
                    ejecutar();
                    break;
                case "4":
                    limpiar();
                    texto.limpieza();
                    break;
                case "5":
                    texto.ayuda();
                    break;
                case "6":
                    texto.ciao();
                    break;

                default:
                    texto.seleccionIncorrecta();
            }
        } while (!c.equals(selec));
    }

    private void guardar() {
        int entrada;
        int instruccion = 0;
        int campo = 0;
        String decision;
        boolean terminar = false;
        texto.inicioGuardado();
        for (int i = 0; i < 100; i++) {
            do {
                try {
                    texto.secuenciaInstruccion(i);
                    entrada = scann.nextInt();
                    if (entrada == 9999) {
                        terminar = true;
                        break;
                    } else {
                        if (entrada < 0) {
                            entrada = entrada * -1;
                            texto.convNeg(entrada);

                        }
                        instruccion = entrada / 100;
                        campo = entrada - (instruccion * 100);
                        if (verificarInstruccion(instruccion) || entrada > 9999 || entrada < -9999) {
                            if (instruccion == LEER || instruccion == ALMACENAR) {
                                if (verificarCampo(campo) || campo <= i) {
                                    texto.advertenciaCampo();
                                    decision = scanns.nextLine();
                                    if (decision.equals("S") || decision.equals("s")) {
                                        texto.aceptoAdvertencia();
                                        break;
                                    } else {
                                        texto.rechazoAdvertencia();
                                    }
                                } else {
                                    break;

                                }
                            } else {
                                break;
                            }
                        } else if (!verificarInstruccion(instruccion)) {
                            texto.instruccionNoValidaAdvertencia();
                            decision = scanns.nextLine();
                            if (decision.equals("S") || decision.equals("s")) {
                                texto.aceptoAdvertencia();
                                break;
                            } else {
                                texto.rechazoAdvertencia();
                            }
                        }else{
                            texto.instruccionNoValida();
                        }
                    }
                } catch (Exception e) {
                    scann.next();
                    texto.instruccionNoValida();
                    continue;
                }
            } while (true);
            if (terminar) {
                break;
            }
            memoria.guardar(entrada, i);
            if (instruccion == LEER) {
                memoria.guardarApartado(campo);
            }
        }
        if (terminar) {
            texto.terminarGuardado();
        } else {
            texto.memoriaAgotada();
        }
        hayprograma = true;
    }

    private void ejecutar() {
        int entrada;
        int campo;
        int instruccion;
        int acumulador = 0;
        boolean kill = false;
        boolean ciao = false;
        texto.ejecutando();
        if (hayprograma) {
            for (int i = 0; i < 100; i++) {
                instruccion = memoria.cubetas[i] / 100;
                campo = memoria.cubetas[i] - (instruccion * 100);
                System.out.print(i);
                switch (instruccion) {
                    case LEER:
                        System.out.print("<<");
                        try {
                            entrada = scann.nextInt();
                            if (acumulador > 9999 || acumulador < -9999) {
                                texto.fueraDeRango();
                                kill = true;
                                break;
                            }
                            memoria.cubetas[campo] = entrada;
                        } catch (Exception e) {
                            texto.errorCriticoEntrada();
                            kill = true;
                            scann.next();
                            break;
                        }
                        break;
                    case ESCRIBIR:
                        System.out.println(">>" + memoria.cubetas[campo]);
                        break;
                    case CARGAR:
                        acumulador = memoria.cubetas[campo];
                        System.out.println("-");
                        break;
                    case ALMACENAR:
                        memoria.cubetas[campo] = acumulador;
                        System.out.println("-");
                        break;
                    case SUMAR:
                        acumulador = acumulador + memoria.cubetas[campo];
                        if (acumulador > 9999 || acumulador < -9999) {
                            texto.fueraDeRango();
                            kill = true;
                        }
                        System.out.println("-");
                        break;
                    case RESTAR:
                        acumulador = acumulador - memoria.cubetas[campo];
                        if (acumulador > 9999 || acumulador < -9999) {
                            texto.fueraDeRango();
                            kill = true;
                        }
                        System.out.println("-");
                        break;
                    case DIVIDIR:
                        try {
                            acumulador = acumulador / memoria.cubetas[campo];
                        } catch (ArithmeticException e) {
                            texto.divisionCero();
                            kill = true;
                            break;
                        }
                        System.out.println("-");
                        break;
                    case MULTIPLICAR:
                        acumulador = acumulador * memoria.cubetas[campo];
                        if (acumulador > 9999 || acumulador < -9999) {
                            texto.fueraDeRango();
                            kill = true;
                        }
                        System.out.println("-");
                        break;
                    case BIFURCAR:
                        i = campo - 1;
                        System.out.println("-");
                        break;
                    case BIFURCARNEG:
                        if (acumulador < 0) {
                            i = campo - 1;
                        }
                        System.out.println("-");
                        break;
                    case BIFURCARCERO:
                        if (acumulador == 0) {
                            i = campo - 1;
                        }
                        System.out.println("-");
                        break;
                    case ALTO:
                        System.out.println("-");
                        texto.programaCulminado();
                        ciao = true;
                        System.out.println("-");
                        break;
                    default:
                        texto.instruccionDesconocida();
                        kill = true;
                }

                if (kill) {
                    for (int c = 0; c < memoria.cubetas.length; c++) {
                        texto.precargar(memoria.cubetas[i], i);
                    }
                    texto.cargar();
                    break;
                }
                if (ciao) {
                    break;
                }

            }
        } else {
            texto.noHayPrograma();
        }
    }

    private void cargar() {
        for (int i = 0; i < memoria.cubetas.length; i++) {
            texto.precargar(memoria.cubetas[i], i);
        }
        texto.cargar();
    }

    private void limpiar() {
        for (int i = 0; i < 100; i++) {
            memoria.cubetas[i] = 0;
        }
        for (int i = 0; i < 50; i++) {
            memoria.apartado[i] = 0;
        }
        hayprograma = false;
    }

    private boolean verificarInstruccion(int i) {
        boolean flag = false;
        if (i == LEER || i == ESCRIBIR || i == CARGAR || i == ALMACENAR || i == SUMAR || i == RESTAR || i == DIVIDIR || i == MULTIPLICAR || i == BIFURCAR || i == BIFURCARNEG || i == BIFURCARCERO || i == ALTO) {
            flag = true;
        }

        //boolean flag = true;
        return flag;
    }

    private boolean verificarCampo(int campo) {
        boolean flag = false;
        for (int i = 0; i < 50; i++) {
            if (campo == memoria.apartado[i]) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}
