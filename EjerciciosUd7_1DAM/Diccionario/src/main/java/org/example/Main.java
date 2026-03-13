package org.example;
import java.util.Scanner;

public class Main
{
    static void adivinanzas(int[] aciertos_errores, Diccionario diccionario)
    {
        Scanner key = new Scanner(System.in);
        String palabraAdivinar, palabraIntento;
        while(true)
        {
            palabraAdivinar = diccionario.palabraAleatoria();
            System.out.println(palabraAdivinar +": "
                    + diccionario.primeraLetraTraduccion(palabraAdivinar) +"...");

            System.out.print("Indique la respuesta: ");
            palabraIntento = key.nextLine().toLowerCase();
            if(palabraIntento.equals("fin")) break;

            if(palabraIntento.equals(diccionario.traduce(palabraAdivinar)))
            {
                aciertos_errores[0]++;
                System.out.println("¡CORRECTO!\n");
            }
            else
            {
                aciertos_errores[1]++;
                System.out.println("¡NO! La respuesta correcta es "
                        + diccionario.traduce(palabraAdivinar) +".\n");
            }
        }
    }

    static void resultado(int[] aciertos_errores)
    {
        System.out.println("FIN DEL PROGRAMA");
        System.out.println("Total preguntas: "+ (aciertos_errores[0]+aciertos_errores[1]));
        System.out.println("Total aciertos: "+ aciertos_errores[0]);
        System.out.println("Total errores: "+ aciertos_errores[1]);
        System.out.println("Aciertos: "
                + (aciertos_errores[0]*100/(aciertos_errores[0]+aciertos_errores[1])) +"%");
    }

    static void main()
    {
        Diccionario diccionario = new Diccionario();
        int[] aciertos_errores = {0, 0};
        Vocabulario.precarga(diccionario);
        adivinanzas(aciertos_errores, diccionario);
        resultado(aciertos_errores);
    }
}
