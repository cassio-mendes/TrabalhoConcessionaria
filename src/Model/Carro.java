package Model;

public class Carro extends Veiculo implements Motorizado {

    private final double consumoCombustivel;
    private final int numeroAssentos;

    public Carro(String modelo, double preco, String cor, double consumoCombustivel, int numeroAssentos) {
        super(modelo, preco, cor);
        this.consumoCombustivel = consumoCombustivel;
        this.numeroAssentos = numeroAssentos;
    }

    @Override
    public double calcularConsumo() {
        return this.consumoCombustivel;
    }

    public int getNumeroAssentos() {
        return this.numeroAssentos;
    }

}
