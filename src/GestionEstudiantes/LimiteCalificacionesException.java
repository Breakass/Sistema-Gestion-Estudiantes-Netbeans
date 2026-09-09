
package GestionEstudiantes;

// Excepcion cuando intenta ingresar mas de 3 notas
public class LimiteCalificacionesException extends Exception {
    public LimiteCalificacionesException(String mensaje) {
        super(mensaje);
    }
}
