# Práctica 1: Sistema de pago para un e-commerce

## Índice
1. [Intro](#1-intro)
1.1. [Problema a resolver](#11-problema-a-resolver)
2. [Estructura de clases](#2-estructura-de-clases)
2.1. [UML](#21-uml)
3. [Programa](#3-programa)
3.1. [AppEcommerce](#31-appecommerce)
3.2. [Tienda](#32-tienda)
3.3. [MetodoPago](#33-metodopago)
3.4. [TarjetaCredito](#34-tarjetacredito)
3.5. [PayPal](#35-paypal)
3.6. [Bizum](#36-bizum)
3.7. [FuncionesComunes](#37-funcionescomunes)
4. [Prueba de errores](#4-prueba-de-errores)
4.1. [Pruebas sobre Tienda](#41-pruebas-sobre-tienda)
4.2. [Pruebas sobre TarjetaCredito](#42-pruebas-sobre-tarjetacredito)
4.3. [Pruebas sobre PayPal](#43-pruebas-sobre-paypal)
4.4. [Pruebas sobre Bizum](#44-pruebas-sobre-bizum)

## 1. Intro

El profe turronero de Lenguaje de Marcas os ha contado tantas cosas sobre comercio online que os ha
convencido: vais a crear un sitio web para estudiantes de programación que se dedique a vender cursos
sobre tecnologías varias.

### 1.1. Problema a resolver

Se pide realizar un programa que cree un método de pago de los tres tipo válidos: tarjeta de crédito, Bizum y PayPal.  
Se trata de una práctica de OOP (Programación Orientada a Objetos), donde se requiere emplear abstracción y polimorfismo para su resolución. Por lo tanto, a parte de las tres clases anteriores, 
hay que crear una clase madre a la que pertenecerán.  
El programa final ha de validar los datos de cada método de pago y permitir una transacción si es correcto.

## 2. Estructura de clases

El diagrama de clases que estructora el programa se ha realizado en PlantUML.

### 2.1. UML

A continuación se muestra el diagrama UML. Para ver el código en PlantUML pinche [aquí](src\main\java\org\example\Ecommerce.puml).  
![](media\Ecommerce.png)

## 3. Programa

El programa consiste en seis clases principales:
- **AppEcommerce**: Contiene el main.
- **Tienda**: Se encarga de llamar a los métodos pertinentes.
- **MetodoPago**: Clase madre del resto de objetos.
- **TarjetaCredito**, **PayPal** y **Bizum**: Clases hijas que construyen los objetos.

Además, hay presente una séptima clase: **FuncionesComunes**.  

Para ver una descripción en detalle de cada método presente en el programa, acceda al [JavaDoc](javadoc.zip).

### 3.1. AppEcommerce

Es la clase que inicia el programa. Únicamente contiene el método main, el cual invoca a iniciarPago() en Tienda.  
Pinche [aquí](src\main\java\org\example\AppEcommerce.java) para ver el código de AppEcommerce.

### 3.2. Tienda

Se trata de la clase encargada de solicitar los datos pertinentes al usuario y de llamar a los constructores de cada objeto.  

Comienza solicitando al usuario que introduzca un método de pago (tarjeta, Bizum o Paypal). Filtra el String introduzido en un switch y llama a la función encargada de solicitar los datos 
para crear el método de pago seleccionado. Con los datos se crea el objeto pertinente y se valida lo introducido. Se muestra por la consola si la transacción ha resultado exitosa o no, 
dependiendo de si los datos son válidos.  

Para no repetir código se emplea polimorfismo en los objetos. Se ve con más claridad dentro de la clase madre: MetodoPago.

Pinche [aquí](src\main\java\org\example\comercios\Tienda.java) para ver el código de Tienda.

### 3.3. MetodoPago

Esta es la clase madre a la que pertenecen TarjetaCredito, PayPal y Bizum.  

Se trata de una clase abstracta sin atributos pero con con métodos también abstractos:
- **validarMetodo**: Función booleana que confirma si los atributos del objeto son válidos.
- **procesarPago**: Procedimiento que muestra si el pago ha sido realizado con éxito.

Estos dos métodos son abstractos y han de estar presentes en todas las clases hijas. Cada objeto altera el comportamiento de los métodos por lo que, cuando se invoca desde Tienda, 
el proceso será diferente dependiendo del objeto llamado.  
Esta es la característica principal del polimorfismo. Declarando un objeto de tipo MetodoPago pero llamando al constructor de una de sus clases hijas (ejempo: MetodoPago x = new Bizum()) 
se puede acceder a todo lo que la madre es capaz de hacer. Puesto que los métodos abstractos han sido alterados por sus hijas, el resultado es personalizado a cada subclase.  

Pinche [aquí](src\main\java\org\example\parasela_pago\MetodoPago.java) para ver el código de Tienda.

### 3.4. TarjetaCredito

Subclase de MetodoPago.  
Sus atributos son el número de la tarjeta (nro__tarjeta) y el tipo y valida que el número cuente con 16 cifras y el tipo sea Visa, Mastercard o Maestro.  

Pinche [aquí](src\main\java\org\example\parasela_pago\TarjetaCredito.java) para ver el código de TarjetaCredito.

### 3.5. PayPal

Subclase de MetodoPago.  
Sus atributos son el email de la cuenta (cuenta) y el saldo, quien es inicializado con un valor por defecto. Además, valida que email respete el formato.  

Pinche [aquí](src\main\java\org\example\parasela_pago\PayPal.java) para ver el código de PayPal.

### 3.6. Bizum

Subclase de MetodoPago.  
Sus atributos son el pin, un número de 6 cifras del 0 al 9 generado automáticamente, y el teléfono, que más tarde se valida si se trata de una cadena de números de 9 cifras.  

Pinche [aquí](src\main\java\org\example\parasela_pago\Bizum.java) para ver el código de Bizum

### 3.7. FuncionesComunes

Clase que contiene métodos de uso común en las prácticas y ejercicios que se han ido realizando desde inicio de curso. Para esta práctica se ha empleado para solicitar números y cadenas 
de caracteres al usuario, generar números aleatorios y comparar valores numéricos.  

Pinche [aquí](src\main\java\org\example\FuncionesComunes.java) para ver el código de FuncionesComunes.

## 4. Prueba de errores

Se ha probado cada entrada de datos y comprobado que el programa solo permite el paso de datos correctos.

### 4.1. Pruebas sobre Tienda

- Método de pago inválido:
![](media\metodo_mal.png)  

- Importe inválido:
![](media\importe_mal.png)  

### 4.2. Pruebas sobre TarjetaCredito

- Datos válidos:
![](media\tarjeta_bien.png)  

- Número de la tarjeta inválido:
![](media\tarjeta_num_mal.png)  

- Tipo de la tarjeta inválido:
![](media\tarjeta_tipo_mal.png)  

### 4.3. Pruebas sobre Paypal

- Datos válidos:
![](media\paypal_bien.png)  

- Email inválido:
![](media\paypal_cuenta_mal.png)  

- Saldo insuficiente:
![](media\paypal_saldo_mal.png)  

### 4.4. Pruebas sobre Bizum

- Datos válidos:
![](media\bizum_bien.png)  

- Teléfono inválido:
![](media\bizum_telefono_mal.png)  

- Pin incorrecto:
![](media\bizum_pin_mal.png)  