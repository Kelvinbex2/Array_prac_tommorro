package es.etg.psp.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Evento implements Asientable {

    private Asiento[][] asientos;
    private int fila;
    private int columna;

    public Evento(int fila, int columna) {
        asientos = new Asiento[fila][columna];
        char letra = 'A';

        for (int i = 0; i < fila; i++) {
            int par = 2;
            int impar = 1;

            for (int j = 0; j < columna; j++) {
                if (j == columna / 2) {
                    asientos[i][j] = null;
                } else if (j < columna / 2) {
                    asientos[i][j] = new Asiento(impar + String.valueOf(letra));
                    impar += 2;
                } else {
                    asientos[i][j] = new Asiento(par + String.valueOf(letra));
                    par += 2;
                }
            }

            letra++;

        }
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }

    @Override
    public void mostrar() {
        for (Asiento[] asientos2 : asientos) {
            for (Asiento asiento : asientos2) {
                System.out.print(asiento == null ? "         " : asiento.toString());
            }
            System.out.println();
        }
    }

    @Override
    public boolean asignarPrem(String nombre, int edad, int cantidad) {
        int puntosInicial = 30;
        int precioTotal = puntosInicial * cantidad;

        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (asientos[i][j] != null && !asientos[i][j].isOcupado()) {
                    asientos[i][j].setPuntos(precioTotal);
                    asientos[i][j].asignar(nombre, edad);
                    System.out.println(
                            "Asiento (Premium)" + asientos[i][j].getId() + " asignado a <" + nombre + "> por "
                                    + puntosInicial);
                    return true;

                }
            }
        }
        System.out.println(MSG_MALO_PREMUIM);
        return false;
    }

    @Override
    public boolean asignarNormal(String nombre, int edad, int cantidad) {
        int puntosInicial = 20;
        int precioTotal = puntosInicial * cantidad;

        for (int i = 2; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (asientos[i][j] != null && !asientos[i][j].isOcupado()) {
                    asientos[i][j].setPuntos(precioTotal);
                    asientos[i][j].asignar(nombre, edad);
                    System.out.println(
                            "Asiento (Normal)" + asientos[i][j].getId() + " asignado a <" + nombre + "> por "
                                    + puntosInicial);
                    return true;

                }
            }
        }
        System.out.println(MSG_MALO_NORMAL);
        return false;
    }

    @Override
    public boolean asignarLow(String nombre, int edad, int cantidad) {

        int puntosInicial = 20;
        int precioTotal = puntosInicial * cantidad;

        for (int i = asientos.length - 1; i >= 0; i--) {
            for (int j = asientos[i].length - 1; j >= 0; j--) {
                if (asientos[i][j] != null && !asientos[i][j].isOcupado()) {
                    asientos[i][j].setPuntos(precioTotal);
                    asientos[i][j].asignar(nombre, edad);
                    System.out.println(
                            "Asiento (Low-Cost)" + asientos[i][j].getId() + " asignado a <" + nombre + "> por "
                                    + puntosInicial);
                    return true;

                }
            }
        }
        System.out.println(MSG_MALO_LOW);
        return false;
    }

    @Override
    public int calcularPuntos(String nombre) {
        try {
            for (Asiento[] asientos2 : asientos) {
                for (Asiento asiento : asientos2) {
                    if (asiento != null && asiento.isOcupado() && asiento.getNombre().equals(nombre)) {
                        return asiento.getPuntos();
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return 0;
    }

    public void generarTicket() throws IOException {
        File file = new File("Ticket.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            for (Asiento[] asien : asientos) {
                for (Asiento asiento : asien) {
                    if (asiento != null && asiento.getNombre()!=null) {
                        bw.write(asiento.getNombre() + System.lineSeparator());
                        bw.write(asiento.getEdad() + System.lineSeparator());
                        bw.write(asiento.getPuntos() + System.lineSeparator());
                        bw.write(System.lineSeparator());
                        
                    }

                }
            }

            for (int i = 0; i < asientos.length; i++) {
                
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
