package GestionEstudiantes;

// Excepcion cuando una nota está fuera del rango
public class CalificacionInvalidaException extends Exception {

    public CalificacionInvalidaException(String mensaje) {
        super(mensaje);
    }
}
