public class Cliente extends Pessoa {
    private int numeroMesa;

    public Cliente(String nome, String cpf, String telefone, int numeroMesa) {
        super(nome, cpf, telefone);
        this.numeroMesa = numeroMesa;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    @Override
    public String toString() {
        return super.toString() + ", Número da Mesa: " + numeroMesa;
    }
}
