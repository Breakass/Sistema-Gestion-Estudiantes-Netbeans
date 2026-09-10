# Sistema Gestión Estudiantes (NetBeans)

Sistema de gestión de estudiantes desarrollado en Java utilizando Apache NetBeans.

El proyecto permite registrar estudiantes, buscar estudiantes, registrar calificaciones y calcular el promedio de sus notas.

## Estructura del proyecto

El código fuente se encuentra en el paquete:

`src/GestionEstudiantes/`

Actualmente el proyecto contiene las siguientes clases:

- `Main.java` - contiene el menú principal y permite interactuar con el sistema.
- `GestorEstudiantes.java` - administra el registro, búsqueda y gestión de estudiantes.
- `Estudiante.java` - representa al estudiante y almacena sus datos y calificaciones.
- `CalificacionInvalidaException.java` - controla el ingreso de calificaciones no válidas.
- `EstudianteDuplicadoException.java` - controla el registro de estudiantes con código duplicado.
- `EstudianteNoEncontradoException.java` - controla la búsqueda de estudiantes que no existen.
- `LimiteCalificacionesException.java` - controla el límite máximo de calificaciones permitidas por estudiante.

## Funcionalidades

El sistema permite:

- Registrar estudiantes mediante un código y nombre.
- Listar los estudiantes registrados.
- Buscar estudiantes por código.
- Registrar calificaciones.
- Validar las calificaciones ingresadas.
- Registrar hasta 3 calificaciones por estudiante.
- Calcular el promedio de las calificaciones.
- Controlar códigos de estudiantes duplicados.
- Informar cuando un estudiante no se encuentra registrado.

## Validaciones

El sistema cuenta con validaciones para evitar errores durante el ingreso de información.

El código del estudiante debe tener el formato de una letra seguida de 8 dígitos.

Ejemplo:

`N00247732`

Las calificaciones ingresadas son verificadas antes de ser registradas y cada estudiante puede almacenar como máximo 3 calificaciones.

## Manejo de excepciones

Para controlar situaciones especiales se implementaron excepciones personalizadas:

- `CalificacionInvalidaException`
- `EstudianteDuplicadoException`
- `EstudianteNoEncontradoException`
- `LimiteCalificacionesException`

Estas excepciones permiten mostrar mensajes claros al usuario cuando se produce un ingreso incorrecto o una operación no permitida.

## Trabajo colaborativo con Git

El proyecto se desarrolla utilizando ramas de Git para separar el trabajo de los integrantes.

Entre las ramas utilizadas se encuentran:

- `main` - versión integrada del proyecto.
- `desarrollador1` - desarrollo de componentes del sistema.
- `desarrollador2` - desarrollo de la clase Estudiante y excepciones.
- `Documentacion` - actualización y mantenimiento de la documentación.

Los cambios realizados en las ramas de trabajo se integran posteriormente mediante Pull Requests.

## Estado actual del proyecto

Actualmente las clases principales y las excepciones se encuentran integradas en `main`.

El proyecto compila correctamente en NetBeans y se han realizado pruebas de registro de estudiantes, validación de códigos, registro de calificaciones y cálculo de promedios.

La documentación se mantiene actualizada de acuerdo con el avance del proyecto.