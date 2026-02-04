package org.example.instituto;
import lombok.*;

@ToString
@Setter @Getter
@AllArgsConstructor
public class Curso
{
    @NonNull
    private String nombre;
    private int horas;

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }
}
