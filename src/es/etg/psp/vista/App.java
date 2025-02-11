package es.etg.psp.vista;


import java.io.IOException;

import es.etg.psp.controller.AsientoController;

import es.etg.psp.model.Evento;
import es.etg.psp.model.entrada.Entrada;

public class App extends Entrada {
    public static void main(String[] args) throws Exception {
        Evento en = new Evento(9, 20);
        AsientoController asien = new AsientoController();
        new App().mostrar(asien, en);

    }

    public void mostrar(AsientoController asien, Evento evento) throws IOException {

        int opc = 0;
        do {
            System.out.print("1.Mostrar sillas\n2.Comprar asientos\nElige una opcion: ");
            opc = leerNum();

            switch (opc) {
                case 1:
                    asien.mostrar(evento);
                    break;

                case 2:
                    gestionarVenta(asien, evento);
                    break;

                case 0:
                    System.out.println("Adios!!!!!!!!!!");
                    evento.generarTicket();
                    break;
                default:
                    break;
            }
        } while (opc != 0);
    }

    public void gestionarVenta(AsientoController asien, Evento evento) throws IOException {

        System.out.print("Nombre: ");
        String nombre = leer();
        System.out.print("Edad: ");
        int edad = leerNum();
        System.out.print("Tipo: ");
        String tipo = leer().toLowerCase();
        while (!tipo.matches(".*[pnl].*")) {
            System.out.print("Tiene que ser\n1.P\n2.N\n3.L\nTipo: ");
            tipo = leer().toLowerCase();
        }
        System.out.print("Cantidad: ");
        int cantidad = leerNum();

        if (asien.vender(tipo, nombre, edad, cantidad, evento)) {
            int precio = asien.calcularPrecio(evento, nombre);
           
            System.out.println("Con el precio total " + precio);
        }
    }

    

    

}
