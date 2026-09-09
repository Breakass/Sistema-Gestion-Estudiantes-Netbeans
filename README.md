# Sistema Gestión Estudiantes (NetBeans)


Proyecto base de NetBeans (Ant), listo para que el equipo agregue las clases del sistema de gestión de estudiantes.

## Estructura

```
src/SistemaGestionEstudiantes/   <- Paquete Java donde van las clases (vacío por ahora)
nbproject/                        <- Configuración del proyecto NetBeans
build.xml, manifest.mf            <- Configuración de compilación (Ant)
```

## Cómo empezar

## Estado actual del proyecto

Actualmente el repositorio cuenta con la rama principal `main` y una rama de trabajo activa:

- `main` — contiene la estructura base del proyecto NetBeans.
- `feature/estudiante` — rama creada para el desarrollo de la clase `Estudiante`.

La documentación se irá actualizando de acuerdo con el avance real del código y los aportes de cada integrante.

## Avance por ramas

### main

Contiene la estructura inicial del proyecto:

- `src/`
- `nbproject/`
- `build.xml`
- `manifest.mf`
- `README.md`
- `.gitignore`

### feature/estudiante

Rama destinada al desarrollo de la entidad `Estudiante`.

Esta clase será responsable de representar los datos principales del estudiante dentro del sistema.

## Próximos avances

A medida que el equipo implemente nuevas funcionalidades, se documentarán aquí:

- Clase `Estudiante`
- Clase `GestorEstudiantes`
- Reglas de negocio
- Manejo de excepciones
- Menú principal
- Registro de calificaciones
- Cálculo de promedio
- Pruebas básicas

## Control de versiones

El equipo trabajará mediante ramas individuales para mantener separados los aportes de cada integrante.

Cada cambio será registrado mediante commits descriptivos y posteriormente integrado a la rama `main` mediante Pull Requests.

## Cómo ejecutar el proyecto

1. Clonar el repositorio.
2. Abrir el proyecto en NetBeans.
3. Ejecutar la clase principal cuando esté implementada.
