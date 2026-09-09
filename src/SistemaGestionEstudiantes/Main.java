/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SistemaGestionEstudiantes;

import java.util.Scanner;

/**
 * Programa principal simplificado
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            String opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1" -> System.out.println("Opción 1: Registrar estudiante");
                case "2" -> System.out.println("Opción 2: Listar estudiantes");
                case "3" -> System.out.println("Opción 3: Buscar estudiante");
                case "4" -> System.out.println("Opción 4: Registrar calificación");
                case "5" -> System.out.println("Opción 5: Calcular promedio");
                case "6" -> {
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Opcion invalida. Intenta de nuevo.");
            }
            System.out.println();
        }

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("========== SISTEMA DE GESTION DE ESTUDIANTES ==========");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Listar estudiantes");
        System.out.println("3. Buscar estudiante por codigo");
        System.out.println("4. Registrar calificacion");
        System.out.println("5. Calcular promedio");
        System.out.println("6. Salir");
        System.out.print("Elige una opcion: ");
    }
}