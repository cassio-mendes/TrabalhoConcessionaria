package Dao;

import Model.Bicicleta;
import Model.Carro;
import Model.Moto;
import Model.Veiculo;

import java.io.*;
import java.util.ArrayList;

public class ManipulaArquivo {

    private final File ARQUIVO;
    private BufferedWriter bw;
    private BufferedReader br;

    private static final String NOME_ARQUIVO = "Concessionaria.csv";

    public ManipulaArquivo() {
        this.ARQUIVO = new File(NOME_ARQUIVO);
    }

    public void cadastraCarro(String modelo, double preco, String cor,
                                 double consumoCombustivel, int numeroAssentos) throws IOException {

        bw = new BufferedWriter(new FileWriter(ARQUIVO, true));
        bw.write("Carro;" + modelo + ";" + preco + ";" + cor + ";" +
                consumoCombustivel + ";" + numeroAssentos);
        bw.newLine();
        bw.close();
    }

    public void cadastraMoto(String modelo, double preco, String cor,
                                double consumoCombustivel, boolean carenagem) throws IOException {

        bw = new BufferedWriter(new FileWriter(ARQUIVO, true));
        bw.write("Moto;" + modelo + ";" + preco + ";" + cor + ";" +
                consumoCombustivel + ";" + carenagem);
        bw.newLine();
        bw.close();
    }

    public void cadastraBicicleta(String modelo, double preco,
                                     String cor, String acessorio) throws IOException {

        bw = new BufferedWriter(new FileWriter(ARQUIVO, true));
        bw.write("Bicicleta;" + modelo + ";" + preco + ";" + cor + ";" + acessorio);
        bw.newLine();
        bw.close();
    }

    public void retiraVeiculo(String linhaDeletada) throws IOException {

        File temp = new File(ARQUIVO.getParent(), "temp.csv");

        br = new BufferedReader(new FileReader(ARQUIVO));
        bw = new BufferedWriter(new FileWriter(temp));

        String linhaAtual;

        while ((linhaAtual = br.readLine()) != null) {
            if (!linhaAtual.trim().equals(linhaDeletada.trim())) {
                bw.write(linhaAtual);
                bw.newLine();
            }
        }

        br.close();
        bw.close();

        if (!ARQUIVO.delete()) {
            throw new IOException("Não foi possível deletar o arquivo original!");
        }

        BufferedReader brTemp = new BufferedReader(new FileReader(temp));
        BufferedWriter bwTemp = new BufferedWriter(new FileWriter(ARQUIVO));

        String linha;

        while((linha = brTemp.readLine()) != null){
            bwTemp.write(linha);
            bwTemp.newLine();
        }

        brTemp.close();
        bwTemp.close();

        if (temp.renameTo(ARQUIVO)) {
            throw new IOException("Não foi possível renomear o arquivo temporario!");
        }


    }

    public ArrayList<Veiculo> getListaCompleta() throws IOException {
        br = new BufferedReader(new FileReader(ARQUIVO));

        ArrayList<Veiculo> veiculos = new ArrayList<>();
        String linhaAtual;
        String[] colunas;

        while((linhaAtual = br.readLine()) != null) {
            colunas = linhaAtual.split(";");

            switch (colunas[0]) { //A primeira coluna é o tipo do veículo
                case "Carro":
                    //Cria um carro com modelo, preço, cor, consumo de combustível e número de assentos
                    veiculos.add(new Carro(colunas[1], Double.parseDouble(colunas[2]), colunas[3],
                            Double.parseDouble(colunas[4]), Integer.parseInt(colunas[5])));
                break;

                case "Moto":
                    //Cria uma moto com modelo, preço, cor, consumo de combustível e carenagem
                    veiculos.add(new Moto(colunas[1], Double.parseDouble(colunas[2]), colunas[3],
                            Double.parseDouble(colunas[4]), Boolean.parseBoolean(colunas[5])));
                break;

                default: //Bicicleta
                    //Cria uma bicicleta com modelo, preço, cor e acessório
                    veiculos.add(new Bicicleta(colunas[4], colunas[1], Double.parseDouble(colunas[2]), colunas[3]));
            }
        }

        br.close();
        return veiculos;
    }

}
