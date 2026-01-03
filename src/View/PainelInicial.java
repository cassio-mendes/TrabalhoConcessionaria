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
                String tipoVeiculo = perguntarTipoVeiculo();

                if(!tipoVeiculo.equals(" ")) { tela.trocarPainelCadastro(tipoVeiculo); }
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

        JButton botaoAtualiza = new JButton("Atualizar Veículo");
        botaoAtualiza.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoAtualiza.setBounds(300, 330, 200, 40);
        botaoAtualiza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.trocarPainel("ATUALIZACAO", new PainelAtualizacao(tela));
            }
        });
        this.add(botaoAtualiza);

        JButton botaoDeleta = new JButton("Remover Veículo");
        botaoDeleta.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoDeleta.setBounds(300, 380, 200, 40);
        botaoDeleta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.trocarPainel("REMOCAO", new PainelRemocao(tela));
            }
        });
        this.add(botaoDeleta);
        
        JButton botaoSAIR = new JButton("SAIR");
        botaoSAIR.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoSAIR.setBounds(300, 430, 200, 40);
        botaoSAIR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(botaoSAIR);

        this.setVisible(true);
    }

    private String perguntarTipoVeiculo() {
        final String[] retorno = {" "};

        JDialog telinha = new JDialog(this.tela, "Tipo do Veículo", true);
        telinha.setLocationRelativeTo(this);
        telinha.setSize(600, 200);
        telinha.setLayout(null);
        telinha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JComboBox<String> selecaoTipo = new JComboBox<>(new String[]{"Carro", "Moto", "Bicicleta"});
        selecaoTipo.setBounds(350, 70, 70, 20);
        telinha.add(selecaoTipo);

        JLabel instrucao = new JLabel("Selecione o tipo de veículo a ser cadastrado:");
        instrucao.setFont(new Font("Arial", Font.PLAIN, 14));
        instrucao.setBounds(50, 70, 300, 14);
        telinha.add(instrucao);

        JButton botaoSelecionar = new JButton("SELECIONAR");
        botaoSelecionar.setFont(new Font("Arial", Font.PLAIN, 18));
        botaoSelecionar.setBounds(240, 110, 160, 25);
        botaoSelecionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retorno[0] = (String)selecaoTipo.getSelectedItem();
                telinha.dispose();
            }
        });
        telinha.add(botaoSelecionar);

        telinha.setVisible(true); //Código para aqui até que a janela seja fechada
        return retorno[0];
    }

}
