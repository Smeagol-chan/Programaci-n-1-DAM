package org.example.instituto;
import lombok.*;

@ToString
@Getter @Setter
@AllArgsConstructor
public class Estudiante
{
    @NonNull
    private String nombre;
    private int edad;
    private Curso curso;

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }
}
