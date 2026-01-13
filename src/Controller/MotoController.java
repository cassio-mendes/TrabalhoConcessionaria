package Controller;

import Dao.ManipulaArquivo;
import Model.Moto;

import java.io.IOException;

public class MotoController {

    private static ManipulaArquivo manipulaArquivo = new ManipulaArquivo();

    public static boolean cadastrarMoto(String modelo, String cor, Double preco,
                                        Double consumoCombustivel, Boolean carenagem) {
        try {
            manipulaArquivo.cadastraMoto(modelo, preco, cor, consumoCombustivel, carenagem);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
