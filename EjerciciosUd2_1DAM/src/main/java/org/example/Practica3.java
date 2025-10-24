package org.example;
import java.util.Scanner;
/*
Programa para validar un ISBN. Es válido si es múltiplo de 11 tras una serie de multiplicaciones.
También podrá reparar un número incompleto. Solo puede faltar uno de sus dígitos y deberá estar marcdo con ?.
 */
public class Practica3
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        final int DIGITOS = 10; //Cantidad de dígitos que debe de conener un ISBN
        String isbn;    //Variable para guardar el número del usuario. También se encarga de comprobar si el usuario querrá reiniciar el programa o no.
        int num = 0;    //Variable para hacer los cálculos. También es la variable encargada de seleccionar la opción del switch menú.
        boolean fallo, vuelta = true;  //Controlar los bucles y reiniciar el programa.

        //do_while para poder reiniciar el programa si se desea
        do
        {
            System.out.println("\t**** VALIDADOR Y REPARADOR DE CÓDIGOS ISBN ****\n");
            //Pedir al usuario seleccionar una de las dos opciones que tiene el programa, solicitándolo de nuevo si no es válido.
            do
            {
                fallo = false;
                System.out.println("---------------------------\nSeleccione una opción:\n1. Validar\n2. Reparar\n---------------------------\n> ");
                if(key.hasNextLine())
                {
                    num = key.nextInt();
                    if(num > 2 || num < 1)  //Me gusta comprobar si la opción es válida en este punto. El default del switch me gusta dejarlo libre por, si hay algún error y no puedo entrar en otra opción, saberlo.
                    {
                        System.out.println("ERROR\nSolo se puede introducir 1 o 2.\n");
                        fallo = true;
                    }
                }
                else
                {
                    System.out.println("ERROR\nSe esperaba un entero.\n");
                    fallo = true;
                }
            }while(fallo);
            System.out.println("---------------------------");

            //Solicitar el ISBN y comprobar que todos sus dígitos son válidos. Los permitidos son los números del 0 al 9 ý X siempre y cuando ocupe la última posición.
            //Lo pido ahora porque ambas opciones necesitan este código y repetiría código si no.
            //Si el número es válido y contiene ? PERO la opción escogida es la 1, lo anunciará el programa dentro del propio switch. Esa comprobación la hará cada case. Es lo único que diferencia a ambas esructuras.
            do
            {
                fallo = false;
                System.out.print("Introduzca el ISBN:\n> ");
                isbn = key.nextLine();

                if(isbn.length() == DIGITOS)
                {
                    
                }
                else
                {
                    System.out.println("ERROR\nEl código ISBN debe contar con "+DIGITOS+" carácteres.\n");
                    fallo = true;
                }
            }while(fallo);

            switch (num)
            {
                case 1:

                    break;

                case 2:

                    break;

                default:
                    System.out.println("\n\t¡¡¡¡¡¡¡¡ESTÁS EN EL DEFAULT!!!!!!!!!!\n");
                    break;
            }
        }while(vuelta);
        System.out.println("\n\t**** FIN DE EJECUCIÓN ****");
    }
}
