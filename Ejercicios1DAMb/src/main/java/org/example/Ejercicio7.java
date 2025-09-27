package org.example;

import java.util.Scanner;

public class Ejercicio7
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        String respuesta;
        boolean fallo;

        //Le pregunto si tiene o no tomate y filtro para que solo pueda responder o si o no
        do {
            fallo = true;
            System.out.print("¿Tienes tomate?(si/no): ");
            respuesta = key.nextLine();

            if(respuesta.equals("no") || respuesta.equals("si"))
            {
                fallo = false;
            }
            else
            {
                System.out.println("ERROR\nValor inválido.");
            }
        }while(fallo);

        //Si la respuesta es afirmativa, volverá a entrar en otro filtro de datos para saber si tiene aceita.
        //Si en algún momento responde que no, va a entrar en el else y le va a sacar del programa.
        if(respuesta.equals("si"))
        {
            do {
                fallo = true;
                System.out.print("¿Tienes aceite?(si/no): ");
                respuesta = key.nextLine();

                if(respuesta.equals("no") || respuesta.equals("si"))
                {
                    fallo = false;
                }
                else
                {
                    System.out.println("ERROR\nValor inválido.");
                }
            }while(fallo);

            if(respuesta.equals("si")) {
                do {
                    fallo = true;
                    System.out.print("¿Tienes jamón?(si/no): ");
                    respuesta = key.nextLine();

                    if (respuesta.equals("no") || respuesta.equals("si")) {
                        fallo = false;
                    } else {
                        System.out.println("ERROR\nValor inválido.");
                    }
                } while (fallo);

                //Solo se puede llegar a este punto si todas las respuestas han sido afirmativas.
                //Si responde en cualquier momento con un "no", el programa dirá que tiene que ir a comprar y terminará la ejecución.
                if(respuesta.equals("si"))
                {
                    System.out.println("¡No tienes que ir a comprar!");
                }
                else
                {
                    System.out.println("¡Tienes que ir a comprar!");
                }
            }
            else
            {
                System.out.println("¡Tienes que ir a comprar!");
            }
        }
        else
        {
            System.out.println("¡Tienes que ir a comprar!");
        }
    }
}
