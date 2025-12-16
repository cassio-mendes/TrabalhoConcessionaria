package Model;

public class Bicicleta extends Veiculo {

    public String acessorio;

    public Bicicleta(String acessorio, String modelo, double preco) {
        super(modelo, preco);
        this.acessorio = acessorio;
    }

    @Override
    protected boolean acelera() {
        return super.acelera();
    }

    @Override
    protected boolean freia() {
        return super.freia();
    }

}
