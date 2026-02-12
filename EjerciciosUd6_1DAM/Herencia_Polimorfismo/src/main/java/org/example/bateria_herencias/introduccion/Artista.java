package org.example.bateria_herencias.introduccion;

//subclase que también hereda de Persona
class Artista extends Persona {

    String generoMusical;

    public Artista(String nombre, int edad, String generoMusical) {
        super(nombre, edad);
        this.generoMusical = generoMusical;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Género Musical: " + generoMusical);
    }

}