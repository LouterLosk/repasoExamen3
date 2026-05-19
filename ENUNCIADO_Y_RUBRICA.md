# Evaluación del Progreso - Programación III

## Sistema de Gestión Académica

Implementar un sistema visual en Java Swing para administrar estudiantes usando `ArrayList`, búsquedas, ordenamientos manuales y métodos recursivos.

El ejercicio toma como base la evaluación anterior de inventario de productos, donde se solicitaba trabajar con `ArrayList`, unicidad por ID, búsquedas, ordenamientos propios, Swing y GitHub.

## Clases requeridas

### `Estudiante`

Atributos:

- `codigo` int, único.
- `nombre` String.
- `carrera` String.
- `promedio` double.

Debe incluir:

- Constructor.
- Getters y setters.
- `toString()`.

### `GestionEstudiantes`

Debe usar:

```java
ArrayList<Estudiante>
```

Debe precargar 5 estudiantes y contener toda la lógica del sistema.

Métodos mínimos:

- `agregarEstudiante(Estudiante estudiante)`
- `buscarPorNombreSecuencial(String nombre)`
- `ordenarPorPromedioDescendente()`
- `buscarPorCodigoBinario(int codigo)`
- `contarRecursivo(int indice)`
- `sumaPromediosRecursiva(int indice)`
- `promedioGeneralRecursivo()`


No se permite usar:

- `Collections.sort()`
- `Collections.binarySearch()`

## Interfaz Swing

Crear una ventana con `JTabbedPane`.

### Pestaña 1: Registro

Debe permitir:

- Agregar estudiante usando `JSpinner`, `JTextField`, `JComboBox` y botón.
- Validar código único antes de agregar.
- Mostrar estudiantes en `JList`.

### Pestaña 2: Búsqueda y ordenamiento

Debe permitir:

- Ordenar por promedio descendente.
- Ordenar por código ascendente.
- Buscar por código con búsqueda binaria.
- Buscar por nombre con búsqueda secuencial.
- Mostrar resultados en un segundo `JList`.

### Pestaña 3: Recursividad

Debe mostrar:

- Total de estudiantes calculado recursivamente.
- Promedio general calculado con suma recursiva.
- Mayor promedio calculado recursivamente.

## Rúbrica sobre 10 puntos

| Criterio | Puntaje |
|---|---:|
| Uso correcto de `ArrayList`, precarga de datos y validación de código único | 1.0 |
| Búsqueda secuencial por nombre y validación de existencia | 1.0 |
| Búsqueda binaria por código sobre lista ordenada | 1.0 |
| Ordenamientos manuales por promedio descendente y código ascendente | 1.5 |
| Métodos recursivos: contar, sumar/promediar y hallar mayor promedio | 1.5 |
| Interfaz Swing con `JTabbedPane`, formularios, `JList` y mensajes al usuario | 2.0 |
| Integración correcta entre Swing y `GestionEstudiantes`, sin lógica principal en la ventana | 2.0 |
| **Total** | **10.0** |

## Distribución solicitada

- Implementación de métodos: 6 puntos.
- Interfaz Swing e integración con clases: 4 puntos.

## Autograding GitHub Classroom

El repositorio incluye:

- Pruebas JUnit 5 en `src/test/java`.
- Workflow en `.github/workflows/classroom.yml`.
- Configuración en `.github/classroom/autograding.json`.

```
