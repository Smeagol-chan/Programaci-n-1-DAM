# Práctica 1: El Formiguero contra La Rebelión

## Índice
1. [Intro](#1-intro)
2. [Estructura de clases](#2-estructura-de-clases)
3. [Programa principal](#3-programa-principal)
4. [Pruebas](#4-pruebas)
5. [Entregas](#5-entregas)

### 1. Intro
<p>
    El mundo de la televisión últimamente parece estar en guerra. Algunos “se rebelan” contra otros, en
    directo, los otros desmienten las informaciones… Y los telespectadores, lejos de analizarlo de forma
    crítica, se hacen palomitas para ver según qué programa en función de su ideología.
</p>
<p>
    Jordi está harto de la división entre “las dos Españas”, y decide intentar poner un poco de paz creando
    una aplicación que recoja datos diarios sobre estos programas para dar objetividad a las distintas
    informaciones que van apareciendo. 
</p>

#### 1.1. Problema a resolver

Se pide que se creen cuatro clases para almacenar la información de los programas que cada cadena de televisión pueda contener, junto con el diagrama UML correspondiente. Las clases son:
- Cadena
- Programa
- Empleado
- Invitado

Además, he introducido la clase _FuncionesComunes_ para ayudar en la resolución del problema.

### 2. Estructura de clases
![](../Introduccion_OOP/src/main/java/org/example/inmobiliaria/media/inmobiliaria.png)

#### Código de PlantUML
<code>
@startuml

package "org.example.inmobiliaria" {

    class Casa {
        - String direccion
        - ArrayList<Habitacion> listaHabitaciones
        - Propietario propietario

        + void crearHabitacion(String nombre, double metros)
        + void eliminarHabitacion(String nombre)
        + void mostrarHabitaciones()
        + Habitacion habitacionMasGrande()
        + void mostrarConsumoMayor()
        + double calcularConsumoGeneral()
    }

    class Habitacion {
        - String nombre
        - double metros
        - ArrayList<Electrodomestico> listaElectrodomesticos

        + void crearElectrodomestico(String nombre, double consumo)
        + void eliminarElectrodomestico(String nombre)
        + void mostrarElectrodomesticos()
        + double calcularConsumo()
    }

    class Electrodomestico {
        - String nombre
        - double consumo
    }

    class Propietario {
        - String nombre
        - int edad
    }

    Casa "1" *-- "many" Habitacion : contiene >
    Habitacion "1" *-- "many" Electrodomestico : incluye >
    Casa "1" --> "1" Propietario : pertenece a >
}

@enduml
</code>
### 3. Programa principal

### 4. Pruebas

### 5. Entregas
- [X] Código fuente en GitHub
- [X] Documentación
- [ ] Pruebas
