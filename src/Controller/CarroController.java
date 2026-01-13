package Controller;

import Dao.ManipulaArquivo;
import java.io.IOException;

public class CarroController {

    private static final ManipulaArquivo MANIPULA_ARQUIVO = new ManipulaArquivo();

    public static boolean cadastrarCarro(String modelo, String cor, Double preco,
                                         Double consumoCombustivel, Integer numAssentos) {
        try {
            MANIPULA_ARQUIVO.cadastraCarro(modelo, preco, cor, consumoCombustivel, numAssentos);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
