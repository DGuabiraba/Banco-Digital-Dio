public class ContaCorrente extends Conta {
    public ContaCorrente(String numero) {
        super(numero);
    }

	@Override
	public boolean transferir(IConta contaDestino, double valor) {
		
		throw new UnsupportedOperationException("Unimplemented method 'transferir'");
	}
}
