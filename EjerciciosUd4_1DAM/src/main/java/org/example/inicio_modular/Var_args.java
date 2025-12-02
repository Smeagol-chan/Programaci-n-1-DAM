package org.example.inicio_modular;

public class Var_args
{
    //SE DECLARA EL ÚLTIMO
    private static void varArgs(String... nombre)
    {
        for(String fila : nombre)
        {
            System.out.println(fila);
        }
    }

    static void main()
    {
        varArgs("Carlos", "Jose", "Amparo");
    }
}
