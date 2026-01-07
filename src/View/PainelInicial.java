package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelInicial extends PainelPersonalizado {

    public PainelInicial(TelaPrincipal tela) {
        this.tela = tela;
        this.setLayout(null);

        JLabel titulo = new JLabel("Bem vindo ao administrador de concessionária!");
        titulo.setFont(new Font("Arial", Font.PLAIN, 20));
        titulo.setBounds(175, 140, 450, 20);
        this.add(titulo);

        JButton botaoCadastro = new JButton("Cadastrar Veículo");
        botaoCadastro.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoCadastro.setBounds(300, 230, 200, 40);
        botaoCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.trocarPainel("CADASTRO", new PainelCadastro(tela));
            }
        });
        this.add(botaoCadastro);

        JButton botaoLista = new JButton("Listar Veículos");
        botaoLista.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoLista.setBounds(300, 280, 200, 40);
        botaoLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.trocarPainel("LISTAGEM", new PainelListagem(tela));
            }
        });
        this.add(botaoLista);

        JButton botaoSAIR = new JButton("SAIR");
        botaoSAIR.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoSAIR.setBounds(300, 330, 200, 40);
        botaoSAIR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(botaoSAIR);

        this.setVisible(true);
    }

}
