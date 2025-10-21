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
        char operador;    //Variable para que el usuario seleccione la operación.
        double num1, num2, resultado;  //Variables para guardar los números con los que el usuario quiere operar.
        boolean fallo;  //Control del do_while

        System.out.println("**** BIENVENIDO A LA CALCULADORA RÁPIDA ****\n");
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

            //Solicito el símbolo que selecciona el cálculo. Si contiene más de 1 carácter, a la variable encargada de la selección la igualo a una opción errónea para que caiga en el default del switch.
            //Si introduce un único carácter, pero incorrecto, también será filtrado por el switch.
            System.out.print("> Introduce operación: ");
            opAux = key.nextLine();
            if(opAux.length() == 1)
            {
                opAux = opAux.toLowerCase();
                operador = opAux.charAt(0);
            }
            else
            {
                operador = 'e';
            }

            //Si se quiere realizar una raíz cuadrada, no hay que pedir un segundo número.
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
                if(operador == 'r' && num1 < 0) //Si el operador es correcto pero el num1 < 0. No se pede calcular, por lo que fallo = true, reiniciará el programa y saltará el switch.
                {
                    System.out.println("ERROR\nNo se puede calcular raices de números negativos.");
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

                    case 'r':
                        break;

                    default:
                        System.out.println("ERROR\nOpción inválida. Solo se puede ingresar +, -, *, / ó R.\n");
                        fallo = true;
                        break;
                }
            }
        }while(fallo);
    }
}
