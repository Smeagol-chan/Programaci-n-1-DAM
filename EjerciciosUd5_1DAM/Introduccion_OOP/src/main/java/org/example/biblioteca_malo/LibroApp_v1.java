package org.example.biblioteca_malo;

public class LibroApp_v1
{
    static void main()
    {
        Editorial_v1 nova = new Editorial_v1("Nova", "España");
        Libro_v1 tf = new Libro_v1("Trilogía Fundación", "Isaac Asimov", nova);
        System.out.println(tf);
    }
}
