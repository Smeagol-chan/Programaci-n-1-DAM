package org.example.biblioteca;

public class LibroApp
{
    static void main()
    {
        Editorial nova = new Editorial("Nova", "España");
        Libro tf = new Libro("Trilogía Fundación", "Isaac Asimov", nova);
        System.out.println(tf);
    }
}
