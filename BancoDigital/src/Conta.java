import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
    private String numero;
    private double saldo;
    private List<Transacao> transacoes;

    public Conta(String numero) {
        this.numero = numero;
        this.saldo = 0.0;
        this.transacoes = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        transacoes.add(new Transacao("Depósito", valor));
    }

    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            transacoes.add(new Transacao("Saque", valor));
            return true;
        }
        return false;
    }

    public boolean transferir(Conta contaDestino, double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            contaDestino.depositar(valor);
            transacoes.add(new Transacao("Transferência para " + contaDestino.getNumero(), valor));
            contaDestino.getTransacoes().add(new Transacao("Transferência de " + this.numero, valor));
            return true;
        }
        return false;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void verExtrato() {
        System.out.println("Extrato da conta " + numero + ":");
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
        System.out.println("Saldo atual: R$ " + saldo);
    }
}
