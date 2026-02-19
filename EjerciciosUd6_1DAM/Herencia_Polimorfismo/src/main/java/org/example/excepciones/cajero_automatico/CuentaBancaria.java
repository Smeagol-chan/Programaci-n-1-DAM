package org.example.excepciones.cajero_automatico;

public class CuentaBancaria
{
    private static final double MAXIMO_INGRESO = 3000;
    private static final double LIMITE_RETIRADA_DIARIA = 600;
    private static final double DEFAULT_SALDO_RETIRADA_DIARIA = 0;

    private double saldo;
    private double retiradaDiaria;

    public CuentaBancaria()
    {
        saldo = DEFAULT_SALDO_RETIRADA_DIARIA;
        retiradaDiaria = DEFAULT_SALDO_RETIRADA_DIARIA;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getRetiradaDiaria() {
        return retiradaDiaria;
    }

    private void setRetiradaDiaria(double retiradaDiaria) {
        this.retiradaDiaria = retiradaDiaria;
    }

    public void ingresarDinero(double importe)
    {
        if(importe > MAXIMO_INGRESO) throw new DepositoMaximoException();
        else
        {
            setSaldo(saldo + importe);
            System.out.println("Dinero ingresado con éxito. Saldo actual: "+ saldo +"€");
        }
    }

    public void retirarDinero(double importe)
    {
        if(saldo < importe) throw new SaldoInsuficienteException();
        else if(retiradaDiaria + importe > LIMITE_RETIRADA_DIARIA) throw new DepositoMaximoException();
        else
        {
            setSaldo(saldo - importe);
            setRetiradaDiaria(retiradaDiaria + importe);
            System.out.println("Dinero retirado con éxito. Saldo actual: "+ saldo +"€");
        }
    }

    public void consultarSaldo()
    {
        System.out.println("Saldo disponible: "+ saldo);
    }
}
