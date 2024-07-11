import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {
    private HashMap<String, Cliente> clientes;

    public Banco() {
        this.clientes = new HashMap<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.put(cliente.getConta().getNumero(), cliente);
    }

    public Cliente buscarCliente(String numeroConta) {
        return clientes.get(numeroConta);
    }

    public List<Cliente> listarClientes() {
        return clientes.values().stream().collect(Collectors.toList());
    }

    public boolean transferir(String numeroContaOrigem, String numeroContaDestino, double valor) {
        Cliente clienteOrigem = buscarCliente(numeroContaOrigem);
        Cliente clienteDestino = buscarCliente(numeroContaDestino);
        
        if (clienteOrigem != null && clienteDestino != null) {
            return clienteOrigem.getConta().transferir(clienteDestino.getConta(), valor);
        }
        
        return false;
    }
}


