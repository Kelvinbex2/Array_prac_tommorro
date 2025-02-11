package es.etg.psp.model;

public class Asiento {
    private String nombre;
    private int edad;
    private String id;
    private boolean ocupado;
    private int puntos;

    

    public Asiento(String id) {
        this.id = id;
        this.ocupado = false;
    }

    public void asignar(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ocupado = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return ocupado ? id +"(Ocupado) " : id + "(Libre) ";
    }
}