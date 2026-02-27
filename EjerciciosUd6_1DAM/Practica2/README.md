# Práctica 1: Sistema de pago para un e-commerce

## Índice
1. [Intro](#1-intro)
  1.1. [Problema a resolver](#11-problema-a-resolver)
2. [Estructura de clases](#2-estructura-de-clases)
  2.1. [UML](#21-uml)
3. [Programa](#3-programa)
  3.1. [AppMutxamel](#31-appmutxamel)
  3.2. [Mantenimiento](#32-mantenimiento)
  3.3. [Miembros](#33-miembros)
    3.3.1. [MutxamelFC](#331-mutxamelfc)
    3.3.2. [Jugador](#332-jugador)
    3.3.3. [Entrenador](#333-entrenador)
    3.3.4. [Masajista](#334-masajista)
    3.3.5. [Acompanante](#335-acomapanante)
  3.4. [Enums](#34-enums)
  3.5. [Excepciones](#35-excepciones)
  3.6. [Acciones](#36-acciones)
    3.6.1. [FuncionesIntegradas](#361-funcionesintegradas)
    3.6.2. [AccionesDeportivas](#362-accionesdeportivas)
  3.7. [FuncionesComunes](#37-funcionescomunes)
4. [Prueba de errores](#4-prueba-de-errores)

## 1. Intro

El azar ha hecho que al MUTXAMEL FC le toque el Real Madrid en las primeras rondas de la Copa del Rey. Por eso, el club ha emitido un comunicado para contar que va a
empezar un proceso de modernización en cuanto a su organización para que no parezca que sea un “equipillo” cualquiera, y ver si así la visita al Bernabéu hace que
Florentino se interese un poco por ellos.

### 1.1. Problema a resolver

Se pide implementar las funcionalidades del diagrama UML dado:
![](assets/diagrama_profe.png)

## 2. Estructura de clases

El diagrama de clases que estructora el programa se ha realizado en PlantUML.

### 2.1. UML

A continuación se muestra el diagrama UML. Para ver el código en PlantUML pinche [aquí](src/main/java/org/example/MutxamelFC.puml).  
![](assets/MutxamelFC_pml.png)

## 3. Programa

El programa consiste en cinco clases (una abstracta y el resto comunes) encargadas de construir los objetos, dos enums, excepciones cinco personalizadas y una clase que alberga toda la funcionalidad.

Para ver una descripción en detalle de cada método presente en el programa, acceda al [JavaDoc](javadoc.zip).

### 3.1. AppMutxamel - [código](src/main/java/org/example/AppMutxamel.java)

Clase que alberga el método main().  
Invoca al procedimiento para inicializar la lista de miembros del club y al menú principal del programa.



### 3.7. FuncionesComunes - [código](src/main/java/org/example/FuncionesComunes.java)

Clase que contiene métodos de uso común en las prácticas y ejercicios que se han ido realizando desde inicio de curso. Para esta práctica se ha empleado para solicitar números, chars y Strings al usuario.

## 4. Prueba de errores

La prueba de errores se ha realizado con un vídeo explicativo.

