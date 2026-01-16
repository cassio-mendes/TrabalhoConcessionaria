package Model;

public class Moto extends Veiculo implements Motorizado {

    private final double  consumoCombustivel;
    private final boolean carenagem;

    public Moto(String modelo, double preco, String cor, double consumoCombustivel, boolean carenagem) {
        super(modelo, preco, cor);
        this.consumoCombustivel = consumoCombustivel;
        this.carenagem = carenagem;
    }

    public Moto(String modelo, double preco, String cor, double consumoCombustivel) {
        super(modelo, preco, cor);
        this.consumoCombustivel = consumoCombustivel;
        this.carenagem = false;
    }

    @Override
    public double calcularConsumo() {
        return this.consumoCombustivel;
    }

    public boolean isCarenagem() {
        return carenagem;
    }

}
