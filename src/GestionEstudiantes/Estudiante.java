package GestionEstudiantes;

import java.util.ArrayList;

public class Estudiante {
    private String codigo;
    private String nombre;
    private ArrayList<Double> calificaciones;

    public Estudiante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.calificaciones = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Double> getCalificaciones() {
        return calificaciones;
    }

    // Validamos que esté en el rango (0 - 20)
    public void agregarCalificacion(double nota) throws CalificacionInvalidaException {
        if (nota < 0 || nota > 20) {
            throw new CalificacionInvalidaException(
                "La calificacion " + nota + " esta fuera del rango permitido (0 - 20).");
        }
        calificaciones.add(nota);
    }

    // Calculo de promedio de las calificaciones
    public double calcularPromedio() {
        if (calificaciones.isEmpty()) {
            return 0.0;
        }
        double suma = 0;
        for (double nota : calificaciones) {
            suma += nota;
        }
        return suma / calificaciones.size();
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " (promedio: " + String.format("%.2f", calcularPromedio()) + ")";
    }

}
