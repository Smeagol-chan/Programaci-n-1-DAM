package org.example.biblioteca_malo;

public class Estudiante_v1
{
    private static final String CORREO_FORMAT = "^[A-Za-z0-9+_.-]+@alu.edu.gva.es$";
    private static int contadorEstudiantes = 0;

    private String nombre;
    private String curso;
    private String nia;
    private String email;
    private Libro_v1 libroV1;

    public Estudiante_v1()
    {
    }

    public Estudiante_v1(String nombre, String curso, String email)
    {
        this.nombre = nombre;
        this.curso = curso;
        setNia();
        this.email = email;
    }

    public Estudiante_v1(String nombre)
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

    public Libro_v1 getLibro() {
        return libroV1;
    }

    public void setLibro(Libro_v1 libroV1) {
        this.libroV1 = libroV1;
    }
}
