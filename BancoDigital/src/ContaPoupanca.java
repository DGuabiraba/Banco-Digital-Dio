public class ContaPoupanca extends Conta {
    public ContaPoupanca(String numero) {
        super(numero);
    }

	@Override
	public boolean transferir(IConta contaDestino, double valor) {
		
		throw new UnsupportedOperationException("Unimplemented method 'transferir'");
	}
}
