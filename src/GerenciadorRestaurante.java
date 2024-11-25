import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorRestaurante {
    private ArrayList<Cliente> clientes;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Pedido> pedidos;

    public GerenciadorRestaurante() {
        this.clientes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void cadastrarCliente(String nome, String cpf, String telefone, int numeroMesa) {
        Cliente cliente = new Cliente(nome, cpf, telefone, numeroMesa);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void cadastrarFuncionario(String nome, String cpf, String telefone, String cargo, double salario) {
        Funcionario funcionario = new Funcionario(nome, cpf, telefone, cargo, salario);
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public void listarClientes() {
        System.out.println("\n=== Lista de Clientes ===");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println((i + 1) + ". " + clientes.get(i));
            }
        }
    }

    public void listarFuncionarios() {
        System.out.println("\n=== Lista de Funcionários ===");
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (int i = 0; i < funcionarios.size(); i++) {
                System.out.println((i + 1) + ". " + funcionarios.get(i));
            }
        }
    }

    public void criarPedido(int clienteIndex, int funcionarioIndex) {
        if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
            System.out.println("Cliente inválido!");
            return;
        }
        if (funcionarioIndex < 0 || funcionarioIndex >= funcionarios.size()) {
            System.out.println("Funcionário inválido!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        Cliente cliente = clientes.get(clienteIndex);
        Funcionario funcionario = funcionarios.get(funcionarioIndex);

        Pedido pedido = new Pedido(pedidos.size() + 1);
        pedido.setFuncionarioResponsavel(funcionario);

        System.out.println("Adicione itens ao pedido:");
        boolean adicionarMais = true;

        while (adicionarMais) {
            System.out.print("Nome do item: ");
            String nomeItem = scanner.nextLine();
            System.out.print("Preço do item: ");
            double precoItem = scanner.nextDouble();
            scanner.nextLine();

            pedido.adicionarItem(new ItemMenu(nomeItem, precoItem));

            System.out.print("Deseja adicionar mais itens? (s/n): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n")) {
                adicionarMais = false;
            }
        }

        pedidos.add(pedido);
        System.out.println("Pedido criado com sucesso para o cliente " + cliente.getNome() + "!");
    }

    public void listarPedidos() {
        System.out.println("\n=== Lista de Pedidos ===");
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }
}
