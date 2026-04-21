package org.example.practica2;

import java.time.LocalDate;
import java.util.Objects;

public class Estudiante
{
    private String nia;
    private String nombre;
    private LocalDate fechaNacimiento;

    public Estudiante(String nia, String nombre, LocalDate fechaNacimiento)
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

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return Objects.equals(nia, that.nia);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nia);
    }
}