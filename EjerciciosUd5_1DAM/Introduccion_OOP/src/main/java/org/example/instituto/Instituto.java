package org.example.instituto;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.Objects;

@Getter
@ToString
public class Instituto
{
    private String nombre;
    @Setter
    private String poblacion;
    private ArrayList<Estudiante> listaEstudiantes;
    private ArrayList<Curso> listaCursos;

    public Instituto(String nombre, String poblacion)
    {
        this.nombre = Objects.requireNonNullElse(nombre, "Instituto sin nombre");
        this.poblacion = poblacion;
        listaEstudiantes = new ArrayList<>();
        listaCursos = new ArrayList<>();
    }

    private boolean estudianteDuplicado(Estudiante estudiante)
    {
        return listaEstudiantes.contains(estudiante);
    }

    private boolean cursoDuplicado(Curso curso)
    {
        return listaCursos.contains(curso);
    }

    public void anyadirCurso(@NonNull Curso curso)
    {
        if(cursoDuplicado(curso)) System.out.println("El curso ya se encuentra listado.");
        else listaCursos.add(curso);
    }

    public void borrarCurso(@NonNull Curso curso)
    {
        if(cursoDuplicado(curso)) listaCursos.remove(curso);
        else System.out.println("El curso no está en la lista.");
    }

    public void anyadirEstudiante(@NonNull Estudiante estudiante)
    {
        if(estudianteDuplicado(estudiante)) System.out.println("El estudiante ya se encuentra listado.");
        else listaEstudiantes.add(estudiante);
    }

    public void borrarEstudiante(@NonNull Estudiante estudiante)
    {
        if(estudianteDuplicado(estudiante)) listaEstudiantes.remove(estudiante);
        else System.out.println("El estudiante no está en la lista.");
    }
}