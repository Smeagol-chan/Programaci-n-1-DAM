package org.example;

import java.util.Scanner;

//Programa para, pidiendo la altura y el peso de el cliente, comprobar si es seguro que pueda montarse en la atracción.
public class Practica3
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        //Declaro las variables que voy a emplear. Las declaro enteras porque no ncesito exactitud decimal.
        //Además, en las capturas de consola de la práctica se puede ver que también se usaron enteros.
        int altura, peso;
        //El peso mínimo sí que es requerido que pueda mostrar decimales. Yo lo declado como float
        float peso_min;

        //Estructura try_catch para evitar errores si se introduce un formato inválido. Si detecta alguno al recoger el valor de peso ó de altura, el programa finalizará de inmediato.
        try
        {
            //Pido al usuario la altura en centímetros y lo guardo en la variable altura.
            System.out.println("***BIENVENIDO AL RATÓN JUGUETÓN***");
            System.out.println("Leyendo altura (cm)...");
            altura = key.nextInt();


            //Aquí empieza la concatenación de if_else. Si en cualquier momento el usuario introduce un dato incorrecto, el programa terminará de forma inmediata.
            //En este primero compruebo que el usuario no mida menos de 140cm, pero contando los negativos como válidos. Eso lo filtro en el siguiente.
            if (altura < 140 && altura > 0)
            {
                System.out.println("LO SIENTO. NO PUEDES MONTAR EN LA ATRACCIÓN. Te faltan " + (140 - altura) + "cm de altura.");
            }
            else
            {
                //Compruebo que la altura sea positiva y no exceda 230. Si pasa se dirá que la lectura ha sido errónea y el programa finalizará.
                if (altura > 230 || altura < 0)
                {
                    System.out.println("ERROR DE LECTURA. BAJA DE LA BÁSCULA Y VUELVE A SUBIR...");
                }
                else
                {
                    //Una vez pasados los filtros para asegurar que la altura tiene un formato válido y un valor dentro de lo especificado, solicito que de valor a la variable peso.
                    System.out.println("Leyendo pero (kg)...");
                    peso = key.nextInt();

                    //Compruebo que el peso introducido sea mayor al mínimo solicitado por la práctica. Además, este filtro me sirve para eliminar los valores negativos
                    if(peso < (altura * 2) / 2)
                    {
                        System.out.println("");
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR DE LECTURA. BAJA DE LA BÁSCULA Y VUELVE A SUBIR...");
        }
    }
}
