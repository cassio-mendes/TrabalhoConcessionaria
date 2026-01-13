package Model;

public abstract class Veiculo {

    protected String modelo;
    protected double preco;
    protected String cor;

    public Veiculo(String modelo, double preco, String cor) {
        this.modelo = modelo;
        this.preco = preco;
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPreco() {
        return preco;
    }

    public String getCor() {
        return cor;
    }
}
