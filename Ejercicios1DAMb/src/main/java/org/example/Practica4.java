package org.example;
import java.util.Scanner;

//Esta práctica pide realizar un programa que, mediante 2 números de 3 cifras introducidos por el usuario,
//se multipliquen y se muestre en pantalla como se haría en papel.
public class Practica4
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        //Declararé dos variables tipo int para almacenar los datos introducidos por el usuario
        //n2 se inicializa, si no IntelliJ detecta como error en la línea 51, aunque siempre vaya a llegar a ese punto con un valor.
        //n1 se inicializa, si no IntelliJ detecta como error en la línea 55, aunque siempre vaya a llegar a ese punto con un valor.
        int n1 = 0, n2 = 0;
        //Ahora declararé las variables necesarias tipo string y una tipo int para poder separar las cifras del número multiplicador
        String producto; //n2 convertido a tipo string
        String cifraS;  //Cifra String
        int cifraI;     //Cifra Int. Podría haberse declarado junto con los otros enteros, pero como se usa para separar las ciras, aquí queda más ordenado
        //Creo booleano para controlar la condición del bucle, y otro para comprobar si se ha introducido un valor negativo en n2
        boolean fallo, n2Neg = false;

        //Antes de hacer ningún cálculo, voy a pedir ambos números al usuario y los pasaré por filtros para cercionarme de que cumple los requisitos.
        //Creo un bucle do_while para obligar al usuario a introducir valores válidos, si no no podrá continuar con el programa. Será un bucle para cada variable.
        do
        {
            try
            {
                fallo = false;
                System.out.print("Introduzca el multiplicando (3 cifras): ");
                n1 = key.nextInt();
            }
            catch(Exception e)
            {
                System.out.println("ERROR\nEl formato introducido es inválido.\n");
                fallo = true;
            }
            key.nextLine();
            //Patricia me ha dicho que dejar el if fuera del try_catch es lo más correcto.
            // Para evitar que se muestren los dos mensajes de error al ser introducido un formato inválido, tengo que crear otro if por encima que mire si ha habido un error antes.
            if(!fallo)  //Si fallo != true, los datos pasarán por este filtro.
            {
                //If para segregar el filtro de número de cifras de los números negativos de los positivos, ya que las condiciones son diferentes
                if(n1 > 0) //Si n1 es positivo
                {
                    //La única condición que se ha de respetar (obviando el texto, de eso se encarga el try_catch) es que ambos números sean de 3 cifras.
                    //Si el número es menor de 100 ó mayor de 999, se considerará un error y tendrá que volver a introducir los datos.
                    if (n1 < 100 || n1 > 999) {
                        System.out.println("ERROR\nEl número ha de contar con 3 cifras.\n");
                        fallo = true;
                    }
                }
                else    //Si n1 es negativo
                {
                    if (n1 > -100 || n1 < -999)
                    {
                        System.out.println("ERROR\nEl número ha de contar con 3 cifras.\n");
                        fallo = true;
                    }
                }
            }
        }while(fallo);

        //Ahora filtramos el multiplicador
        do
        {
            try
            {
                n2Neg = false;
                fallo = false;
                System.out.print("Introduzca el multiplicador (3 cifras): ");
                n2 = key.nextInt();
            }
            catch(Exception e)
            {
                System.out.println("ERROR\nEl formato introducido es inválido.\n");
                fallo = true;
            }
            key.nextLine();
            if(!fallo)
            {
                if(n2 < 0) n2Neg = true;
                if(!n2Neg)
                {
                    if (n2 < 100 || n2 > 999) {
                        System.out.println("ERROR\nEl número ha de contar con 3 cifras.\n");
                        fallo = true;
                    }
                }
                else
                {
                    if (n2 > -100 || n2 < -999)
                    {
                        System.out.println("ERROR\nEl número ha de contar con 3 cifras.\n");
                        fallo = true;
                    }
                }
            }
        }while(fallo);
        //Una vez se hayan validado los datos introducidos se comienza con las operaciones.

        //Primero toca ver si n2 es positivo ó negativo. Los cálculos para realizar el programa de forma correcta cambian dependiendo de su signo.
        if(!n2Neg)  //Si es positivo
        {
            //Primero debemos convertir el multiplicador en un string para poder separar las cifras y operar con ellas individualmente.
            producto = Integer.toString(n2);
            cifraS = producto.substring(2); //Esta función me separará la cifra en la 3ra posición
            cifraI = Integer.parseInt(cifraS);  //Aquí convierto la cifra separada de nuevo en un tipo int para operar con él.

            //Para evitar declarar variables innecesarias, cifraI va a estar cambiando constantemente de valor y se irá imprimiendo por pantalla el resultado.
            System.out.println("\t\t\t" + n1);    //Haciendo pruebas con el \t he descubierto que un tabulador equivale a 4 espacios. Lo usaré para estructurar la operación.
            System.out.println("\t\t\t" + n2);
            System.out.println("\t\tx _______");
            System.out.println("\t\t\t" + (n1 * cifraI));  //Primera multiplicación. n1 * la cifra en la posición 2.

            //Ahora repito 2 veces la asignación de valores en cifraS y cifraI. Tras cada cambio de valor imprimo el resultado del cálculo por pantalla.
            cifraS = producto.substring(1, 2);
            cifraI = Integer.parseInt(cifraS);
            System.out.println("\t\t   " + (n1 * cifraI));    //Para que se establezca en su posición correcta he añadido 2 tabuladores y 2 espacios

            cifraS = producto.substring(0, 1);
            cifraI = Integer.parseInt(cifraS);
            System.out.println("\t\t  " + (n1 * cifraI));  //Para que se establezca en su posición correcta he eliminado uno de los espacios que se necesitaban en el System.out.println() anterior
            System.out.println("\t+ ___________");
        }
        else    //Si n2 es negativo. No hace falta comprobar si n1Neg == true, las operaciciones son las mismas siempre
        {
            producto = Integer.toString(n2);
            cifraS = producto.substring(3);
            cifraI = Integer.parseInt(cifraS);

            System.out.println("\t\t\t" + n1);
            System.out.println("\t\t\t" + n2);
            System.out.println("\t\tx _______");
            cifraI *= -1;   //Multiplicando cifraI por -1 antes de ser empleada la cambia de signo a negativo, mostrando correctamente el resultado.
            System.out.println("\t\t\t" + (n1 * cifraI));

            cifraS = producto.substring(2, 3);  //Como la posición 0 de un número negativo es el signo, me toca sumar 1 a cada posición.
            cifraI = Integer.parseInt(cifraS);
            cifraI *= -1;
            System.out.println("\t\t   " + (n1 * cifraI));

            cifraS = producto.substring(1, 2);
            cifraI = Integer.parseInt(cifraS);
            cifraI *= -1;
            System.out.println("\t\t  " + (n1 * cifraI));
            System.out.println("\t+ ___________");
        }

        //Ahora toca mostrar la suma final, que la realizaré multiplicando n1 por n2
        System.out.println("\t\t  "+ (n1*n2));    //Para poder alinear correctamente los cálculos necesitaría usar un .lenght para conocer el tamaño de antemano y utilizar un for para escribir los espacios.
    }
}
