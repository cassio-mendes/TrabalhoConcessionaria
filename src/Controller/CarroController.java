package Controller;

import Dao.ManipulaArquivo;
import java.io.IOException;

public class CarroController {

    private static ManipulaArquivo manipulaArquivo = new ManipulaArquivo();

    public static boolean cadastrarCarro(String modelo, String cor, Double preco,
                                         Double consumoCombustivel, Integer numAssentos) {
        try {
            manipulaArquivo.cadastraCarro(modelo, preco, cor, consumoCombustivel, numAssentos);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
