package GestionEstudiantes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestorEstudiantes gestor = new GestorEstudiantes();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(sc, "Elige una opcion: ");

            switch (opcion) {
                case 1:
                    registrarEstudiante(gestor, sc);
                    break;
                case 2:
                    gestor.listarEstudiantes();
                    break;
                case 3:
                    buscarEstudiante(gestor, sc);
                    break;
                case 4:
                    registrarCalificacion(gestor, sc);
                    break;
                case 5:
                    calcularPromedio(gestor, sc);
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intenta de nuevo.");
            }

        } while (opcion != 6);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE GESTION DE ESTUDIANTES =====");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Listar estudiantes");
        System.out.println("3. Buscar estudiante por codigo");
        System.out.println("4. Registrar calificacion");
        System.out.println("5. Calcular promedio de un estudiante");
        System.out.println("6. Salir");
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Error: debes ingresar un numero entero. Intenta de nuevo.");
            }
        }
    }

    private static double leerDecimal(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine();
            try {
                return Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                System.out.println("Error: debes ingresar un numero (puede tener decimales). Intenta de nuevo.");
            }
        }
    }
    // Pide un texto (código o nombre)
    private static String leerTexto(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Error: este campo no puede estar vacío. Intenta de nuevo.");
        }
    }
    
    private static String leerCodigo(Scanner sc, String mensaje) {
        while(true){
            System.out.print(mensaje);
            String texto = sc.nextLine().trim().toUpperCase();
            if (texto.matches("[A-Z]\\d{8}")) {
                return texto;
            }
            System.out.println("Error: el codigo debe tener una letra seguida de 8 digitos (ej. N00247732). Intenta de nuevo.");
        }
    }
    
     private static String leerCodigoDisponible(GestorEstudiantes gestor, Scanner sc, String mensaje) {
     while (true) {
         String codigo = leerCodigo(sc, mensaje);
         if (gestor.existeCodigo(codigo)) {
             System.out.println("Error: ya existe un estudiante registrado con el codigo " + codigo + ". Ingresa otro codigo.");
             continue;
         }
         return codigo;
     }
 }
    private static void registrarEstudiante(GestorEstudiantes gestor, Scanner sc) {
        String codigo = leerCodigoDisponible(gestor, sc, "Codigo del estudiante (ej. N00247732): ");
        String nombre = leerTexto(sc, "Nombre del estudiante: ");
        try {
            gestor.registrarEstudiante(codigo, nombre);
            System.out.println("Estudiante registrado correctamente.");
        } catch (EstudianteDuplicadoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void buscarEstudiante(GestorEstudiantes gestor, Scanner sc) {
        String codigo = leerCodigo(sc, "Codigo a buscar (ej. N00247732): ");
        try {
            Estudiante estudiante = gestor.buscarPorCodigo(codigo);
            System.out.println("Encontrado: " + estudiante);
        } catch (EstudianteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void registrarCalificacion(GestorEstudiantes gestor, Scanner sc) {
        String codigo = leerCodigo(sc, "Codigo del estudiante (ej. N00247732): ");
        while (true) {
            double nota = leerDecimal(sc, "Calificacion (0 - 20): ");
            try {
                gestor.registrarCalificacion(codigo, nota);
                System.out.println("Calificacion registrada correctamente.");
            }
            catch (EstudianteNoEncontradoException | LimiteCalificacionesException e) {
                System.out.println("Error: " + e.getMessage());
                return;
            }
            catch (CalificacionInvalidaException e) {
                System.out.println("Error: " + e.getMessage());
                continue;
            }
            int cantidad;
            try {
                cantidad = gestor.buscarPorCodigo(codigo).getCalificaciones().size();
            }
            catch (EstudianteNoEncontradoException e) {
                return;
            }
            if (cantidad >= 3) {
                System.out.println("Este estudiante ya alcanzo el maximo de 3 calificaciones.");
                return;
            }
            String respuesta = leerTexto(sc, "¿Deseas agregar otra calificacion para este estudiante? (S/N): ");
            if (!respuesta.equalsIgnoreCase("S")) {
                return;
            }
        }
    }

    private static void calcularPromedio(GestorEstudiantes gestor, Scanner sc) {
        String codigo = leerCodigo(sc, "Codigo del estudiante (ej. N00247732): ");
        try {
            double promedio = gestor.obtenerPromedio(codigo);
            System.out.printf("Promedio: %.2f%n", promedio);
        } catch (EstudianteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
