package org.example.dispositivos_inteligentes;
import java.util.ArrayList;

public class DispositivosApp
{
    static void main()
    {
        Televisor televisor = new Televisor("Tele");
        ParlanteInteligente parlante = new ParlanteInteligente("Altavoz");
        AireAcondicionado ac = new AireAcondicionado("Aire acondicionado");

        Dispositivo microondas = ClasesAnonimas.claseAnonima();
        Dispositivo horno = ClasesAnonimas.anomHorno();
        Dispositivo endencer_proyector = ClasesAnonimas.anomProyector();
        ControlRemoto sinc_proyector = ClasesAnonimas.sincProyector();

        ArrayList<Dispositivo> listaDispositivos = new ArrayList<>();
        listaDispositivos.add(televisor);
        listaDispositivos.add(parlante);
        listaDispositivos.add(ac);
        listaDispositivos.add(microondas);
        listaDispositivos.add(endencer_proyector);
        listaDispositivos.add(horno);

        for(Dispositivo dispositivo : listaDispositivos)
        {
            dispositivo.encender();
//            if(dispositivo instanceof ControlRemoto)
//                ((ControlRemoto) dispositivo).sincronizar();
            if(dispositivo instanceof Televisor || dispositivo instanceof AireAcondicionado)
                ((ControlRemoto) dispositivo).sincronizar();
            else if(dispositivo.getNombre().equals("Proyector"))
                sinc_proyector.sincronizar();
            dispositivo.mostrarEstado();
            dispositivo.apagar();
            System.out.println();
        }
    }
}
