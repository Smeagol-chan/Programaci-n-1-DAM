package org.example.reserva_pistas;
import org.example.reserva_pistas.pistas.Pista;
import org.example.reserva_pistas.usuarios.Usuario;

import java.time.LocalDateTime;

public class Reserva
{
    private Usuario usuario;
    private Pista pista;
    private LocalDateTime fechaPastido;

    public Reserva(Usuario usuario, Pista pista, LocalDateTime fechaPastido)
    {

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pista getPista() {
        return pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }

    public LocalDateTime getFechaPastido() {
        return fechaPastido;
    }

    public void setFechaPastido(LocalDateTime fechaPastido) {
        this.fechaPastido = fechaPastido;
    }
}
