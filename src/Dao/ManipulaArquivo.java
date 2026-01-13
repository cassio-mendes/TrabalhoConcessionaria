package Dao;

import java.io.*;

public class ManipulaArquivo {

    private File arquivo;
    private BufferedWriter bw;
    private BufferedReader br;

    private static final String NOME_ARQUIVO = "Concessionaria.csv";

    public ManipulaArquivo() {
        this.arquivo = new File(NOME_ARQUIVO);
    }

    public boolean cadastraCarro(String modelo, double preco, String cor,
                                 double consumoCombustivel, int numeroAssentos) throws IOException {

        bw = new BufferedWriter(new FileWriter(arquivo, true));
        bw.write(modelo + ";" + preco + ";" + cor + ";" +
                consumoCombustivel + ";" + numeroAssentos);
        bw.newLine();
        bw.close();

        return true;
    }

    public boolean cadastraMoto(String modelo, double preco, String cor,
                                double consumoCombustivel, boolean carenagem) throws IOException {

        bw = new BufferedWriter(new FileWriter(arquivo, true));
        bw.write(modelo + ";" + preco + ";" + cor + ";" +
                consumoCombustivel + ";" + carenagem);
        bw.newLine();
        bw.close();

        return true;
    }

    public boolean cadastraBicicleta(String acessorio, String modelo,
                                     double preco, String cor) throws IOException {

        bw = new BufferedWriter(new FileWriter(arquivo, true));
        bw.write(modelo + ";" + preco + ";" + cor + ";" + acessorio);
        bw.newLine();
        bw.close();

        return true;
    }

    public boolean retiraVeiculo(String linhaDeletada) throws IOException {

        br = new BufferedReader(new FileReader(arquivo));
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

        arquivo.delete();
        new File("temp.csv").renameTo(arquivo);

        return true;
    }
}
