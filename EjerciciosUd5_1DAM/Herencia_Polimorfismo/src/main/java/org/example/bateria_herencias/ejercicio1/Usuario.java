package org.example.bateria_herencias.ejercicio1;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Usuario
{
    private String nombre;
    private int edad;
    private String nombreUsuario;
    private int seguidores;

    public Usuario(String nombre, int edad, String nombreUsuario, int seguidores)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.nombreUsuario = nombreUsuario;
        this.seguidores = seguidores;
    }

    public void mostrarInfo()
    {
        System.out.println("Nombre: "+ nombre);
        System.out.println("Edad: "+ edad);
        System.out.println("Nombre de usuario: "+ nombreUsuario);
        System.out.println("Número de seguidores: "+ seguidores);
    }
}
