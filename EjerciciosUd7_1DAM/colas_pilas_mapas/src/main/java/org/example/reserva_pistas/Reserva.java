package org.example.reserva_pistas;
import org.example.reserva_pistas.excepciones.UsuarioOrPistaDuplicatedException;
import org.example.reserva_pistas.pistas.Pista;
import org.example.reserva_pistas.usuarios.Usuario;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;

public class Reserva
{
    private Usuario usuario;
    private Pista pista;
    private LocalDateTime fechaPartido;

    public Reserva(Usuario usuario, Pista pista, LocalDateTime fechaPartido, HashSet<Reserva> listaReservas)
    {
        this.usuario = usuario;
        this.pista = pista;
        this.fechaPartido = fechaPartido;
        validarReserva(listaReservas);
    }

    private void validarReserva(HashSet<Reserva> listaReservas)
    {
        for(Reserva reserva : listaReservas)
            if(equals(reserva)) throw new UsuarioOrPistaDuplicatedException();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Pista getPista() {
        return pista;
    }

    public LocalDateTime getFechaPartido() {
        return fechaPartido;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Reserva reserva = (Reserva) obj;
        return (Objects.equals(usuario, reserva.usuario) && Objects.equals(fechaPartido, reserva.fechaPartido))
                || (Objects.equals(pista, reserva.pista) && Objects.equals(fechaPartido, reserva.fechaPartido));
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, pista, fechaPartido);
    }

    @Override
    public String toString()
    {
        return "Usuario: {"+ usuario +
                "}, Pista: {"+ pista +
                "}, Fecha del partido: "+ fechaPartido;
    }
}