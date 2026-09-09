/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestionEstudiantes;

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

    public void agregarCalificacion(double nota) {
        calificaciones.add(nota);
    }

    public double calcularPromedio() {
        if (calificaciones.isEmpty()) {
            return 0;
        }

        double suma = 0;

        for (double nota : calificaciones) {
            suma += nota;
        }

        return suma / calificaciones.size();
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo
                + " | Nombre: " + nombre
                + " | Promedio: " + calcularPromedio();
    }
}
