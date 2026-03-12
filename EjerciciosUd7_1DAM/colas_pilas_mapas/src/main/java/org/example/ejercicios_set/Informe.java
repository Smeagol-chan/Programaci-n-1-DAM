package org.example.ejercicios_set;

public class Informe
{
    private static int totalInformes = 0;

    private int codigo;
    private TipoTarea descripcion;

    public Informe(String descripcion)
    {
        setDescripcion(descripcion);
        setCodigo();
    }

    public int getCodigo() {
        return codigo;
    }

    private void setCodigo() {
        codigo = ++totalInformes;
    }

    public TipoTarea getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = TipoTarea.valueOf(descripcion);
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
                ", Descripción: " + descripcion;
    }
}