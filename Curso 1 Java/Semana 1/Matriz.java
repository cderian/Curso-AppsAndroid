/**
 * Semana 1. Práctica 1
 * Programa que consiste en crear, llenar y mostrar una matriz.
 * 
 * @author Derian Estrada
 */
public class Matriz {

    public static void main(String[] args) {
        int[] matriz = new int[16];
        int numero = 0;

        for (int i=0; i<matriz.length; i++) {
            numero+= 2;
            matriz[i] = numero;
        }

        for (int i=0; i<matriz.length; i+=4) {
            System.out.println(matriz[i] + " " + matriz[i+1] + " " + matriz[i+2] + " " + matriz[i+3]);
        }
    }
}