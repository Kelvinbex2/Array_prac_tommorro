package es.etg.psp.model.entrada;

import java.util.Scanner;

public class Entrada {
    public final static Scanner scan = new Scanner(System.in);

    public int leerNum() {
        int num = 0;
        boolean esValido = false;
        while (!esValido) {
            try {
                num = scan.nextInt();
                if (num < 0) {
                    esValido = false;
                    throw new Exception("Este campo no debe contener numero menor que 0 o letras");
                } else {
                    esValido = true;
                }
            } catch (Exception e) {
                System.out.print("Escribe un numero valido: ");
                esValido = false;
            } finally {
                scan.nextLine();
            }
        }
        return num;
    }

    public String leer() {
        String cadena = "";
        boolean esValido = false;
        while (!esValido) {
            try {
                cadena = scan.nextLine();
                if (cadena.matches(".*[\\d].*")) {
                    esValido = false;
                    throw new Exception("Este campo no debe contener numeros");
                } else {
                    esValido = true;
                }
            } catch (Exception e) {
                System.out.print("Escribe un numero valido: ");
                esValido = false;
            } 
        }
        return cadena;
    }
}
