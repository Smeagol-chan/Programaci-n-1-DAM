package org.example.instituto;

public class InstiApp
{
    static void main()
    {
        Instituto berlanga = new Instituto("IES Berlanga", "Sant Joan d'Alacant");
        Curso bachCient = new Curso("Bachillerato científico", 600);
        Estudiante eric = new Estudiante("Eric", 25, bachCient);

        berlanga.anyadirCurso(bachCient);
        berlanga.anyadirEstudiante(eric);

        System.out.println(berlanga);

        berlanga.anyadirEstudiante(eric);

        //Estudiante esVacio = new Estudiante(null, 0, null);
        Instituto inVacio = new Instituto(null, null);

        System.out.println(inVacio);
    }
}
