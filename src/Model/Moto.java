package Model;

public class Moto extends Veiculo implements Motorizado {

    private double consumoCombustivel;
    private boolean carenagem;

    public Moto(String modelo, double preco, String cor, double consumoCombustivel, boolean carenagem) {
        super(modelo, preco, cor);
        this.consumoCombustivel = consumoCombustivel;
        this.carenagem = carenagem;
    }

    @Override
    public double calcularConsumo() {
        return this.consumoCombustivel;
    }
}
