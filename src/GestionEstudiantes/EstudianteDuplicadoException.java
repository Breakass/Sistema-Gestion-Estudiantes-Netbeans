package GestionEstudiantes;

// Excepcion cuando se intenta registrar un código que ya existe
public class EstudianteDuplicadoException extends Exception {

    public EstudianteDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
