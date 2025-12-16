package Model;

public class Carro extends Veiculo implements Motor {

    public Carro(String modelo, double preco) {
        super(modelo, preco);
    }

    public boolean contains(CharSequence s) {
        return consumo.contains(s);
    }
    
    @Override
    protected boolean freia() {
        return super.freia();
    }

    @Override
    protected boolean acelera() {
        return super.acelera();
    }

}
