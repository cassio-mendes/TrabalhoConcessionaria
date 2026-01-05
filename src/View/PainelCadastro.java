package View;

import Model.AtributosVaziosException;
import Model.InteiroInvalidoException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class PainelCadastro extends PainelPersonalizado {

    private JTextField inputModelo;
    private JTextField inputCor;
    private JTextField inputPreco;
    private JButton botaoConfirmacao;

    private String tipoVeiculo = "";

    public PainelCadastro(TelaPrincipal tela) {
        this.tela = tela;
        this.setLayout(null);

        JLabel titulo = new JLabel("Cadastro de Veículo");
        titulo.setFont(new Font("Arial", Font.PLAIN, 20));
        titulo.setBounds(330, 80, 200, 20);
        this.add(titulo);

        JLabel titulo2 = new JLabel("Insira as informações do veículo");
        titulo2.setFont(new Font("Arial", Font.PLAIN, 18));
        titulo2.setBounds(300, 110, 300, 20);
        this.add(titulo2);

        //Entrada do modelo:
        JLabel label1 = new JLabel("Modelo:");
        label1.setFont(new Font("Arial", Font.PLAIN, 16));
        label1.setBounds(190, 150, 120, 16);
        this.add(label1);

        inputModelo = new JTextField();
        inputModelo.setBounds(250, 150, 300, 20);
        this.add(inputModelo);

        //Entrada da cor:
        JLabel label2 = new JLabel("Cor:");
        label2.setFont(new Font("Arial", Font.PLAIN, 16));
        label2.setBounds(220, 180, 60, 16);
        this.add(label2);

        inputCor = new JTextField();
        inputCor.setBounds(250, 180, 300, 20);
        this.add(inputCor);

        //Entrada do preço:
        JLabel label3 = new JLabel("Preço:");
        label3.setFont(new Font("Arial", Font.PLAIN, 16));
        label3.setBounds(200, 210, 80, 16);
        this.add(label3);

        inputPreco = new JTextField();
        inputPreco.setBounds(250, 210, 300, 20);
        this.add(inputPreco);

        //Confirmação:
        botaoConfirmacao = new JButton("CONTINUAR");
        botaoConfirmacao.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoConfirmacao.setBounds(300, 350, 200, 40);
        botaoConfirmacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perguntarTipoVeiculo();
            }
        });
        this.add(botaoConfirmacao);

        //Botão de voltar à tela inicial:
        JButton botaoSair = new JButton("VOLTAR");
        botaoSair.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoSair.setBounds(300, 450, 200, 40);
        botaoSair.addActionListener(e -> this.tela.trocarPainel("INICIAL", new PainelInicial(this.tela)));
        this.add(botaoSair);

        //Botão de recomeçar
        JButton botaoRecomecar = new JButton("RECOMEÇAR");
        botaoRecomecar.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoRecomecar.setBounds(300, 400, 200, 40);
        botaoRecomecar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Referencia o painelPrincipal e o histórico de paineis da tela
                JPanel painelPrincipal = tela.getPainelPrincipal();
                Hashtable<String, PainelPersonalizado> historicoPaineis = tela.getHistoricoPaineis();

                //Remove o painel de cadastro
                painelPrincipal.remove(historicoPaineis.get("CADASTRO"));
                historicoPaineis.remove("CADASTRO");

                //Adiciona um novo painel de cadastro
                PainelPersonalizado novoPainelCadastro = new PainelCadastro(tela);
                painelPrincipal.add("CADASTRO", novoPainelCadastro);
                historicoPaineis.put("CADASTRO", novoPainelCadastro);

                //Volta para a tela inicial
                tela.trocarPainel("INICIAL", new PainelInicial(tela));
            }
        });
        this.add(botaoRecomecar);

        this.setVisible(true);
    }

    private void perguntarTipoVeiculo() {
        JDialog telinha = new JDialog(this.tela, "Tipo do Veículo", true);
        telinha.setLocationRelativeTo(this);
        telinha.setSize(600, 200);
        telinha.setLayout(null);
        telinha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JComboBox<String> selecaoTipo = new JComboBox<>(new String[]{"Carro", "Moto", "Bicicleta"});
        selecaoTipo.setBounds(350, 70, 80, 20);
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
                tipoVeiculo = (String)selecaoTipo.getSelectedItem(); //Salva a opção selecionada
                telinha.dispose(); //Fecha a janela
            }
        });
        telinha.add(botaoSelecionar);

        telinha.setVisible(true); //Código para aqui até que a janela seja fechada

        if(!this.tipoVeiculo.equals(" ")) { //Se o usuário não fechou a janela clicando no'X'
            atualizarTela();
        }
    }

    private void atualizarTela() {

        //Remove o botão de CONTINUAR
        this.remove(this.botaoConfirmacao);

        //Informações específicas de cada veículo:
        JLabel label4 = new JLabel();
        label4.setFont(new Font("Arial", Font.PLAIN, 16));
        label4.setBounds(70, 250, 200, 16);
        this.add(label4);

        JTextField inputEspecifico1 = new JTextField();
        inputEspecifico1.setBounds(250, 250, 300, 20);
        this.add(inputEspecifico1);

        JLabel label5 = new JLabel();
        JTextField inputEspecifico2 = new JTextField();

        switch (this.tipoVeiculo) {
            case "Carro":
                label4.setText("Consumo de combustível:");

                label5.setText("Número de assentos:");
                label5.setFont(new Font("Arial", Font.PLAIN, 16));
                label5.setBounds(100, 280, 200, 16);
                this.add(label5);

                inputEspecifico2.setBounds(250, 280, 300, 20);
                this.add(inputEspecifico2);
                break;

            case "Moto":
                label4.setText("Consumo de combustível:");

                label5.setText("Carenagem:");
                label5.setFont(new Font("Arial", Font.PLAIN, 16));
                label5.setBounds(160, 280, 200, 18);
                this.add(label5);

                inputEspecifico2.setBounds(250, 280, 300, 20);
                this.add(inputEspecifico2);
                break;

            default: //Bicicleta
                label4.setText("Acessório:");
                label4.setLocation(170, 250);
        }

        //Botão para finalizar o cadastro
        JButton botaoCadastrar = new JButton("CADASTRAR");
        botaoCadastrar.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoCadastrar.setBounds(300, 350, 200, 40);
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modelo = inputModelo.getText();
                String cor = inputCor.getText();
                String preco = inputPreco.getText();
                String atributoEspecifico1 = inputEspecifico1.getText();
                String atributoEspecifico2 = inputEspecifico2.getText();

                finalizarCadastro(modelo, cor, preco, atributoEspecifico1, atributoEspecifico2);
            }
        });
        this.add(botaoCadastrar);

        this.repaint(); //Mostra o painel atualizado
    }

    private void finalizarCadastro(String modelo, String cor, String preco, String atributoEspecifico1, String atributoEspecifico2) {
        //FAZER O CADASTRO COM AS INFORMAÇÕES CORRETAS (USAR EXCEPTIONS PARA TRATAMENTO DE ERROS)

        try {
            String[] atributos = {modelo, cor, preco, atributoEspecifico1, atributoEspecifico2};

            //Verifica se algum valor de entrada (atributo) está vazio:
            for(String a : atributos) {
                isAtributoVazio(a);
            }

            //Verifica se o preco é um número real (double)
            isAtributoDouble(preco);

            if(this.tipoVeiculo.equals("Carro")) {
                //isAtributoDouble();
            }

            //Se o código chegar aqui, quer dizer que está tudo certo :)


        } catch(AtributosVaziosException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void isAtributoVazio(String atributo) throws AtributosVaziosException {
        if(atributo.isEmpty())
            throw new AtributosVaziosException();
    }

    private void isAtributoDouble(String atributo) {

    }

    private void isAtributoInteiro(String atributo) throws InteiroInvalidoException {

    }

}
