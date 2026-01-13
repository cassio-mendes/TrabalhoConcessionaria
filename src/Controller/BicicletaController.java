package Controller;

import Dao.ManipulaArquivo;
import java.io.IOException;

public class BicicletaController {

    private static final ManipulaArquivo MANIPULA_ARQUIVO = new ManipulaArquivo();

    public static boolean cadastrarBicicleta(String modelo, String cor, Double preco, String acessorio) {
        try {
            MANIPULA_ARQUIVO.cadastraBicicleta(modelo, preco, cor, acessorio);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
}
