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
        int num = 0, aux, contadorInterrogante;    //Selector de switch. Variable para hacer los cálculos. contadorInterrogante aumenta en uno por cada ? encontrado en el isbn.
        boolean fallo, vuelta = false;  //Controlar los bucles y reiniciar el programa.

        //do_while para poder reiniciar el programa si se desea
        System.out.println("\n\t**** VALIDADOR Y REPARADOR DE CÓDIGOS ISBN ****");
        do
        {
            //Pedir al usuario seleccionar una de las dos opciones que tiene el programa, solicitándolo de nuevo si no es válido.
            do
            {
                fallo = false;
                System.out.print("\n---------------------------\nSeleccione una opción:\n1. Validar\n2. Reparar\n\n> ");
                if(key.hasNextInt())
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
                key.nextLine();
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
                isbn = isbn.toUpperCase();
                contadorInterrogante = 0;   //Inicializo lso contadores para tenerlos a cero para cada nuevo intendo en los for.

                //La primera comprobación es para la cantidad de dígitos introducidos. Tienen que ser 10.
                if(isbn.length() == DIGITOS)
                {
                    //me he matado aquí.
                    //Con un for compruebo si puedo volver el carácter en isbn en un entero. Si puedo, confirmo que es un número. Si no puedo, salta el catch y compruebo si es ? ó X. Cualquier otra cosa no es válida.
                    for(int i = 0; i < DIGITOS; i++)
                    {
                        try
                        {
                            aux = Integer.parseInt(String.valueOf(isbn.charAt(i)));
                        }
                        catch (NumberFormatException e)
                        {
                            //Si no es un ? ó se trata de una X fuera de la última posición, fuerzo a contadorInterrogantes a ser negativa.
                            contadorInterrogante += isbn.charAt(i) == '?' ? 1 : isbn.charAt(i) == 'X' ? i == (DIGITOS-1) ? 0 : -100 : -100;
                        }
                    }
                }
                else
                {
                    System.out.println("ERROR\nEl código ISBN debe contar con "+DIGITOS+" carácteres.\n");
                    fallo = true;
                }

                //Si se han encontrado fallo en el for anterior, contador es negativo.
                if(contadorInterrogante < 0)
                {
                    System.out.println("ERROR\nCarácteres inválidos en el código.\n");
                    fallo = true;
                }
                else if (contadorInterrogante > 1)  //Compruebo la cantidad de ? encontrados. Si supera 1 salta error.
                {
                    System.out.println("ERROR\n"+ contadorInterrogante +" interrogantes (?) introducidos. No se permiten más de 1 interrogante (?).\n");
                    fallo = true;
                }
            }while(fallo);

            //switch donde se calcularán las operaciones que pide el usuario.
            switch (num)
            {
                case 1: //Primero compruebo que no se hayan introducido ?. Es un símbolo exclusivo del case 2.
                    if(contadorInterrogante != 0)
                    {
                        System.out.println("ERROR\nNo se puede validar un código incompleto.\n");
                    }
                    else
                    {
                        //Limpio el contenido de num para poder usarlo en las sumas.
                        num = 0;
                        //un bucle for que multiplica las cifras por sus posiciones a la inversa +1. Si hay X se cambia por 10. Si el resultado es múltiplo de 11, se considera un ISBN válido.
                        for(int i = DIGITOS; i > 0; i--)
                        {
                            aux = i == 1 && isbn.contains("X") ? 10 : Integer.parseInt(String.valueOf(isbn.charAt(DIGITOS-i)));
                            num += i * aux;
                        }
                        System.out.println("\nEl ISBN es "+ (num%11 == 0 ? "válido.": "inválido."));
                    }
                    break;

                case 2: //Primero hay que comprobar que tenga un ?.
                    if(contadorInterrogante != 1)
                    {
                        System.out.println("ERROR\nDebe haber 1 número perdido para poder repararlo.\n");
                    }
                    else
                    {
                        num = 0;
                        //Usando el .indexOf encontramos dónde está situado el interrogante. Usamos el mísmo método que en el case 1, pero evitamos que se calcule el producto de la cifra que no conocemos.
                        contadorInterrogante = isbn.indexOf("?");
                        for(int i = DIGITOS; i > 0; i--)
                        {
                            if(isbn.charAt(DIGITOS-i) != '?')   //Se compueba que no haya ? en la posición que se está calculando. Si es así, se salta y el bucle continúa.
                            {
                                aux = i == 1 && isbn.contains("X") ? 10 : Integer.parseInt(String.valueOf(isbn.charAt(DIGITOS-i)));
                                num += i * aux;
                            }
                        }
                        //Una vez teniendo todo calculado menos la cifra que no tenemos, nos metemos en un bucle while hasta encontrar el número que falta. While porque, si resulta que el que falta es 0, no hace falta entrar el bucle.
                        aux = 0;
                        if(contadorInterrogante == (DIGITOS-1))   //Importante este if, porque la posición 9 puede tener de valor 10, pero el máximo que puede valer cualquiero otra posición es 9.
                        {
                            while(((((DIGITOS-contadorInterrogante)*aux)+num)%11) != 0 && !fallo)
                            {
                                aux++;
                                if(aux > 10) fallo = true;
                            }
                        }
                        else
                        {
                            while(((((DIGITOS-contadorInterrogante)*aux)+num)%11) != 0 && !fallo)
                            {
                                aux++;
                                if(aux > 9) fallo = true;
                            }
                        }
                        if(!fallo)
                        {
                            System.out.println("\nEl dígito que falta es "+ (aux == 10 ? "X" : aux) +".\n");    //No hace falta especificar que X esté en la última posición, yq lo hemos comprobado en la solicitud del isbn ý en el if anterior.
                        }
                        else    //Por da el caso de que no se encuentra ningún número que dé como resultado un múltiplo de 11, salta esta condición.
                        {
                            System.out.println("\nNo se ha hayado ningún número que pueda validar este código.\n");
                        }
                    }
                    break;

                default:
                    //No ponga nada en el default excepto un printf para avisarme si he caido dentro. Si estoy aquí es que algo ha ido mal en el switch.
                    System.out.println("\n\t¡¡¡¡¡¡¡¡ESTÁS EN EL DEFAULT!!!!!!!!!!\n");
                    break;
            }
            //bucle de regreso. Es el mismo que en la práctica anterior. A no ser que se especifique lo contrario, todos mis programas lo vana  tener. Más cómodo buscar errores.
            do
            {
                fallo = false;
                System.out.print("\n¿Desea reiniciar el programa? (si/no): ");
                isbn = key.nextLine();
                if(isbn.length() != 2)
                {
                    System.out.println("ERROR\nFormato incorrecto. El texto ha de contar con 2 carácteres, usted ha introducido "+ isbn.length() +".");
                    fallo = true;
                }
                else if (isbn.toLowerCase().contains("si"))
                {
                    System.out.println();
                    vuelta = true;
                }
                else if (!isbn.toLowerCase().contains("no"))
                {
                    System.out.println("ERROR\nEl texto introducido no está permitido. Introduzca ó si ó no.\n");
                    fallo = true;
                }
                else vuelta = false;

            }while(fallo);
        }while(vuelta);
        System.out.println("\n\t**** FIN DE EJECUCIÓN ****");
    }
}

/*1234587890
                            contadorX = contadorInterrogante = 0;
                            (...)
                            contadorInterrogante += i != 9 ? isbn.substring(i, i+1).contains(String.valueOf(j)) ? 0 : isbn.substring(i, i+1).contains("?") ? 1 : -100 : //Si i!=9 == true
                                    isbn.substring(i).contains(String.valueOf(j)) ? 0 : isbn.substring(i).contains("?") ? 1 : isbn.substring(i).contains("X") ? contadorX++ : -100;    //Si i!=9 == false
                                    No funciona, pero qué bonito que ha quedado
                             */