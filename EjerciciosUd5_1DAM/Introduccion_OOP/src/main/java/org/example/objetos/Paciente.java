package org.example.objetos;
import java.util.Random;

public class Paciente
{
    private static char DEF_SEXO = 'X';
    private static int PESO_BAJO = -1;
    private static int PESO_IDEAL = 0;
    private static int PESO_ALTO = 1;
    public static Random random = new Random();

    private String nombre;
    private int edad;
    private String dni;
    private char sexo;
    private double peso;
    private double altura;

    public Paciente()
    {
        dni = generarDNI();
        sexo = DEF_SEXO;
    }

    public Paciente(String nombre, int edad, char sexo, double peso, int altura)
    {
        this.nombre = nombre;
        this.edad = edad;
        this();
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public Paciente(String nombre, int edad, char sexo)
    {
        this();
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    private static String generarDNI()
    {
        String dni = "";
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
                'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
                'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        for (int i = 0; i < 8; i++) dni += String.valueOf(random.nextInt(10));
        dni += letras[Integer.parseInt(dni)%23];

        return dni;
    }

    public void datosPacientes()
    {
        System.out.println();
        System.out.println("Nombre: "+ nombre);
        System.out.println("Edad: "+ edad);
        System.out.println("DNI: "+ dni);
        System.out.println("Sexo: "+ sexo);
        System.out.println("Peso: "+ peso);
        System.out.println("Altura: "+ altura);
    }

    //No está funcionando
    public int calcularMC()
    {
        if(peso/Math.pow(altura, 2) < 20) return PESO_BAJO;
        else if(peso / Math.pow(altura, 2) > 25) return PESO_ALTO;
        else return PESO_IDEAL;
    }
}