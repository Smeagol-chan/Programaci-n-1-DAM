package org.example;

import java.util.Scanner;
public class Practica1
{   /*
    El programa consiste en calcular el número de la suerte del usuario según si fecha de nacimiento.
    Se realizará sumando el día, el mes y el año. Luego, se suman las cifras del resultado entre ellas.
    Se volcará la fecha introducida en un tipo string.
    No se especifica que no se puedan introducir fechas muy antiguas. Permitiré que sea posible y calcular así el número de la suete de personas ya fallecidas.
    El año 1908 va a ser el mínimo ya que es el año de nacimiento de la persona viva más longeva, según el Giness.
    No se permite superar el año actual.
    Se tienen en cuenta los años bisiestos
    */
    static void main()
    {
        Scanner key = new Scanner (System.in);
        //Constantes con los máximos y mínimos de las fechas.
        final int DIA_MIN = 1, DIA_MAX_ALTO = 31, DIA_MAX_BAJO = 30, DIA_MAX_FEB = 28;  //Mínimo y máximos de días. Para los años bisiestos se sumará 1 al máximo de febrero más adelante.
        final int MES_MIN = 1, MES_MAX = 12;    //Máximo y mínimo de los meses.
        final int ANNO_MIN = 0, ANNO_MAX = 2025;    //Mínimo y máximo de los años.
        final int TAM_TOTAL = 10;   //Cantidad de caracteres que ha de contener el sting.
        final String SEPARADOR = "/";   //El separador que debe estar entre dia, mes y año.
        final int BARRA_1 = 2, BARRA_2 = 5; //Posiciones donde deben de estar los separadores.
        String fecha, diaS, mesS, annoS;   //Fecha introducida del usuario y sus divisiones en dia, mes y año.
        int diaI, mesI, annoI, cifra4; //Variables para guardar los números al convertirlos a tipo entero. Luego se reusarán para la suma se las cifras de la primera suma.
        String sepUsado; //Para comprobar que el separador del usuario sea el correcto.
        boolean fallo;    //Booleano para controlar el bucle de filtro de datos.

        do
        {
            fallo = false;
            //Solicitar fecha al usuario.
            System.out.print("Introduzca la fecha de nacimiento (dd/mm/aaaa): ");
            fecha = key.nextLine();

            //Comprobar que ha introducido la cantidad correcta de carácteres.
            if(fecha.length() != 10)
            {
                System.out.println("ERROR\nFormato de fecha incorrécto.");
                fallo = true;
            }
            else
            {
                //Si la fecha cumple con la cantidad requerida de carácteres, se comprueba que los separadores seran correctos.
                sepUsado = fecha.substring(BARRA_1, BARRA_1 + 1);
                if(sepUsado.contains(SEPARADOR))
                {
                    //Lo mismo para el separador situado entre el mes y el año.
                    sepUsado = fecha.substring(BARRA_2, BARRA_2 + 1);
                    if(sepUsado.contains(SEPARADOR))
                    {
                        //Comprobado que se cumple la cantidad de carácteres y la posición de los separadores, se divide la fecha en sendos substrings para dia, mes y año.
                        diaS = fecha.substring(0, BARRA_1);
                        mesS = fecha.substring(BARRA_1 + 1, BARRA_2);
                        annoS = fecha.substring(BARRA_2 + 1);

                        //Ahora se inica un try_catch para comprobar si las fechas introducidas son números o contienen carácteres.
                        try
                        {
                            diaI = Integer.parseInt(diaS);
                            mesI = Integer.parseInt(mesS);
                            annoI = Integer.parseInt(annoS);
                        }
                        catch (Exception e)
                        {
                            System.out.println("ERROR\nFormato de fecha incorrécto.");
                            fallo = true;
                        }
                        if(!fallo)
                        {

                        }
                        else
                        {
                            System.out.println("ERROR\nLa fecha máxima es 31/12/2025 y la mínima es 01/01/1908.");
                            fallo = true;
                        }
                    }
                    else
                    {
                        System.out.println("ERROR\nFormato de fecha incorrécto.");
                        fallo = true;
                    }
                }
                else
                {
                    System.out.println("ERROR\nFormato de fecha incorrécto.");
                    fallo = true;
                }
            }
        }while(fallo);
    }
}
