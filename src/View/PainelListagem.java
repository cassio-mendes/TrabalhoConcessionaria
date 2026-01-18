package View;

import Controller.ListaController;

import javax.swing.*;
import java.awt.*;

public class PainelListagem extends PainelPersonalizado {

    private final DefaultListModel<String> modeloLista;
    private final JList<String> lista;

    public PainelListagem(TelaPrincipal tela) {
        this.tela = tela;
        this.setLayout(null); //Permite reposicionar os componentes

        JLabel titulo = new JLabel("Veículos Cadastrados");
        titulo.setFont(new Font("Arial", Font.PLAIN, 25));
        titulo.setBounds(280, 30, 300, 25);
        this.add(titulo);

        this.modeloLista = new DefaultListModel<>(); //Criando o modelo da lista

        this.lista = new JList<>(this.modeloLista); //Criando a lista com o modelo
        this.lista.setFont(new Font("Arial", Font.PLAIN, 16));

        //A lista deve estar no painelScroll, porque ela não possui scroll automático
        JScrollPane painelScroll = new JScrollPane(this.lista); //Painel que pode "scrollar" para baixo

        painelScroll.setBounds(90, 75, 600, 380);
        this.add(painelScroll);

        JButton botaoRemover = new JButton("REMOVER");
        botaoRemover.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoRemover.setBounds(210, 490, 170, 40);
        botaoRemover.addActionListener(e -> {
            if(lista.getSelectedValue() == null) {
                JOptionPane.showMessageDialog(tela, "Selecione um item da lista para prosseguir", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                removerElemento(lista.getSelectedValue());
            }
        });
        this.add(botaoRemover);

        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoVoltar.setBounds(400, 490, 170, 40);
        botaoVoltar.addActionListener(e -> tela.trocarPainel("INICIAL", new PainelInicial(tela)));
        this.add(botaoVoltar);

        this.preencherLista();

        this.setVisible(true);
    }

    private void preencherLista() {
        String[] linhas = ListaController.listarVeiculos();

        if(linhas == null) { //Ocorreu uma IOException
            JOptionPane.showMessageDialog(this, "Houve um erro ao ler o arquivo registros",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            //Atualiza a lista:
            this.modeloLista.removeAllElements(); //Remove os elementos atuais

            for(String linha : linhas) {
                this.modeloLista.addElement(linha); //Adiciona os novos elementos, um por um
            }
        }
    }

    private void removerElemento(String elemento) {
        if(!ListaController.removerVeiculo(elemento)) {
            JOptionPane.showMessageDialog(this, "Não foi possível remover o veículo selecionado",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Veículo removido com sucesso!");
            this.preencherLista();
        }
    }

}
