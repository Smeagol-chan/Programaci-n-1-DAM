package org.example.enum_intro.ej2;

import org.example.FuncionesComunes;

import java.util.Arrays;

public class DificultadApp
{
    static Dificultad validarDificultad()
    {
        Dificultad dificultad;
        boolean fallo;
        do
        {
            fallo = false;
            dificultad = null;
            System.out.println("Introduzca dificultad "+ Arrays.asList(Dificultad.values()) +":");
            try
            {
                dificultad = Dificultad.valueOf(FuncionesComunes.solicitarString().toUpperCase());
            }
            catch(Exception e)
            {
                fallo = true;
                System.out.println("Dificultad inválida");
            }
        }while(fallo);
        return dificultad;
    }

    static void main()
    {
        Dificultad dificultad = validarDificultad();
        int puntuacion = FuncionesComunes.random.nextInt(10000);

        System.out.println("Puntuación obtenida = "+ puntuacion +"\n" +
                "Puntuación final = "+ (puntuacion * dificultad.getMultiplicador()));
    }
}
