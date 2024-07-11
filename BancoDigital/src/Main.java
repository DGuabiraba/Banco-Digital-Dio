import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Conta Corrente");
            System.out.println("2. Adicionar Conta Poupança");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Ver Extrato");
            System.out.println("7. Listar Contas");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nomeCC = scanner.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpfCC = scanner.nextLine();
                    System.out.print("Número da conta corrente: ");
                    String numeroCC = scanner.nextLine();
                    ContaCorrente cc = new ContaCorrente(numeroCC);
                    Cliente clienteCC = new Cliente(nomeCC, cpfCC, cc);
                    banco.adicionarCliente(clienteCC);
                    System.out.println("Conta corrente adicionada.");
                    break;
                case 2:
                    System.out.print("Nome do cliente: ");
                    String nomeCP = scanner.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpfCP = scanner.nextLine();
                    System.out.print("Número da conta poupança: ");
                    String numeroCP = scanner.nextLine();
                    ContaPoupanca cp = new ContaPoupanca(numeroCP);
                    Cliente clienteCP = new Cliente(nomeCP, cpfCP, cp);
                    banco.adicionarCliente(clienteCP);
                    System.out.println("Conta poupança adicionada.");
                    break;
                case 3:
                    System.out.print("Número da conta: ");
                    String numeroDeposito = scanner.nextLine();
                    Cliente clienteDeposito = banco.buscarCliente(numeroDeposito);
                    if (clienteDeposito != null) {
                        System.out.print("Valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        clienteDeposito.getConta().depositar(valorDeposito);
                        System.out.println("Depósito realizado.");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Número da conta: ");
                    String numeroSaque = scanner.nextLine();
                    Cliente clienteSaque = banco.buscarCliente(numeroSaque);
                    if (clienteSaque != null) {
                        System.out.print("Valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        if (clienteSaque.getConta().sacar(valorSaque)) {
                            System.out.println("Saque realizado.");
                        } else {
                            System.out.println("Saldo insuficiente.");
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 5:
                    System.out.print("Número da conta de origem: ");
                    String numeroOrigem = scanner.nextLine();
                    System.out.print("Número da conta de destino: ");
                    String numeroDestino = scanner.nextLine();
                    System.out.print("Valor da transferência: ");
                    double valorTransferencia = scanner.nextDouble();
                    if (banco.transferir(numeroOrigem, numeroDestino, valorTransferencia)) {
                        System.out.println("Transferência realizada.");
                    } else {
                        System.out.println("Transferência não realizada. Verifique os números das contas e o saldo disponível.");
                    }
                    break;
                case 6:
                    System.out.print("Número da conta: ");
                    String numeroExtrato = scanner.nextLine();
                    Cliente clienteExtrato = banco.buscarCliente(numeroExtrato);
                    if (clienteExtrato != null) {
                        clienteExtrato.getConta().verExtrato();
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 7:
                    System.out.println("Listando todas as contas:");
                    for (Cliente cliente : banco.listarClientes()) {
                        Conta conta = cliente.getConta();
                        System.out.println("Número da conta: " + conta.getNumero() + 
                                           ", Saldo: R$ " + conta.getSaldo() + 
                                           ", Nome do cliente: " + cliente.getNome() + 
                                           ", CPF do cliente: " + cliente.getCpf());
                    }
                    break;
                case 8:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
