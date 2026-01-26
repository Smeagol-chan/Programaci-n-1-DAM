package org.example.prestamo_estudiante_libro;

public class Editorial
{
    private String nombre;
    private String pais;

    public Editorial(String nombre, String pais)
    {
        this.nombre = nombre;
        this.pais = pais;
    }

    public Editorial(){}

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
