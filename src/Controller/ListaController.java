package Controller;

import Dao.ManipulaArquivo;
import Model.Bicicleta;
import Model.Carro;
import Model.Moto;
import Model.Veiculo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListaController {

    private static ArrayList<Veiculo> cacheVeiculos = new ArrayList<>();
    private static final ManipulaArquivo MANIPULA_ARQUIVO = new ManipulaArquivo();

    public static String[] listarVeiculos() {
        try {
            ArrayList<Veiculo> listaVeiculos = MANIPULA_ARQUIVO.getListaCompleta();
            cacheVeiculos = listaVeiculos;
            String[] listaFormatada = new String[listaVeiculos.size()];

            for(int i = 0; i < listaFormatada.length; i++) {
                String[] linhaAtual = getLinhaAtual(listaVeiculos.get(i));

                switch (linhaAtual[0]) { //Tipo de veículo
                    case "Carro":
                        listaFormatada[i] = "Veículo: " + linhaAtual[0] + " | Modelo: " + linhaAtual[1] + " | Preço: R$" +
                                linhaAtual[2] + " | Cor: " + linhaAtual[3] + " | Consumo de Combustível: " + linhaAtual[4] +
                                " km/L | Número de Assentos: " + linhaAtual[5];
                    break;

                    case "Moto":
                        String carenagem = linhaAtual[5].equals("true") ? "Sim" : "Não";

                        listaFormatada[i] = "Veículo: " + linhaAtual[0] + " | Modelo: " + linhaAtual[1] + " | Preço: R$" +
                                linhaAtual[2] + " | Cor: " + linhaAtual[3] + " | Consumo de Combustível: " + linhaAtual[4] +
                                " km/L | Carenagem: " + carenagem;
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

    private static String montarLinhaCSV(Veiculo veiculo){
        if(veiculo instanceof Carro){
            Carro c = (Carro) veiculo;
            return "Carro;" + c.getModelo() + ";" + c.getPreco() + ";" + c.getCor() + ";" +
                    c.calcularConsumo() + ";" + c.getNumeroAssentos();
        } else if(veiculo instanceof Moto){
            Moto m = (Moto) veiculo;
            return "Moto;" + m.getModelo() + ";" + m.getPreco() + ";" + m.getCor() + ";" +
                    m.calcularConsumo() + ";" + m.isCarenagem();
        } else {
            Bicicleta b = (Bicicleta) veiculo;
            return "Bicicleta;" + b.getModelo() + ";" + b.getPreco() + ";" + b.getCor() + ";"
                     + b.getAcessorio();
        }
    }

    public static boolean removerVeiculo(String veiculo) {
        try {
            //Lista com todos os veículos cadastrados. Pode disparar NullPointerException
            List<String> lista = java.util.Arrays.asList(Objects.requireNonNull(listarVeiculos()));

            int index = lista.indexOf(veiculo); //Índice do veículo a ser removido da lista
            Veiculo v = cacheVeiculos.get(index); //Referencia o veículo a ser removido

            String linhacsv = montarLinhaCSV(v); //Obtém a linha correspondente no arquivo
            MANIPULA_ARQUIVO.retiraVeiculo(linhacsv); //Apaga a linha
            return true;

        } catch (IOException | NullPointerException e) {
            return false;
        }
    }

}
