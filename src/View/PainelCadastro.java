package View;

import javax.swing.*;
import java.awt.*;

public class PainelCadastro extends PainelPersonalizado {

    private String tipoVeiculo;

    public PainelCadastro(TelaPrincipal tela) {
        this.tela = tela;

        JLabel titulo = new JLabel("Cadastro de Veículo");
        titulo.setFont(new Font("Arial", Font.PLAIN, 20));
        titulo.setBounds(175, 140, 450, 20);
        this.add(titulo);

        this.setVisible(true);
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
}
