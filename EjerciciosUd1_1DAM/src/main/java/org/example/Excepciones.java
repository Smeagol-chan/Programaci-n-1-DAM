package org.example;

//import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        byte num;
        boolean fallo;

        do
        {
            try
            {
                fallo = false;
                System.out.print("Escribe: ");
                num = key.nextByte();
            }
            catch (StackOverflowError e)
            {
                System.out.println("\nStack Overflow Error\n"); //esto no da error pero no funciona.
                fallo = true;
            }
            catch(Exception e)
            //catch(InputMismatchException e)
            {
                System.out.println("\nInput Mismatch Exception\n"); //Se comporta como el (Exception e) genérico.
                fallo = true;
            }
            key.nextLine(); //Imprescindible siempre que el TIPO de DATO que se ASIGNA sea DIFERENTE al ANTERIOR
        }while(fallo);
    }
}
