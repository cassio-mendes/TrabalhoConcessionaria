package Controller;

import Dao.ManipulaArquivo;
import Model.Bicicleta;
import java.io.IOException;

public class BicicletaController {

    private static final ManipulaArquivo MANIPULA_ARQUIVO = new ManipulaArquivo();

    public static boolean cadastrarBicicleta(Bicicleta novaBike) {
        try {
            MANIPULA_ARQUIVO.cadastraBicicleta(novaBike.getModelo(), novaBike.getPreco(), novaBike.getCor(),
                    novaBike.getAcessorio());
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
}
