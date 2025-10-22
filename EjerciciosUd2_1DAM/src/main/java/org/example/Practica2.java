package org.example;
import java.util.Locale;
import java.util.Scanner;

//CALCULADORA SIMPLE
//Capaz de sumar, restar, multiplicar, dividir y hacer la raíz cuadrada.
public class Practica2
{
    static void main ()
    {
        Scanner key = new Scanner(System.in);
        String opAux;   //convertir lo que el operador a tipo char con un .chatAt (no lo sé ahcer de ora manera. Lo he intendado.)
        char operador = 'e';    //Variable para que el usuario seleccione la operación. Se inicializa porque si salta un error en su apartado para darle valor, el programa continúa con la variables vacía.
        double num1, num2, resultado;  //Variables para guardar los números con los que el usuario quiere operar.
        boolean fallo, vuelta;  //Control del do_while y el último do_while para reiniciar el programa si el usuario quiere.

        System.out.println("\n\t**** BIENVENIDO A LA CALCULADORA RÁPIDA ****\n");
        //Bucle que reinicia el programa. Sirve para poder introducir varias operaciones seguidas como para volver a solicitar num1 si es negativo y se quiere calcular su raíz cuadrada.
        do
        {
            //Los inicializo para evitar errores.
            num1 = 0;
            num2 = 0;
            do  //bucle filtro de num1
            {
                fallo = false;
                System.out.print("> Introduzca operando: ");
                if(key.hasNextDouble())
                {
                    num1 = key.nextDouble();
                }
                else
                {
                    System.out.println("ERROR\nSolo se puden introducir números.\n");
                    fallo = true;
                }
                key.nextLine();
            }while(fallo);

            System.out.println("------------------------------------");
            System.out.println(" [+] -> suma");
            System.out.println(" [-] -> resta");
            System.out.println(" [x] -> multiplicación");
            System.out.println(" [/] -> división");
            System.out.println(" [R] -> raíz cuadrada");
            System.out.println("------------------------------------");

            //Solicito el símbolo que selecciona el cálculo. Si contiene más de 1 carácter muestro un mensaje de error y genero un fallo
            System.out.print("> Introduce operación: ");
            opAux = key.nextLine();
            if(opAux.length() == 1) //No compruebo si el operador guarda un dato que cumple con el tamaño exijido, pero un carácter que no se encuentra entre las opciones. De eso se encargará el default del switch.
            {
                opAux = opAux.toLowerCase();
                operador = opAux.charAt(0);
            }
            else
            {
                System.out.println("ERROR\nNo más de 1 carácter. Solo se puede ingresar +, -, *, / ó R.\n");
                fallo = true;
            }

            //Si se quiere realizar una raíz cuadrada, no hay que pedir un segundo número.
            //Si el carácter cumple con el tamaño pero no con el símbolo, no evito que pueda introducir num2. Evitar que se pueda introducir num2 es redundante. Si lo filtro, no necesitaría el switch, por lo que símplemente permitiendo el paso, el código funciona igual de bien y queda más limpio.
            if(operador != 'r')
            {
                do
                {
                    fallo = false;
                    System.out.print("\n> Introduce operador: ");
                    if(key.hasNextDouble())
                    {
                        num2 = key.nextDouble();
                    }
                    else
                    {
                        System.out.println("ERROR\nSolo se puden introducir números.\n");
                        fallo = true;
                    }
                    key.nextLine();
                }while(fallo);
            }
            else    //Compruebo si num1 es negativo. Este punto solo se accede si se ha escogido R ó una opción inválida.
            {
                if(operador == 'r' && num1 < 0)
                {
                    System.out.println("ERROR\nNo se puede calcular raices de números negativos.\n");
                    fallo = true;
                }
            }

            //Si no ha habido fallo durante la ejecución, se puede acceder al switch que contiene las operaciones.
            if(!fallo)
            {
                switch (operador)   //Para suma, resta y producto tienen la misma estructura. División es igual pero con una condición añadida. La raíz sí que cuenta con una estructura única.
                {
                    case '+':
                        try
                        {
                            resultado = num1 + num2;
                            System.out.println(num1 +" + "+ num2 +" = "+ resultado);
                        }
                        catch(Exception e)
                        {
                            System.out.println("ERROR\nStackOverflow: "+ e.getMessage());
                        }
                        break;

                    case '-':
                        try
                        {
                            resultado = num1 - num2;
                            System.out.println(num1 +" - "+ num2 +" = "+ resultado);
                        }
                        catch(Exception e)
                        {
                            System.out.println("ERROR\nStackOverflow: "+ e.getMessage());
                        }
                        break;

                    case '*':
                        try
                        {
                            resultado = num1 * num2;
                            System.out.println(num1 +" * "+ num2 +" = "+ resultado);
                        }
                        catch(Exception e)
                        {
                            System.out.println("ERROR\nStackOverflow: "+ e.getMessage());
                        }
                        break;

                    case '/':   //La división entre 0 no es posible. Si el usuario introdujo 0 en num2, voy a evitar que proceda el código con un if
                        if(num2 == 0)
                        {
                            System.out.println("ERROR\nEl divisor no puede ser 0.\n");
                            fallo = true;
                        }
                        else
                        {
                            try
                            {
                                resultado = num1 / num2;
                                System.out.println(num1 +" / "+ num2 +" = "+ resultado);
                            }
                            catch(Exception e)
                            {
                                System.out.println("ERROR\nStackOverflow: "+ e.getMessage());
                            }
                        }
                        break;

                    case 'r':   //Para calcular la raíz cuadrada hay que usar el método Math.sqrt().
                        resultado = Math.sqrt(num1);
                        System.out.println("La raíz cuadrada de "+ num1 +" es "+ resultado +".");
                        break;

                    default:
                        System.out.println("ERROR\nOpción inválida. Solo se puede ingresar +, -, *, / ó R.\n");
                        fallo = true;
                        break;
                }
            }

            if(!fallo)  //Necesito evitar que se ejecute esta condición si ya se ha producido un fallo. Esta orden es únicamente para reiniciar el programa si el usuario desea realizar otro cálculo.
            {
                do  //Para este caso, vuelta se convierte en la variable que controla la salida del bucle y fallo cambiará a true si el usuario quiere reiniciar. opAux filtrará guardará la elección del usuario.
                {
                    vuelta = false;
                    System.out.print("\n¿Desea reiniciar el programa? (si/no): ");
                    opAux = key.nextLine();

                    //antes de comprobar si ha escrito o si o no, voy a mirar si contiene 2 carácteres, más o menos de eso no está permitido.
                    if(opAux.length() != 2)
                    {
                        System.out.println("ERROR\nFormato incorrecto. El texto ha de contar con 2 carácteres, usted ha introducido "+ opAux.length() +".");
                        vuelta = true;
                    }
                    else
                    {
                        if (opAux.toLowerCase().contains("si"))
                        {
                            System.out.println();   //Salto de línea  para que no se junte el texto impreso en esta sección con la solicitud de un nnuevo operando.
                            fallo = true;
                        }
                        else    //Si la respuesta es no, no hay que hacer nada.
                        {
                            if (!opAux.toLowerCase().contains("no")) //Y como no hay instrucciones exclusivas para opAux == "no", esta condición filtra todo lo que no sea o si o no.
                            {
                                System.out.println("ERROR\nEl texto introducido no está permitido. Introduzca ó si ó no.\n");
                                vuelta = true;
                            }
                        }
                    }
                }while(vuelta);
            }
        }while(fallo);

        System.out.println("\n\t**** FIN DE EJECUCIÓN ****");
    }
}
