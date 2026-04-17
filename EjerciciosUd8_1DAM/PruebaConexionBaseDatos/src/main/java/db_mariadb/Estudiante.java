package db_mariadb;

import java.util.Date;
import java.util.Objects;

public class Estudiante
{
    private String nia;
    private String nombre;
    private Date fechaNacimiento;

    public Estudiante(String nia, String nombre, Date fechaNacimiento)
    {
        this.nia = nia;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNia() {
        return nia;
    }

    public void setNia(String nia) {
        this.nia = nia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return Objects.equals(nia, that.nia);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(nia);
    }
}
