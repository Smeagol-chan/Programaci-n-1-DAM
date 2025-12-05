package org.example.ampliacion_modular_seleccion_olimpiadas;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
        **** ESTO ESTABA A MENOS DE 3KB ANTES DE COMENTAR EL CÓDIGO ****

Recibiendo un número indeterminado de números positivos, he de decir si son hyperpares (todas las cifras que lo componen con pares).
Tengo que imprimir los resultados a partir del momento en el que el usuario introduzca un -1, ciñéndome al orden de inserción.
 */

public class Hyperpar
{
    //Una variable global para poder usarla en cada iteración de las funciones recursivas.
    static int tam = 0;

    //Primera función recursiva. Voy a recibir los número de uno en uno, comprobando que no sean negativos. En el momento que sí sea el caso, se terminará el proceso de solicitar datos.
    public static int[] filtro()
    {
        Scanner key = new Scanner(System.in);
        /*
        Comienzo declarando una variable n par aalmacenar el número que el usuario introduzca y una posición p. Esta es de suma importancia: registra la posición que debe ocupar n en la posición del vector.
        Como las funciones recursivas devuelven valores en orden inverso al que han sido llamadas, debo cercionarme de invertir al estado original la cadena. Esta forma, guardando la posición de tam al inicio de
        la iteración y aumentando en 1 el valor de tam, me aseguro de registrarlo debidamente.
        n también es relevante. El vector total realmente no es necesario hasta que el usuario introduzca -1. En ese momento todas las iteraciones sin resolver colapsan y se registra el valor del último vector
        en el anterior, y así sucesivamente hasta que se finaliza la ejecución de la función. Se sobreescribe el tamaño incluso del vector, contenido incluido. He de almacenar el número del usuario en una variable
        a parte para evitar perder la información.
         */
        int n = 0, p = tam++;
        int[] total = new int[tam];
        boolean fallo;

        do
        {
            fallo = false;
            try
            {
                n = key.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("ERROR\nSolo se pueden introducir números.");
                fallo = true;
                key.nextLine();
            }
            if(!fallo)
            {
                if(n < 0)
                {
                    if(n != -1) //Si ES == -1, no se ejecuta ninguna operación. Finaliza el bucle sin más.
                    {
                        System.out.println("ERROR\nNo se pueden introducir números negativos.");
                        fallo = true;
                    }
                }
                else
                {
                    //Si el número es correcto, se vuelca el contenido en total del resultado de la función filtro(), la misma función en la que estamos. Esta es la llamada recursiva.
                    //Mientras se genera una estancia nueva de esta función, esta iteración se queda en stand by hasta que todas las funciones hijas finalicen sus operaciones.
                   total = filtro().clone();
                }
            }
        }while(fallo);

        //Al finalizar el bucle, se guarda en la posición p del vector total, el valor en n. Como total ha sido actualizado con los vectores resultantes de las operaciones recursivas, ya cuenta con los otros
        //números y con el tamaño máximo, que coincide con todos los números válidos que el usuario ha introducido.
        total[p] = n;
        return total;   //Para finalizar, se devuelve el vector total.
    }

    //Esta es la función para comprobar si cada número es hyper par e imprimir el resultado que escribí antes de realizarla aplicando recursividad.
//    public static void comprobarHyperparesNR(int[] num)
//    {
//        String auxS;
//        int auxI;
//        fuera:
//        for(int i = 0; i < num.length-1; i++)
//        {
//            auxS = String.valueOf(num[i]);
//            for(int j = 0; j < auxS.length(); j++)
//            {
//                auxI = Integer.parseInt(String.valueOf(auxS.charAt(j)));
//                if(auxI%2 != 0)
//                {
//                    System.out.println("NO");
//                    continue fuera;
//                }
//            }
//            System.out.println("SÍ");
//        }
//    }

    //Segunda función recursiva. Simplemente divide el número enviado para ver si es par o impar, devolviendo true o false respectivamente.
    public static boolean comprobarHyperpares(int n)
    {
        boolean par;    //El booleano que almacenará el resultado, es decir, si true o false

        if(n%2 == 0)    //Primero miro si es par antes de realizar ninguna llamada recursiva. Si lo es...
        {
            if(n > 9)   //Compruebo si es mayor a 9, lo cual revela si cuenta con más de 1 cifra. Si lo es...
            {
                par = comprobarHyperpares(n/10);    //Invoco a la propia función al volcar el resultado de su operación con par.
            }
            else    //Si no es mayor a nueve...
            {
                par = true; //Igualo par a true...
            }
        }
        else    //Si no es par...
        {
            par = false;    //Igualo par a false...
        }
        return par; //y devuelvo el valor de par.
    }
    /*
    En la función comprobarHyperpar(), se puede observar una lógica recursiva mucho más simple que en filtro(). En este caso no requiero guardar ningún dato de los pasos intermedios. El
    único relevante es el de la última iteración, donde se descubre si ha llegado en algún momento a encontrar alguna cifra impar o no. Se iguala en cascada este resultado en todas las
    iteraciones hasta llegar a la función donde se invocó por primera vez.
     */

    public static void imprimirResultados(int[] nums)
    {
        for(int i = 0; i < nums.length-1; i++) System.out.println(comprobarHyperpares(nums[i]) ? "SÍ" : "NO");  //Un for básico que recorre las posiciones de la cadena imprimiendo SÍ o NO dependiendo de si recibe true o false.
    }

    static void main()
    {
        int[] numeros = filtro().clone();   //Creo un vector que se inicializa con todos los valores que filtro() recibe del usuario.

        System.out.println();
        imprimirResultados(numeros.clone());    //Se invoca al procedimiento encargado de imprimir por pantalla los resultados de las comprobaciones. Es esta función la encargada de llamar a la función que lo comprobará.
    }
}