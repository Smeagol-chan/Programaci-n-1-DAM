package org.example.biblioteca;

public class Estudiante
{
    private static final String CORREO_FORMAT = "^[A-Za-z0-9+_.-]+@alu.edu.gva.es$";
    private static int contadorEstudiantes = 0;

    private String nombre;
    private String curso;
    private String nia;
    private String email;
    private Libro libro;

    public Estudiante()
    {
    }

    public Estudiante(String nombre, String curso, String email)
    {
        this.nombre = nombre;
        this.curso = curso;
        setNia();
        this.email = email;
    }

    public Estudiante(String nombre)
    {
        this(nombre, null, null);
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

    public static boolean validarCorreo(String email)
    {
        return email.matches(CORREO_FORMAT);
    }

    public static int obtenerTotalEstudiantes()
    {
        return contadorEstudiantes;
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

    public String getNia() {
        return nia;
    }

    private void setNia() {
        nia = String.valueOf(++contadorEstudiantes);
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
