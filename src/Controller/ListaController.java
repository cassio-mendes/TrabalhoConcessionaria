package Controller;

import Dao.ManipulaArquivo;

import java.io.IOException;

public class ListaController {

    private static ManipulaArquivo manipulaArquivo = new ManipulaArquivo();

    public static String[] listarVeiculos() {
        try {
            return manipulaArquivo.getListaCompleta();
        } catch (IOException e) {
            return null;
        }
    }

    public static boolean atualizarVeiculo(String veiculo) {
        /*try {
            //Lógica de atualizar veículo da lista:


        } catch (IOException e) {
            return false;
        }*/

        return true; //Temporário
    }

    public static boolean removerVeiculo(String veiculo) {
        /*try {
            //Lógica de remover veículo da lista:


        } catch (IOException e) {
            return false;
        }*/

        return true; //Temporário
    }

}
