package Model;

public class InteiroInvalidoException extends RuntimeException {
    public InteiroInvalidoException() {
        super("O atributo precisa ser de tipo inteiro");
    }
}
