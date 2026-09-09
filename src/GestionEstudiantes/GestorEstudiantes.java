package GestionEstudiantes;

import java.util.LinkedHashMap;
import java.util.Map;

public class GestorEstudiantes {

    //// LinkedHashMap conservamos el orden de los alumnos agregados
    private Map<String, Estudiante> estudiantes = new LinkedHashMap<>();

    public void registrarEstudiante(String codigo, String nombre) throws EstudianteDuplicadoException {
        if (estudiantes.containsKey(codigo)) {
            throw new EstudianteDuplicadoException(
                "Ya existe un estudiante registrado con el codigo " + codigo + ".");
        }
        estudiantes.put(codigo, new Estudiante(codigo, nombre));
    }
    //valida que no se agregue mas informacion si el codigo se repite
    public boolean existeCodigo(String codigo) {
        return estudiantes.containsKey(codigo);
    }
    public Estudiante buscarPorCodigo(String codigo) throws EstudianteNoEncontradoException {
        Estudiante estudiante = estudiantes.get(codigo);
        if (estudiante == null) {
            throw new EstudianteNoEncontradoException(
                "No existe un estudiante con el codigo " + codigo + ".");
        }
        return estudiante;
    }

    public void registrarCalificacion(String codigo, double nota)
            throws EstudianteNoEncontradoException, CalificacionInvalidaException, LimiteCalificacionesException {
        Estudiante estudiante = buscarPorCodigo(codigo);
        estudiante.agregarCalificacion(nota);
    }

    public double obtenerPromedio(String codigo) throws EstudianteNoEncontradoException {
        return buscarPorCodigo(codigo).calcularPromedio();
    }

    public void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        int contador = 1;
        for (Estudiante e : estudiantes.values()) {
            System.out.println(contador + ". " + e);
            contador++;
        }
                
    }
}
