package es.etg.psp.model;

public interface Asientable {
    public static final String MSG_MALO_PREMUIM = "************* No se ha podido asignar asiento Premium*************";
    public static final String MSG_MALO_NORMAL = "************* No se ha podido asignar asiento Normal*************";
    public static final String MSG_MALO_LOW = "************* No se ha podido asignar asiento Low*************";
    public void mostrar();
    public boolean asignarPrem(String nombre, int edad,int cantidad);
    public boolean asignarNormal(String nombre, int edad,int cantidad);
    public boolean asignarLow(String nombre, int edad,int cantidad);
    public int calcularPuntos(String nombre);
}
