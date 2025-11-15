package org.example;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//La primitiva. 6 números del 1 al 49 y 1 del 0 al 9. Los seis primeros son el premio y el último es el reintegro. Una final del 1 al 49, el complementario. Este no puede ser igual a los 6 primeros.
/*
    *** PREMIOS ***
Categoría Especial: 6 números y reintegro
1ªCategoría: 6 números
2ªCategoría: 5 números y complementario
3ªCategoría: 5 números
4ªCategoría: 4 números
5ªCategoría: 3 números
Reintegro: reintegro
No premiado
*/
//Había empezado a hacer el ejercicio metiendo todos los números en el vector resultadoSorteo, como sería un número de la primitiva real.
public class Practica2
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        Random random = new Random();
        //Declaro los números mínimos -ignorando el 0- y los máximos que pueden salir en cada tipo de tirada. También la cantidad de bolas totales que se van a lanzar. También genero el número del reintegro.
        final int NUM_MIN_REGULARES = 1, NUM_MAX_REGULARES = 49, NUM_MAX_REINTEGRO = 9, CANTIDAD_REGULARES = 6, RESULTADO_REINTEGRO = random.nextInt(NUM_MAX_REINTEGRO + 1);
        String boleto, numerosStringBoleto[] = new String[CANTIDAD_REGULARES + 1];
        Integer resultadoSorteo[] = new Integer[CANTIDAD_REGULARES], numerosBoleto[] = new Integer[CANTIDAD_REGULARES];
        int resultadoComplementario = random.nextInt(NUM_MAX_REGULARES - NUM_MIN_REGULARES + 1) + NUM_MIN_REGULARES, aux = 0, contador;
        boolean fallo;

        //Creo en un for el número ganador. Queda mucho más limpio.
        //Se crea un número aleatorio en aux. Antes de guardarlo en resultadoSorteo, se comprueba que su valor no esté previamente almacenado, reiniciando si se da el caso.
        for(int i = 0; i < CANTIDAD_REGULARES; i++)
        {
            do
            {
                aux = random.nextInt(NUM_MAX_REGULARES - NUM_MIN_REGULARES + 1) + NUM_MIN_REGULARES;
                fallo = Arrays.asList(resultadoSorteo).contains(aux);
            }while(fallo);
            resultadoSorteo[i] = aux;
        }
        Arrays.sort(resultadoSorteo);

        //Se comprueba que el número complementario no esté contenido dentro del vector que almacena los 6 primero números. Si encuentra coincidencia, se asigna un nuevo valor aleatorio y se vuelve a comprobar.
        //Es la misma función que hace el for anterior. Está ligeramente cambiada la estructura porque este lo escribí antes y el otro lo estuve cambiando, viendo qué método me ofrecía el mejor resultado.
        do
        {
            fallo = Arrays.asList(resultadoSorteo).contains(resultadoComplementario);
            if(fallo) resultadoComplementario = random.nextInt(NUM_MAX_REGULARES - NUM_MIN_REGULARES + 1) + NUM_MIN_REGULARES;
        }while(fallo);

        //Ahora pido al usuario que introduzca su número de papeleta, volviendo a solicitarlo si introduce un formato o valor inválido.
        do
        {
            contador = 0;
            fallo = false;
            System.out.print("Introduce los datos de tu boleto (nn-nn-nn-nn-nn-nn/n): \n> ");
            boleto = key.nextLine();
            if(boleto.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}/\\d")) //Compruebo que el formato sea el correcto.
            {
                numerosStringBoleto = boleto.split("[-/]");   //Divido los datos en las distintas posiciones de un array
                while(!fallo && contador < numerosStringBoleto.length) //Comprobamos, posición a posición si cada dato es correcto.
                {
                    try
                    {
                        aux = Integer.parseInt(numerosStringBoleto[contador]);    //Primero comprobar que sea un número
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("ERROR\nSolo se permiten números.\n");
                        fallo = true;
                    }
                    if(!fallo)  //Tratándose de un número
                    {
                        if(aux >= 0)    //Filtrar si es negativo
                        {
                            if(contador == numerosStringBoleto.length - 1) //Comprobar si se trata de la última posición, es decir, el número del reintegro
                            {
                                if(aux > NUM_MAX_REINTEGRO) //Que no supere el límite máximo del reintegro
                                {
                                    System.out.println("ERROR\nPara el reintegro, el número no puede superar "+ NUM_MAX_REINTEGRO +".\n");
                                    fallo = true;
                                }
                            }
                            else if(aux > NUM_MAX_REGULARES)    //Si no es la última posición, se mira que no supere el límite superior de los número regulares
                            {
                                System.out.println("ERROR\nLos números del sorteo, obviando el reintegro, no pueden superar "+ NUM_MAX_REGULARES +".\n");
                                fallo = true;
                            }
                            else if(aux < NUM_MIN_REGULARES)    //Ni el inferior
                            {
                                System.out.println("ERROR\nLos números del sorteo, obviando el reintegro, no pueden ser inferiores a "+ NUM_MIN_REGULARES +".\n");
                                fallo = true;
                            }
                        }
                        else
                        {
                            System.out.println("ERROR\nLos números no pueden ser negativos.\n");
                            fallo = true;
                        }
                    }
                    if(!fallo) contador++;  //Si todo es correcto, se comprueba la siguiente posición.
                }
            }
            else
            {
                System.out.println("ERROR\nFormato inválido.\n");
                fallo = true;
            }

            if(!fallo)
            {
                contador = 0;
                aux = 0;
                //Compruebo como al inicio del programa que no hayan coincidencias. Si las hubiera, se generará un error y se volvería a solicitar un boleto.
                while(!fallo && contador < (numerosStringBoleto.length - 1))
                {
                    aux = Integer.parseInt(numerosStringBoleto[contador]);
                    fallo = Arrays.asList(numerosBoleto).contains(aux);
                    if(!fallo) numerosBoleto[contador] = aux;
                    contador++;
                }
                if(fallo)
                {
                    System.out.println("ERROR\nLos números no se pueden repetir.\n");
                    //Igualo a 0 todas las posiciones de numerosBoleto para que, cuando se reinicie, no salte error si se vuelve a introducir algún número igual al intento anterior
                    for(int i = 0; i < numerosBoleto.length; i++) numerosBoleto[i] = 0;
                }
                else    //Si no se ha repetido ningún número, se guarda el reintegro
                {
                    aux = Integer.parseInt(numerosStringBoleto[contador]);
                }
            }
        }while(fallo);

        //Hora de ver cuántos aciertos han habido. Se vuelve a iniciar el contador a 0. Es la variable encargada de llevar la cuenta de coincidencias.
        contador = 0;
        for(int i = 0; i < CANTIDAD_REGULARES; i++)
        {
            if(Arrays.asList(resultadoSorteo).contains(numerosBoleto[i])) contador++;
        }
        System.out.println("RESULTADOS\nAciertos: "+ contador);
        //Por medio de un switch, se imprimirá por pantalla el resultado de la primitiva.
        switch(contador)
        {
            case 3:
                System.out.println("5ª Categoría");
                break;

            case 4:
                System.out.println("4ª Categoría");
                break;

            case 5:
                System.out.println((Arrays.asList(numerosBoleto).contains(resultadoComplementario) ? "2" : "3") +"ª Categoría");
                break;

            case 6:
                System.out.println(RESULTADO_REINTEGRO == aux ? "Categoría Especial" : "1ª Categoría");
                break;

            default:
                System.out.println(RESULTADO_REINTEGRO == aux ? "Reintegro" : "No premiado");
                break;
        }
    }
}
