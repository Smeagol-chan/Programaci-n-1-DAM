package org.example.ejercicios_stringbuilder;

public class IntroStringBuilder
{
    static void main()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Calleu ");
        sb.append("mantecao ").append("Joaquín!!"). append(" adiós");
        sb.append(" ¿Qué queréis en el examen? ");
        sb.append("Si os grita...");
        System.out.println(sb);

        sb.insert(16, "de limón ");
        System.out.println(sb);

        sb.replace(25, 34, "Jacobo");
        System.out.println(sb);

        sb.delete(25, 32);
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);
    }
}
