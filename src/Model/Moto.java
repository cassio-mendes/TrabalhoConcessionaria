package Model;

public class Moto extends Veiculo implements Motor {

    public Moto(String modelo, double preco) {
        super(modelo, preco);
    }

    public boolean contains(CharSequence s) {
        return consumo.contains(s);
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
