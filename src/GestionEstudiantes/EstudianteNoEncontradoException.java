package GestionEstudiantes;

// Excepcion cuando se busca un código que no existe
public class EstudianteNoEncontradoException extends Exception {

    public EstudianteNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
