package View;

import javax.swing.*;
import java.awt.*;

public class PainelCadastro extends PainelPersonalizado {

    private String tipoVeiculo;

    public PainelCadastro(TelaPrincipal tela) {
        this.tela = tela;
        this.setLayout(null);

        JLabel titulo = new JLabel("Cadastro de Veículo");
        titulo.setFont(new Font("Arial", Font.PLAIN, 20));
        titulo.setBounds(330, 80, 200, 20);
        this.add(titulo);

        JLabel titulo2 = new JLabel("Informe as informações do veículo");
        titulo2.setFont(new Font("Arial", Font.PLAIN, 18));
        titulo2.setBounds(300, 110, 300, 20);
        this.add(titulo2);

        //Entrada do modelo:
        JLabel label1 = new JLabel("Modelo:");
        label1.setFont(new Font("Arial", Font.PLAIN, 16));
        label1.setBounds(190, 150, 120, 16);
        this.add(label1);

        JTextField inputModelo = new JTextField();
        inputModelo.setBounds(250, 150, 300, 20);
        this.add(inputModelo);

        //Entrada da cor:
        JLabel label2 = new JLabel("Cor:");
        label2.setFont(new Font("Arial", Font.PLAIN, 16));
        label2.setBounds(220, 180, 60, 16);
        this.add(label2);

        JTextField inputCor = new JTextField();
        inputCor.setBounds(250, 180, 300, 20);
        this.add(inputCor);

        //Entrada do preço:
        JLabel label3 = new JLabel("Preço:");
        label3.setFont(new Font("Arial", Font.PLAIN, 16));
        label3.setBounds(200, 210, 80, 16);
        this.add(label3);

        JTextField inputPreco = new JTextField();
        inputPreco.setBounds(250, 210, 300, 20);
        this.add(inputPreco);

        //Informações específicas de cada veículo:
        JLabel label4;
        JLabel label5;
        JTextField inputEspecifico1;
        JTextField inputEspecifico2;

        switch (this.tipoVeiculo) {
            case "Carro":
            //label4.setText("Consumo de combustível");
        }

        this.setVisible(true);
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
}
