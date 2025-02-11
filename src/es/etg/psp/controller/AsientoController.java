package es.etg.psp.controller;

import es.etg.psp.model.Evento;

public class AsientoController {
    public boolean vender(String tipo, String nombre, int edad, int cantidad, Evento en) {
        try {
            int cantidadEntrada = 0;

            switch (tipo.toLowerCase()) {
                case "p":
                    while (cantidadEntrada < cantidad) {
                        if (!en.asignarPrem(nombre, edad, cantidad)) {
                            return false;
                        }
                        cantidadEntrada++;
                    }

                    return true;

                case "n":
                    while (cantidadEntrada < cantidad) {
                        if (!en.asignarNormal(nombre, edad, cantidad)) {
                            return false;
                        }
                        cantidadEntrada++;
                    }

                    return true;

                case "l":

                    while (cantidadEntrada < cantidad) {
                        if (!en.asignarLow(nombre, edad, cantidad)) {
                            return false;
                        }
                        cantidadEntrada++;
                    }

                    return true;
                default:
                    System.out.println("Opcion no valida!!!!!!!!!!!!");
                    break;
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return false;

    }

    public void mostrar(Evento en) {
        en.mostrar();
    }

    public int calcularPrecio(Evento en, String nombre) {
        

        return en.calcularPuntos(nombre);
    }

}
