package Model;

public class DoubleInvalidoException extends RuntimeException {
    public DoubleInvalidoException() {
        super("O atributo precisa ser de tipo double");
    }
}
