package org.example.prestamo_estudiante_libro;

public class Estudiante
{
    private static final String DEF_EMAIL = "alu_X@alu.edu.gva.es";
    private static final String CORREO_FORMAT = "^[A-Za-z0-9+_.-]+@alu.edu.gva.es$";
    private static final int DIGITOS_NIA = 8;
    private static int contadorEstudiantes = 0;

    private String nombre;
    private String curso;
    private String nia;
    private String email;
    private Libro libro;

    public Estudiante(String nombre, String curso, String email)
    {
        if(limiteSuperado())
        {
            this.nombre = nombre;
            this.curso = curso;
            setNia();
            setEmail(email);
        }
        else System.out.println("ERROR\nLímite de estudiantes alcanzado.");
    }

    public Estudiante()
    {
        this(null, null, null);
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

    public String getNia() {
        return nia;
    }

    private void setNia() {
        nia = generarNia();
    }

    public String getEmail() {
        return email;
    }

    protected void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setEmail(String email) {
        if(validarEmail(email)) this.email = email;
        else
        {
            this.email = emailDefecto();
            System.out.println("Email con formato incorrecto.\n" +
                    "Se ha generado un email por defecto.");
        }
    }

    private static String generarNia()
    {
        String nia = String.valueOf(++contadorEstudiantes);
        while(nia.length() < DIGITOS_NIA) nia = "0" + nia;
        return nia;
    }

    private static boolean limiteSuperado()
    {
        return String.valueOf(contadorEstudiantes+1).length() > DIGITOS_NIA;
    }

    public static boolean validarEmail(String email){
        return email.matches(CORREO_FORMAT);
    }

    private String emailDefecto()
    {
        int numNia = Integer.parseInt(nia);
        return DEF_EMAIL.replace("X", String.valueOf(numNia));
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", nia='" + nia + '\'' +
                ", email='" + email + '\'' +
                ", libro=" + libro +
                '}';
    }
}