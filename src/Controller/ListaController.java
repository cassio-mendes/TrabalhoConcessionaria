package Controller;

import Dao.ManipulaArquivo;

import java.io.IOException;
import java.util.ArrayList;

public class ListaController {

    private static ManipulaArquivo manipulaArquivo = new ManipulaArquivo();

    public static String[] listarVeiculos() {
        try {
            ArrayList<String> lista = manipulaArquivo.getListaCompleta();
            String[] linhaAtual;
            String[] listaFormatada = new String[lista.size()];

            for(int i = 0; i < listaFormatada.length; i++) {
                linhaAtual = lista.get(i).split(";");

                switch (linhaAtual[0]) { //Tipo de veículo
                    case "Carro":
                        listaFormatada[i] = "Veículo: " + linhaAtual[0] + " | Modelo: " + linhaAtual[1] + " | Preço: " +
                                linhaAtual[2] + " | Cor: " + linhaAtual[3] + " | Consumo de Combustível: " + linhaAtual[4] +
                                " | Número de Assentos: " + linhaAtual[5];
                    break;

                    case "Moto":
                        String carenagem = linhaAtual[5].equals("true") ? "Sim" : "Não";

                        listaFormatada[i] = "Veículo: " + linhaAtual[0] + " | Modelo: " + linhaAtual[1] + " | Preço: " +
                                linhaAtual[2] + " | Cor: " + linhaAtual[3] + " | Consumo de Combustível: " + linhaAtual[4] +
                                " | Carenagem: " + carenagem;
                    break;

                    default: //Bicicleta
                        listaFormatada[i] = "Veículo: " + linhaAtual[0] + " | Modelo: " + linhaAtual[1] + " | Preço: " +
                                linhaAtual[2] + " | Cor: " + linhaAtual[3] + " | Acessório: " + linhaAtual[4];
                }
            }

            return listaFormatada;
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
        try {
            //Lógica de remover veículo da lista:
            manipulaArquivo.retiraVeiculo(veiculo);
            return true;

        } catch (IOException e) {
            return false;
        }
    }

}
