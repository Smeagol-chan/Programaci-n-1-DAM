package org.example.bateria_herencias.introduccion;

public class Concierto {
    public static void main() {

        Asistente a1 = new Asistente("Carlos", 25, "VIP");
        Artista art1 = new Artista("Dua Lipa", 28, "Pop");
        Organizador org1 = new Organizador("Roberto Mars", 47, "Productor");

        System.out.println("Información del asistente:");
        a1.mostrarInfo();

        System.out.println();

        System.out.println("Información del artista:");
        art1.mostrarInfo();

        System.out.println();

        System.out.println("Información del organizador:");
        org1.mostrarInfo();
    }
}