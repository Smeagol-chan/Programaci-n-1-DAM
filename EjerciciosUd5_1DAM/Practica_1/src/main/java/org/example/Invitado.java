package org.example;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * Clase dependiente de Programa.
 * @author ericr
 * @version 1.0 (06/02/2026)
 */
public class Invitado
{
    private static final int ANYO_MINIMO = 1950;
    private static final int ANYO_MAXIMO = 2026;
    private static final int MES_DIA_MINIMO = 1;
    private static final int MES_MAXIMO = 12;
    private static final int MES_31[] = {1, 3, 5, 7, 8, 10, 12};
    private static final int MES_30[] = {4, 6, 9, 11};
    private static final int DIA_MAXIMO_30 = 30;
    private static final int DIA_MAXIMO_28 = 28;

    private String nombre;
    private String profesion;
    private LocalDate fecha_visita;
    private int temporada;

    /**
     * Constructo de Invitado.
     * fecha_visita se inicializa con la fecha actual.
     * @param nombre - String con el nombre del invitado.
     * @param profesion - String con la profesión del invitado.
     * @param temporada - Entero con la temporada en la que el invitado apareció.
     */
    public Invitado(String nombre, String profesion, int temporada)
    {
        this.nombre = nombre;
        this.profesion = profesion;
        fecha_visita = LocalDate.now();
        this.temporada = temporada;
    }

    /**
     * Función que comprueba cuál es el día máximo del mes comprobando de qué mes se trata y si es un año bisiesto o no.
     * @param mes - Entero con el mes a comprobar.
     * @param any - Entero con el año a comprobar.
     * @return El número máximo posible de días: 31, 30, 29 ó 28.
     */
    private int diaMaximo(int mes, int any)
    {
        if(Arrays.asList(MES_31).contains(mes)) return DIA_MAXIMO_30+1;
        else if(Arrays.asList(MES_30).contains(mes)) return DIA_MAXIMO_30;
        else if(any%4 == 0) return DIA_MAXIMO_28+1;
        else return DIA_MAXIMO_28;
    }

    /**
     * Función que solicita al usuario la fecha cuando el invitado apareció.
     * Se valida que no supere la actual.
     * @return LocalDate válido.
     */
    private LocalDate solicitarFecha()
    {
        int any, mes, dia;
        LocalDate hoy = LocalDate.now(), fecha;
        boolean fallo;

        do
        {
            fallo = false;

            System.out.print("Introduzca el año cuando "+ nombre +" asistió al programa: ");
            any = FuncionesComunes.filtroLimitesInt(ANYO_MINIMO, ANYO_MAXIMO);
            System.out.print("Introduzca el mes cuando "+ nombre +" asistió al programa: ");
            mes = FuncionesComunes.filtroLimitesInt(MES_DIA_MINIMO, MES_MAXIMO);
            System.out.print("Introduzca el dia cuando "+ nombre +" asistió al programa: ");
            dia = FuncionesComunes.filtroLimitesInt(MES_DIA_MINIMO, diaMaximo(mes, any));
            fecha = LocalDate.of(any, mes, dia);

            if(fecha.isAfter(hoy))
            {
                System.out.println("Hoy es "+ hoy +". No se pueden añadir fechas futuras.");
                fallo = true;
            }
        }while(fallo);
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public LocalDate getFecha_visita() {
        return fecha_visita;
    }

    /**
     * Modicicación de setFecha_visita para solicitar desde esta clase la fecha a introducir.
     */
    public void setFecha_visita()
    {
        fecha_visita = solicitarFecha();
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    @Override
    public String toString() {
        return "Invitado{" +
                "nombre='" + nombre + '\'' +
                ", profesion='" + profesion + '\'' +
                ", fecha_visita=" + fecha_visita +
                ", temporada=" + temporada +
                '}';
    }
}
