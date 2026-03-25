package org.example.acepta_reto;
import java.util.*;

public class CapturaDrMuerte
{
    public static Scanner key = new Scanner(System.in);

    public static boolean casoDePrueba() {
        int barraVida = key.nextInt();
        if (barraVida == 0)
            return false;
        else
        {
            int numArmas = key.nextInt();
            Arma armaQueUsar;
            ArrayList<Arma> listaArmas = new ArrayList<>();
            Queue<Integer> ordenUso = new LinkedList<>();

            for(int i = 1; i <= numArmas; i++)
            {
                listaArmas.addLast(new Arma(i, key.nextInt(), key.nextInt()));
            }

            while(!listaArmas.isEmpty())
            {
                armaQueUsar = new Arma(0, 10000, 0);
                for(int i = 0; i < listaArmas.size(); i++)
                {
                    if(armaQueUsar.getDanyoCiviles() > listaArmas.get(i).getDanyoCiviles())
                    {
                        armaQueUsar = listaArmas.get(i);
                    }
                    else if(armaQueUsar.getDanyoCiviles() == listaArmas.get(i).getDanyoCiviles()
                            && armaQueUsar.getDanyoEnemigos() < listaArmas.get(i).getDanyoEnemigos())
                    {
                        armaQueUsar = listaArmas.get(i);
                    }
                }
                if(armaQueUsar.getId() == 0) break;
                else
                {
                    ordenUso.offer(armaQueUsar.getId());
                    listaArmas.remove(armaQueUsar);
                    barraVida -= armaQueUsar.getDanyoEnemigos();
                    if(barraVida <= 0) break;
                }
            }

            if(barraVida <= 0)
            {
                while(!ordenUso.isEmpty())
                    System.out.print(ordenUso.poll() +" ");
                System.out.println();
            }
            else System.out.println("MUERTE ESCAPA");
            return true;
        }
    }

    public static void main(String[] args) {
        while (casoDePrueba()) {
        }
    }
}

class Arma
{
    private int id;
    private int danyoCiviles;
    private int danyoEnemigos;

    public Arma(int id, int danyoCiviles, int danyoEnemigos)
    {
        this.id = id;
        this.danyoCiviles = danyoCiviles;
        this.danyoEnemigos = danyoEnemigos;
    }

    public int getId() {
        return id;
    }

    public int getDanyoCiviles() {
        return danyoCiviles;
    }

    public int getDanyoEnemigos() {
        return danyoEnemigos;
    }
}