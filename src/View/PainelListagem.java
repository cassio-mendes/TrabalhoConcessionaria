package View;

import javax.swing.*;
import java.awt.*;

public class PainelListagem extends PainelPersonalizado {

    public PainelListagem(TelaPrincipal tela) {
        this.tela = tela;
        this.setLayout(null);

        JLabel titulo = new JLabel("Veículos Cadastrados");
        titulo.setFont(new Font("Arial", Font.PLAIN, 25));
        titulo.setBounds(280, 30, 300, 25);
        this.add(titulo);

        JList<String> lista = new JList<>();
        lista.setFont(new Font("Arial", Font.PLAIN, 16));
        lista.setBounds(90, 75, 600, 380);
        this.add(lista);

        JButton botaoAtualizar = new JButton("ATUALIZAR");
        botaoAtualizar.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoAtualizar.setBounds(120, 490, 170, 40);
        this.add(botaoAtualizar);

        JButton botaoRemover = new JButton("REMOVER");
        botaoRemover.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoRemover.setBounds(310, 490, 170, 40);
        this.add(botaoRemover);

        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoVoltar.setBounds(500, 490, 170, 40);
        this.add(botaoVoltar);

        this.setVisible(true);
    }

}
