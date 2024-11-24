import java.util.ArrayList;

public class Pedido {
    private int id;
    private ArrayList<ItemMenu> itens;
    private double valorTotal;
    private Funcionario funcionarioResponsavel;

    public Pedido(int id) {
        this.id = id;
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public void adicionarItem(ItemMenu item) {
        itens.add(item);
        valorTotal += item.getPreco();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        StringBuilder detalhes = new StringBuilder();
        detalhes.append("Pedido ID: ").append(id).append("\nItens:\n");
        for (ItemMenu item : itens) {
            detalhes.append(item).append("\n");
        }
        detalhes.append("Valor Total: ").append(valorTotal).append("\n");
        if (funcionarioResponsavel != null) {
            detalhes.append("Atendido por: ").append(funcionarioResponsavel.getNome());
        } else {
            detalhes.append("Sem funcionário responsável.");
        }
        return detalhes.toString();
    }

    public void setFuncionarioResponsavel(Funcionario funcionario) {
        this.funcionarioResponsavel = funcionario;
    }
}
