package org.example.objetos;

/**
 * Objeto ejercicios
 */
public class Persona
{
    private String nombre;
    private String dni;
    private int edad;
    private String profesion;
    private String ciudad;

    public Persona (String nombre, String dni, int edad, String profesion, String ciudad)
    {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.profesion = profesion;
        this.ciudad = ciudad;
    }

    public Persona (){}

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void imprimirDatos()
    {
        System.out.println("Nombre: "+ nombre);
        System.out.println("DNI: "+ dni);
        System.out.println("Edad: "+ edad);
        System.out.println("Profesión: "+ profesion);
        System.out.println("Ciudad de residencia: "+ ciudad);
    }
}
