package Dao;

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

        br = new BufferedReader(new FileReader(ARQUIVO));
        bw = new BufferedWriter(new FileWriter("temp.csv"));

        String linhaAtual;

        while ((linhaAtual = br.readLine()) != null) {
            if (!linhaAtual.equals(linhaDeletada)) {
                bw.write(linhaAtual);
                bw.newLine();
            }
        }

        br.close();
        bw.close();

        ARQUIVO.delete();
        new File("temp.csv").renameTo(ARQUIVO);
    }

    public ArrayList<String> getListaCompleta() throws IOException {
        br = new BufferedReader(new FileReader(ARQUIVO));

        ArrayList<String> linhas = new ArrayList<>();
        String linhaAtual;

        while((linhaAtual = br.readLine()) != null) {
            linhas.add(linhaAtual);
        }

        br.close();
        return linhas;
    }

}
