package Controller;

import Dao.ManipulaArquivo;
import Model.Carro;
import java.io.IOException;

public class CarroController {

    private static final ManipulaArquivo MANIPULA_ARQUIVO = new ManipulaArquivo();

    public static boolean cadastrarCarro(Carro novoCarro) {
        try {
            MANIPULA_ARQUIVO.cadastraCarro(novoCarro.getModelo(), novoCarro.getPreco(), novoCarro.getCor(),
                    novoCarro.calcularConsumo(), novoCarro.getNumeroAssentos());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
