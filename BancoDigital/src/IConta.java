public interface IConta {
    void depositar(double valor);
    boolean sacar(double valor);
    boolean transferir(IConta contaDestino, double valor);
    void verExtrato();
    double getSaldo();
    String getNumero();
}