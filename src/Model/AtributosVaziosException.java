package Model;

public class AtributosVaziosException extends RuntimeException {
    public AtributosVaziosException() {
        super("O atributo não pode estar vazio");
    }
}
