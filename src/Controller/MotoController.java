package Controller;

import Dao.ManipulaArquivo;
import Model.Moto;
import java.io.IOException;

public class MotoController {

    private static final ManipulaArquivo MANIPULA_ARQUIVO = new ManipulaArquivo();

    public static boolean cadastrarMoto(Moto novaMoto) {
        try {
            MANIPULA_ARQUIVO.cadastraMoto(novaMoto.getModelo(), novaMoto.getPreco(), novaMoto.getCor(),
                    novaMoto.calcularConsumo(), novaMoto.isCarenagem());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
