package org.example.app;
import org.example.objetos.Bocadillo;

/**
 * Pruebas sobre el objeto Bocadillo, el primero creado en el curso.
 */
public class BocadilloApp
{
    static void main()
    {
        Bocadillo pollo = new Bocadillo("pollo", "integral", "pollo, lechuga, huevo", "mayonesa", 5.5);
        Bocadillo pepito = new Bocadillo("pepito", "baguette", "ternera", "mantequilla", 4);
        Bocadillo personalizable = new Bocadillo();

        System.out.println(pepito.getNombre());
        System.out.println();
        pollo.imprimirBocadillo();
        System.out.println();
        personalizable.imprimirBocadillo();
        System.out.println();

        personalizable.setNombre("salchichas con tomate");
        personalizable.setIngredientes("salchichas, pimiento, huevo");
        personalizable.setSalsa("mayonesa");
        personalizable.imprimirBocadillo();
    }
}
