package org.example.objetos;
import org.example.FuncionesComunes;

public class Estudiante
{
    private static int contadorEstudiantes = 0;
    private static final int CANTIDAD_NUMEROS_NIA = 8;

    private String nombre;
    private String curso;
    private String nia;
    private String email;

    public Estudiante(String nombre, String curso, String email)
    {
        this.nombre = nombre;
        this.curso = curso;
        nia = String.valueOf(++contadorEstudiantes);
        this.email = email;
    }

    public Estudiante(String nombre)
    {
        this(nombre, null, null);
    }

    private String generarNia()
    {
        String nia = "";
        for (int i = 0; i < CANTIDAD_NUMEROS_NIA; i++) nia += String.valueOf(FuncionesComunes.random.nextInt(10));
        return nia;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", nia='" + nia + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
