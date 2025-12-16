package Model;

public class Veiculo {

    public String modelo;
    public double preco;

    public Veiculo(String modelo, double preco) {
        this.modelo = modelo;
        this.preco = preco;
    }
    
    protected boolean acelera(){
        return true;
    }
    
    protected boolean freia(){
        return false;
    }  
}
