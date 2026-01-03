package View;

import javax.swing.*;
import java.awt.*;

public class PainelCadastro extends PainelPersonalizado {

    public PainelCadastro(TelaPrincipal tela, String tipoVeiculo) {
        this.tela = tela;

        JLabel titulo = new JLabel("Cadastro de Veículo");
        titulo.setFont(new Font("Arial", Font.PLAIN, 20));
        titulo.setBounds(175, 140, 450, 20);
        this.add(titulo);



        this.setVisible(true);
    }

}
