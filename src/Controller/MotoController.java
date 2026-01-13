package Controller;

import Dao.ManipulaArquivo;
import java.io.IOException;

public class MotoController {

    private static final ManipulaArquivo MANIPULA_ARQUIVO = new ManipulaArquivo();

    public static boolean cadastrarMoto(String modelo, String cor, Double preco,
                                        Double consumoCombustivel, Boolean carenagem) {
        try {
            MANIPULA_ARQUIVO.cadastraMoto(modelo, preco, cor, consumoCombustivel, carenagem);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
