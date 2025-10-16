package org.example;

import java.util.Scanner;
public class Practica1
{   /*
    El programa consiste en calcular el número de la suerte del usuario según si fecha de nacimiento.
    Se volcará la fecha introducida en un tipo string para luego transformar los números a tipo int para operar.
    La fecha 21 de agosto de 1909 es la mínima que el programa acepta como válida. Esto es así porque es el nacimiento de Ethel Caterham, la persona viva más longeva a fecha de hoy, 15 de octubre de 2025.
    No se permite superar el año actual, 2025. Aún así, introducir los días y meses que restan hasta el 1 de enero de 2026 sí que se acepta como válido.
    Se tienen en cuenta los años bisiestos.
    */
    static void main()
    {
        //El programa sumará el día, el mes y el año. Luego, se suman las cifras del resultado entre ellas. Finalmente, se mostrará el resultado de la última suma como el número de la suerte.
        Scanner key = new Scanner (System.in);

        //Constantes
        final int DIA_MIN = 1, DIA_MAX_ALTO = 31, DIA_MAX_BAJO = 30, DIA_MAX_FEB = 28;  //Mínimo y máximos de días. Para los años bisiestos se sumará 1 al máximo de febrero más adelante.
        final int MES_MIN = 1, MES_MAX = 12;    //Máximo y mínimo de los meses.
        final int ANNO_MIN = 1909, ANNO_MAX = 2025;    //Mínimo y máximo de los años. El año de nacimiento de la persona más longeva viva y el año en el que estamos ahora mismo.
        final int MES_ETHEL = 8, DIA_ETHEL = 21;    //Día y mes de nacimiento de Ethel para no permitir nada más antiguo que esta fecha.
        final int TAM_TOTAL = 10;   //Cantidad de caracteres que ha de contener el sting.
        final char SEPARADOR = '/';   //El separador que debe estar entre dia, mes y año.
        final int BARRA_1 = 2, BARRA_2 = 5; //Posiciones donde deben de estar los separadores.

        //Variables
        String fecha, diaS, mesS, annoS;   //Fecha introducida del usuario y sus divisiones en dia, mes y año.
        int diaI = 0, mesI = 0, annoI = 0, resul;   //Variables para guardar los números al convertirlos a tipo entero y para el resultado de las sumas. Luego se reusarán para la suma se las cifras de la primera suma.
        char sepUsado;    //sepUsado comprobar que el separador del usuario sea el correcto.
        boolean diaCorrecto = false, fallo;  //Booleano para registrar si el día introducido es válido dependiendo del mes y otro para controlar el bucle de filtro de datos.

        /*
        diaS, mesS, annoS ý fecha se van a utilizar para separar el resultado de la primera suma en cifras. Así no tengo que crear variables específicas para este momento. Lo que guardaran ya no tiene importancia en este punto.
        diaI, mesI, annoI ý resul se van a utilizar para operar en la primera suma y para albergar las cifras reconvertidas a enteros tras haberlas separado. Lo que guardaran ya no tiene importancia en este punto.
        */

        do
        {
            fallo = false;
            //Solicitar fecha al usuario. He escrito un \n para que, en caso de error, no esté tan pegado el mensaje que lo anuncia junto con la solicitud para introducir una fecha.
            System.out.print("\nIntroduzca la fecha de nacimiento (dd/mm/aaaa): ");
            fecha = key.nextLine();

            //Comprobar que ha introducido la cantidad correcta de carácteres.
            if(fecha.length() == TAM_TOTAL)
            {
                //Si la fecha cumple con la cantidad requerida de carácteres, se comprueba que los separadores seran correctos.
                sepUsado = fecha.charAt(BARRA_1);
                if(sepUsado == SEPARADOR)
                {
                    //Lo mismo para el separador situado entre el mes y el año.
                    sepUsado = fecha.charAt(BARRA_2);
                    if(sepUsado == SEPARADOR)
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
                            System.out.println("ERROR\nFormato de fecha incorrecto.");
                            fallo = true;
                        }
                        //Si se han podido convertir los valores de los strings a enteros sin errores, significa que se ha introducido un número. Ahora toca comprobar que los números estén dentro de los valores.
                        //Esta condición if(fallo == false) evita que se ejecute esta sección si se ha detectado un error en el catch.
                        if(!fallo)
                        {
                            //Comprobación del mes.
                            if(mesI >= MES_MIN && mesI <= MES_MAX)
                            {
                                //Comprobación del año.
                                if(annoI >= ANNO_MIN && annoI <= ANNO_MAX)
                                {
                                    //Comprobación del dia. Hay que hacerlo de esta manera porque el día máximo varía dependiendo del mes y si el año es bisiesto.
                                    //Primero compruebo que el día no sea inferior a 1. En los siguientes condicionales se comprobará que no se exceda el límite superior.
                                    if(diaI >= DIA_MIN)
                                    {
                                        //Comprobar si el número del dia es menor-igual a 31 en los meses de DIA_MAX_ALTO (enero == 1, marzo == 3, mayo == 5, julio == 7, agosto == 8, octubre  == 10 ý diciembre == 12)
                                        if(mesI == 1 || mesI == 3 || mesI == 5 || mesI == 7 || mesI == 8 || mesI == 10 || mesI == 12)
                                        {
                                            //Si el número no supera ningún límite establecido por es mes en el que se encuentra, el booleano diaCorrecto pasará a ser verdadero.
                                            if(diaI <= DIA_MAX_ALTO)
                                            {
                                                diaCorrecto = true;
                                            }
                                            else
                                            {
                                                System.out.println("ERROR\nDía inválido. No puede ser superior a "+ DIA_MAX_ALTO +" en enero, marzo, mayo, julio, agosto, octubre y diciembre.");
                                                fallo = true;
                                            }
                                        }
                                        else
                                        {
                                            //Comprobar si el número del dia es menor-igual a 30 en los meses de DIA_MAX_BAJO (abril == 4, junio == 6, septiempbre == 9 y noviembre == 11)
                                            if(mesI == 4 || mesI == 6 || mesI == 9 || mesI == 11)
                                            {
                                                if(diaI <= DIA_MAX_BAJO)
                                                {
                                                    diaCorrecto = true;
                                                }
                                                else
                                                {
                                                    System.out.println("ERROR\nDía inválido. No puede ser superior a "+ DIA_MAX_BAJO +" en abril, junio, septiembre y noviembre.");
                                                    fallo = true;
                                                }
                                            }
                                            else
                                            {
                                                //Comprobar si el número del día no supera DIA_MAX_FEB si el año no es bisiesto y DIA_MAX_FEB + 1 si sí que lo es.
                                                //Se comprueba si se trata de un año bisiesto, es decir, si el año es múltiplo de 4.
                                                if(annoI%4 == 0)
                                                {
                                                    //Si es bisiesto, compruebo si el dia es menor-igual a 29.
                                                    if(diaI <= DIA_MAX_FEB + 1)
                                                    {
                                                        diaCorrecto = true;
                                                    }
                                                    else
                                                    {
                                                        System.out.println("ERROR\nDía inválido. No puede ser superior a "+ (DIA_MAX_FEB + 1) +" en febrero, ya que es año bisiesto.");
                                                        fallo = true;
                                                    }
                                                }
                                                else
                                                {
                                                    //Si no es bisiesto, compruebo si el dia es menor-igual a 28.
                                                    if(diaI <= DIA_MAX_FEB)
                                                    {
                                                        diaCorrecto = true;
                                                    }
                                                    else
                                                    {
                                                        System.out.println("ERROR\nDía inválido. No puede ser superior a "+ DIA_MAX_FEB +" en febrero.");
                                                        fallo = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("ERROR\nDía inválido. No puede ser inferior a "+ DIA_MIN +".");
                                        fallo = true;
                                    }
                                }
                                else
                                {
                                    System.out.println("ERROR\nAño inválido. No puede ser inferior a "+ ANNO_MIN +" ni superior a "+ ANNO_MAX +".");
                                    fallo = true;
                                }
                            }
                            else
                            {
                                System.out.println("ERROR\nMes inválido. No puede ser inferior a "+ MES_MIN +" ni superior a "+ MES_MAX +".");
                                fallo = true;
                            }

                            //Último paso del filtro de datos para la fecha. Se comprueba si la fecha introducida es correcta.
                            //Podría haberlo metido dentro de las condiciones como la de la línea 99, donde se encuentran los datos válidos, pero colocarlo aquí me parece más ordenado.
                            if(diaCorrecto)
                            {
                                //Se comprueba que el día no sea más antiguo que el 21 de agosto de 1909.
                                // Primero se comprueba si el mes coincide con el año mínimo.
                                if(annoI == ANNO_MIN)
                                {
                                    //Luego, compruebo si el mes coincide con el mes de Ethel.
                                    if(mesI == MES_ETHEL)
                                    {
                                        //Finalmente, compruebo si el día es menor al de Ethel. Si se da el caso, salta el mensaje de error.
                                        if(diaI < DIA_ETHEL)
                                        {
                                            System.out.println("ERROR\nLa fecha no puede ser inferior a "+ DIA_ETHEL +"/"+ MES_ETHEL +"/"+ ANNO_MIN +".");
                                            fallo = true;
                                        }
                                    }
                                    //Alternativamente, se comprueba si el mes es anterior al mes de Ethel. Si lo es, salta error.
                                    if(mesI < MES_ETHEL)
                                    {
                                        System.out.println("ERROR\nLa fecha no puede ser inferior a "+ DIA_ETHEL +"/"+ MES_ETHEL +"/"+ ANNO_MIN +".");
                                        fallo = true;
                                    }
                                }
                            }
                        }
                    }
                    else
                    {
                        System.out.println("ERROR\nFormato de fecha incorrecto.");
                        fallo = true;
                    }
                }
                else
                {
                    System.out.println("ERROR\nFormato de fecha incorrecto.");
                    fallo = true;
                }
            }
            else
            {
                System.out.println("ERROR\nFormato de fecha incorrecto.");
                fallo = true;
            }
        }while(fallo);

        //Una vez calculado filtrada la fecha, procedemos al cálculo del número de la suerte.
        //Primero hay que sumar el día, el mes y el año e imprimir el cálculo por pantalla.
        resul = diaI + mesI;
        resul += annoI;
        System.out.println(diaI +" + "+ mesI +" + "+ annoI +" = "+ resul);

        //Ahora hay que volcar el resultado almacenado en resul en un string para poder separar sus cifras con el método substring.
        fecha = String.valueOf(resul);
        //Separar las cifras con substrings. Se almacenarán en las variables diaS, mesS, annoS ý fecha.
        diaS = fecha.substring(0, 1);
        mesS = fecha.substring(1, 2);
        annoS = fecha.substring(2, 3);
        fecha = fecha.substring(3);

        //Reconvertir los tipo string en enteros para realizar la última suma.
        diaI = Integer.parseInt(diaS);
        mesI = Integer.parseInt(mesS);
        annoI = Integer.parseInt(annoS);
        resul = Integer.parseInt(fecha);

        //Se imprimen por pantalla y se muestra el resultado de la operación.
        //Uso un .print en lugar de un .println para que el resultado de la operación salga en la misma línea.
        System.out.print(diaI +" + "+ mesI +" + "+ annoI +" + "+ resul +" = ");
        resul += diaI;
        resul += mesI;
        resul += annoI;
        System.out.println(resul);

        //Anunciar cuál es el número de la suerte calculado
        System.out.println("Tu número de la suerte es "+ resul);
    }
}