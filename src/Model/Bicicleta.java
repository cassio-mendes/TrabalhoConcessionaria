package Model;

public class Bicicleta extends Veiculo {

    public String acessorio;

    public Bicicleta(String acessorio, String modelo, double preco, String cor) {
        super(modelo, preco, cor);
        this.acessorio = acessorio;
    }

    public String getAcessorio() {
        return acessorio;
    }
}
