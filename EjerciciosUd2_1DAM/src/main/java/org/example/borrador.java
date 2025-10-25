package org.example;


import java.util.InputMismatchException;
import java.util.Scanner;

public class borrador
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        /*
        System.out.print("Número: ");
        int n = key.nextInt();
        //InputMismatchException comprende desde formatos erróneos hasta el StackOverflow
        key.nextLine();

        System.out.print("Número para convertir: ");
        String numero = key.nextLine();
        n = Integer.parseInt(numero);
        //NumberFormatException controla el .parseInt
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
         */

//        String heces = "123";
//        int num = 2;
//
//        System.out.println(num == Integer.parseInt(heces.substring(1, 2))); //Joder, no entiendo como Jesucristo es tan reverenciado teniéndome a mi.

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//        int num = 4;
//        String culo = "pedo";
//
//        try
//        {
//            if(num == Integer.parseInt(culo.substring(0, 1))) System.out.println("AAAAAAAAAAA");
//        }
//        catch (NumberFormatException e)
//        {
//            System.out.println("CAGASTE "+ e.getMessage());
//        }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//        String code = "0123456789";
//
//        for(int i = 0; i < code.length(); i++) System.out.println( i!=code.length()-1 ? code.substring(i, i+1).contains(String.valueOf(0)) : code.substring(i).contains(String.valueOf(4)));

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//        int num = 6;
//        String code = key.nextLine();
//        try {
//            num = num != 6 ? Integer.parseInt(code.substring(6-5, 6-4)) : Integer.parseInt(code.substring(6, 6+1));
//            System.out.println(num);
//        }catch (Exception e){
//            System.out.println("porfa");
//        }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
        final int DIGITOS = 10;
        int num, contadorInterrogante = 0;
        String isbn = key.nextLine();

        for(int i = 0; i < DIGITOS; i++)
        {


            try
            {
                num = Integer.parseInt(String.valueOf(isbn.charAt(i)));
            }
            catch (NumberFormatException e)
            {
                contadorInterrogante += isbn.charAt(i) == '?' ? 1 : isbn.charAt(i) == 'X' ? i == 9 ? 0 : -100 : -100;
            }
        }
        System.out.println(contadorInterrogante);

        System.out.println(isbn.indexOf("1"));
    }
}