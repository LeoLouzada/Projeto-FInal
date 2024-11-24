import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorRestaurante gerenciador = new GerenciadorRestaurante();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Sistema de Restaurante ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Funcionário");
            System.out.println("3. Listar Clientes");
            System.out.println("4. Listar Funcionários");
            System.out.println("5. Criar Pedido");
            System.out.println("6. Listar Pedidos");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n=== Cadastro de Cliente ===");
                    System.out.print("Nome: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpfCliente = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefoneCliente = scanner.nextLine();
                    System.out.print("Número da Mesa: ");
                    int numeroMesa = scanner.nextInt();
                    gerenciador.cadastrarCliente(nomeCliente, cpfCliente, telefoneCliente, numeroMesa);
                    break;

                case 2:
                    System.out.println("\n=== Cadastro de Funcionário ===");
                    System.out.print("Nome: ");
                    String nomeFuncionario = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpfFuncionario = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefoneFuncionario = scanner.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();
                    System.out.print("Salário: ");
                    double salario = scanner.nextDouble();
                    gerenciador.cadastrarFuncionario(nomeFuncionario, cpfFuncionario, telefoneFuncionario, cargo, salario);
                    break;

                case 3:
                    gerenciador.listarClientes();
                    break;

                case 4:
                    gerenciador.listarFuncionarios();
                    break;

                case 5:
                    System.out.println("\n=== Criar Pedido ===");
                    gerenciador.listarClientes();
                    System.out.print("Escolha o cliente pelo número: ");
                    int clienteIndex = scanner.nextInt() - 1;

                    gerenciador.listarFuncionarios();
                    System.out.print("Escolha o funcionário pelo número: ");
                    int funcionarioIndex = scanner.nextInt() - 1;

                    gerenciador.criarPedido(clienteIndex, funcionarioIndex);
                    break;

                case 6:
                    gerenciador.listarPedidos();
                    break;

                case 7:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);

        scanner.close();
    }
}
