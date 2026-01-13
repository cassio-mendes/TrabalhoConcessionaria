package Controller;

import Dao.ManipulaArquivo;
import Model.Bicicleta;
import Model.Carro;
import Model.Moto;
import Model.Veiculo;

import java.io.IOException;
import java.util.ArrayList;

public class ListaController {

    private static final ManipulaArquivo MANIPULA_ARQUIVO = new ManipulaArquivo();

    public static String[] listarVeiculos() {
        try {
            ArrayList<Veiculo> listaVeiculos = MANIPULA_ARQUIVO.getListaCompleta();
            String[] linhaAtual;
            String[] listaFormatada = new String[listaVeiculos.size()];

            for(int i = 0; i < listaFormatada.length; i++) {
                linhaAtual = getLinhaAtual(listaVeiculos.get(i));

                switch (linhaAtual[0]) { //Tipo de veículo
                    case "Carro":
                        listaFormatada[i] = "Veículo: " + linhaAtual[0] + " | Modelo: " + linhaAtual[1] + " | Preço: R$" +
                                linhaAtual[2] + " | Cor: " + linhaAtual[3] + " | Consumo de Combustível: " + linhaAtual[4] +
                                " | Número de Assentos: " + linhaAtual[5];
                    break;

                    case "Moto":
                        String carenagem = linhaAtual[5].equals("true") ? "Sim" : "Não";

                        listaFormatada[i] = "Veículo: " + linhaAtual[0] + " | Modelo: " + linhaAtual[1] + " | Preço: R$" +
                                linhaAtual[2] + " | Cor: " + linhaAtual[3] + " | Consumo de Combustível: " + linhaAtual[4] +
                                " | Carenagem: " + carenagem;
                    break;

                    default: //Bicicleta
                        listaFormatada[i] = "Veículo: " + linhaAtual[0] + " | Modelo: " + linhaAtual[1] + " | Preço: R$" +
                                linhaAtual[2] + " | Cor: " + linhaAtual[3] + " | Acessório: " + linhaAtual[4];
                }
            }

            return listaFormatada;
        } catch (IOException e) {
            return null;
        }
    }

    private static String[] getLinhaAtual(Veiculo veiculo) {
        String[] linhaAtual;

        if(veiculo instanceof Carro) {
            Carro carro = (Carro)veiculo;

            linhaAtual = new String[6]; //5 atributos de Carro
            linhaAtual[0] = "Carro";
            linhaAtual[1] = carro.getModelo();
            linhaAtual[2] = String.valueOf(carro.getPreco());
            linhaAtual[3] = carro.getCor();
            linhaAtual[4] = String.valueOf(carro.calcularConsumo());
            linhaAtual[5] = String.valueOf(carro.getNumeroAssentos());

        } else if(veiculo instanceof Moto) {
            Moto moto = (Moto)veiculo;

            linhaAtual = new String[6]; //5 atributos de Moto
            linhaAtual[0] = "Moto";
            linhaAtual[1] = moto.getModelo();
            linhaAtual[2] = String.valueOf(moto.getPreco());
            linhaAtual[3] = moto.getCor();
            linhaAtual[4] = String.valueOf(moto.calcularConsumo());
            linhaAtual[5] = String.valueOf(moto.isCarenagem());

        } else { //É uma Bicicleta
            Bicicleta bike = (Bicicleta)veiculo;

            linhaAtual = new String[6]; //4 atributos de Bicicleta
            linhaAtual[0] = "Bicicleta";
            linhaAtual[1] = bike.getModelo();
            linhaAtual[2] = String.valueOf(bike.getPreco());
            linhaAtual[3] = bike.getCor();
            linhaAtual[4] = bike.getAcessorio();
        }

        return linhaAtual;
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
            MANIPULA_ARQUIVO.retiraVeiculo(veiculo);
            return true;

        } catch (IOException e) {
            return false;
        }
    }

}
