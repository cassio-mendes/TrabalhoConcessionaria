package Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class ManipulaArquivo {
    private File arquivo;
    private BufferedWriter bw;
    private BufferedReader br;

    public ManipulaArquivo(){
        this.arquivo = new File("Concessionaria.csv");
    }

    public boolean cadastraCarro(String modelo, double preco, String cor, double consumoCombustivel, int numeroAssentos){

        return true;
    }

    public boolean cadastraMoto(String modelo, double preco, String cor, double consumoCombustivel, boolean carenagem){
        return true;
    }

    public boolean cadastraBicicleta(String acessorio, String modelo, double preco, String cor) {
        return true;
    }

    public boolean retiraVeiculo(){
        return true;
    }

    public boolean atualizaVeiculo(){
        return true;
    }

    public String[] getListaCompleta() throws IOException { return null; /*Temporário*/}

}
