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

        DefaultListModel<String> modeloLista = new DefaultListModel<>(); //Criando o modelo da lista

        JList<String> lista = new JList<>(modeloLista); //Criando a lista com o modelo
        lista.setFont(new Font("Arial", Font.PLAIN, 16));

        //A lista deve estar no painelScroll, porque ela não possui scroll automático
        JScrollPane painelScroll = new JScrollPane(lista); //Painel que pode "scrollar" para baixo

        painelScroll.setBounds(90, 75, 600, 380);
        this.add(painelScroll);

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
        botaoVoltar.addActionListener(e -> tela.trocarPainel("INICIAL", new PainelInicial(tela)));
        this.add(botaoVoltar);

        this.setVisible(true);
    }

}
