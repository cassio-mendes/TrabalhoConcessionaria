package Controller;

import Dao.ManipulaArquivo;
import Model.Bicicleta;

import java.io.IOException;

public class BicicletaController {

    private static ManipulaArquivo manipulaArquivo = new ManipulaArquivo();

    public static boolean cadastrarBicicleta(String modelo, String cor, Double preco, String acessorio) {
        try {
            manipulaArquivo.cadastraBicicleta(modelo, preco, cor, acessorio);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
}
