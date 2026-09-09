/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestionEstudiantes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Administra la colección de estudiantes del sistema (versión simplificada)
 */
public class GestorEstudiantes {

    private final Map<String, String> estudiantes = new LinkedHashMap<>();

    public String registrarEstudiante(String codigo, String nombre) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return "Error: El código no puede estar vacío";
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            return "Error: El nombre no puede estar vacío";
        }
        
        String codigoNormalizado = codigo.trim();
        if (estudiantes.containsKey(codigoNormalizado)) {
            return "Error: El estudiante con código " + codigoNormalizado + " ya existe";
        }

        estudiantes.put(codigoNormalizado, nombre.trim());
        return "Estudiante registrado con éxito: " + codigoNormalizado + " - " + nombre.trim();
    }

    public List<String> listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            return Collections.emptyList();
        }
        
        List<String> lista = new ArrayList<>();
        for (Map.Entry<String, String> entry : estudiantes.entrySet()) {
            lista.add(entry.getKey() + " - " + entry.getValue());
        }
        return Collections.unmodifiableList(lista);
    }

    public String buscarEstudiante(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return "Error: Código no válido";
        }
        
        String nombre = estudiantes.get(codigo.trim());
        if (nombre == null) {
            return "Error: Estudiante con código " + codigo + " no encontrado";
        }
        return "Estudiante encontrado: " + codigo.trim() + " - " + nombre;
    }

    public String registrarCalificacion(String codigo, double nota) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return "Error: Código no válido";
        }
        
        if (!estudiantes.containsKey(codigo.trim())) {
            return "Error: Estudiante con código " + codigo + " no encontrado";
        }

        if (nota < 0 || nota > 20) {
            return "Error: La calificación debe estar entre 0 y 20";
        }

        return "Calificación " + nota + " registrada para el estudiante " + codigo.trim();
    }

    public String calcularPromedio(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return "Error: Código no válido";
        }
        
        if (!estudiantes.containsKey(codigo.trim())) {
            return "Error: Estudiante con código " + codigo + " no encontrado";
        }

        // Simulación de promedio (en versión real se calcularía con las calificaciones)
        double promedio = 15.0; // Valor simulado
        return "Promedio del estudiante " + codigo.trim() + ": " + String.format("%.2f", promedio);
    }

    public boolean existeCodigo(String codigo) {
        if (codigo == null) {
            return false;
        }
        return estudiantes.containsKey(codigo.trim());
    }

    public int totalEstudiantes() {
        return estudiantes.size();
    }
}