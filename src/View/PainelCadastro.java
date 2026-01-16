package View;

import Controller.BicicletaController;
import Controller.CarroController;
import Controller.MotoController;
import Model.AtributosVaziosException;
import Model.Bicicleta;
import Model.Carro;
import Model.Moto;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Hashtable;
import java.util.Locale;

public class PainelCadastro extends PainelPersonalizado {

    private final JTextField inputModelo;
    private final JTextField inputCor;
    private final JFormattedTextField inputPreco;
    private final JButton botaoConfirmacao;

    private JFormattedTextField inputInteiro; //Input formatado para receber apenas inteiros
    private JFormattedTextField inputDouble = null; //Input formatado para receber apenas double
    private JTextField inputAcessorio; //Input para o atributo "acessorio" da Bicicleta

    private JRadioButton carenagemSim;

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

        inputPreco = configuraTextFieldDouble(); //Configura a entrada para permitir apenas números double
        inputPreco.setBounds(250, 210, 300, 20);
        this.add(inputPreco);

        //Confirmação:
        botaoConfirmacao = new JButton("CONTINUAR");
        botaoConfirmacao.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoConfirmacao.setBounds(300, 350, 200, 40);
        botaoConfirmacao.addActionListener(e -> perguntarTipoVeiculo());
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
        botaoRecomecar.addActionListener(e -> {
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
        });
        this.add(botaoRecomecar);

        this.setVisible(true);
    }

    private void perguntarTipoVeiculo() {
        this.tipoVeiculo = " ";

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
        botaoSelecionar.addActionListener(e -> {
            tipoVeiculo = (String)selecaoTipo.getSelectedItem(); //Salva a opção selecionada
            telinha.dispose(); //Fecha a janela
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

        //Texto ao lado do primeiro componente de entrada
        JLabel label4 = new JLabel();
        label4.setFont(new Font("Arial", Font.PLAIN, 16));
        label4.setBounds(70, 250, 200, 16);
        this.add(label4);

        JLabel label5 = new JLabel(); //Texto ao lado do segundo componente de entrada (caso de Carro ou Moto)

        switch (this.tipoVeiculo) {
            case "Carro":
                label4.setText("Consumo de combustível:");

                inputDouble = configuraTextFieldDouble();
                inputDouble.setBounds(270, 250, 300, 16);
                this.add(inputDouble);

                label5.setText("Número de assentos:");
                label5.setFont(new Font("Arial", Font.PLAIN, 16));
                label5.setBounds(100, 280, 200, 16);
                this.add(label5);

                inputInteiro = configuraTextFieldInteiro();
                inputInteiro.setBounds(250, 280, 300, 20);
                this.add(inputInteiro);
                break;

            case "Moto":
                label4.setText("Consumo de combustível:");

                inputDouble = configuraTextFieldDouble();
                inputDouble.setBounds(270, 250, 300, 16);
                this.add(inputDouble);

                label5.setText("Carenagem:");
                label5.setFont(new Font("Arial", Font.PLAIN, 16));
                label5.setBounds(160, 280, 200, 18);
                this.add(label5);

                //Botões de escolha única: sim (com carenagem) e não (sem carenagem)
                ButtonGroup grupoBotoesCarenagem = new ButtonGroup(); //Conterá os botões de Sim ou Não

                //Botões:
                carenagemSim = new JRadioButton("Sim");
                JRadioButton carenagemNao = new JRadioButton("Não", true);

                grupoBotoesCarenagem.add(carenagemSim);
                grupoBotoesCarenagem.add(carenagemNao);

                carenagemSim.setFont(new Font("Arial", Font.PLAIN, 16));
                carenagemNao.setFont(new Font("Arial", Font.PLAIN, 16));
                carenagemSim.setBounds(270, 280, 80, 18);
                carenagemNao.setBounds(450, 280, 80, 18);

                this.add(carenagemSim);
                this.add(carenagemNao);
                break;

            default: //Bicicleta
                label4.setText("Acessório:");
                label4.setLocation(170, 250);

                inputAcessorio = new JTextField();
                inputAcessorio.setBounds(250, 250, 300, 20);
                this.add(inputAcessorio);
        }

        //Botão para finalizar o cadastro
        JButton botaoCadastrar = new JButton("CADASTRAR");
        botaoCadastrar.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoCadastrar.setBounds(300, 350, 200, 40);
        botaoCadastrar.addActionListener(e -> {
            String modelo = inputModelo.getText();
            String cor = inputCor.getText();
            Double preco = (Double)inputPreco.getValue();
            Object atributoEspecifico1;
            Object atributoEspecifico2;

            if(tipoVeiculo.equals("Carro")) {
                atributoEspecifico1 = inputDouble.getValue(); //Consumo de Combustível
                atributoEspecifico2 = inputInteiro.getValue(); //Número de assentos

            } else if(tipoVeiculo.equals("Moto")) {
                atributoEspecifico1 = inputDouble.getValue(); //Consumo de Combustível
                atributoEspecifico2 = carenagemSim.isSelected(); //Se "Sim" está selecionado, tem carenagem (true)

            } else { //Bicicleta
                atributoEspecifico1 = inputAcessorio.getText(); //Nome do acessório
                atributoEspecifico2 = ""; //Não tem segundo atributo
            }

            finalizarCadastro(modelo, cor, preco, atributoEspecifico1, atributoEspecifico2); //Tentativa de finalizar
        });
        this.add(botaoCadastrar);

        this.repaint(); //Mostra o painel atualizado
    }

    private void finalizarCadastro(String modelo, String cor, Double preco, Object atributoEspecifico1, Object atributoEspecifico2) {
        //FAZER O CADASTRO COM AS INFORMAÇÕES CORRETAS (USAR EXCEPTIONS PARA TRATAMENTO DE ERROS)

        try {
            Object[] atributos = {modelo, cor, preco, atributoEspecifico1, atributoEspecifico2};

            //Verifica se algum valor de entrada (atributo) está vazio:
            for(Object a : atributos) {
                isAtributoVazio(a);
            }

            //Se o código chegar aqui, quer dizer que está tudo certo :)
            boolean tudoCerto; //Retorno dizendo se foi possível cadastrar

            //Chamando a classe controller correspondende ao tipo do veículo:
            switch(this.tipoVeiculo) {
                case "Carro":
                    Carro novoCarro = new Carro(modelo, preco, cor, (Double)atributoEspecifico1, (Integer)atributoEspecifico2);
                    tudoCerto = CarroController.cadastrarCarro(novoCarro);
                    break;

                case "Moto":
                    Moto novaMoto;

                    if((Boolean)atributoEspecifico2)
                        novaMoto = new Moto(modelo, preco, cor, (Double)atributoEspecifico1, true);
                    else
                        novaMoto = new Moto(modelo, preco, cor, (Double)atributoEspecifico1);

                    tudoCerto = MotoController.cadastrarMoto(novaMoto);
                    break;

                //Bike:
                default:
                    Bicicleta novaBike = new Bicicleta(modelo, cor, preco, (String)atributoEspecifico1);
                    tudoCerto = BicicletaController.cadastrarBicicleta(novaBike);
            }

            //Imprime um pop-up dependendo do resultado
            if(tudoCerto)
                JOptionPane.showMessageDialog(this, this.tipoVeiculo + "cadastrado(a)!");
            else
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar :(", "ERROR", JOptionPane.ERROR_MESSAGE);

        } catch (AtributosVaziosException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void isAtributoVazio(Object atributo) throws AtributosVaziosException {
        if(atributo == null)
            throw new AtributosVaziosException();
    }

    private JFormattedTextField configuraTextFieldDouble() {
        //Define o formato de entrada como números double (Locale define o formato brasileiro, com vírgula, como padrão)
        NumberFormat formatoDouble = NumberFormat.getNumberInstance(Locale.of("pt", "BR"));

        //Define o mínimo de casas decimais como 1 e o máximo como 2
        formatoDouble.setMinimumFractionDigits(1);
        formatoDouble.setMaximumFractionDigits(2);

        //Formato da entrada do preço
        NumberFormatter formatadorDouble = new NumberFormatter(formatoDouble);
        formatadorDouble.setValueClass(Double.class); //Define que os valores de entrada serão sempre Double
        formatadorDouble.setAllowsInvalid(false); //Impede entradas inválidas
        formatadorDouble.setMinimum(0.0); //Valor mínimo == 0.0

        return new JFormattedTextField(formatadorDouble); //Usa o formatador para aplicar as configurações
    }

    private JFormattedTextField configuraTextFieldInteiro() {
        //Define o formato de entrada como números double (Locale define o formato brasileiro, com vírgula, como padrão)
        NumberFormat formatoInteiro = NumberFormat.getIntegerInstance();

        //Formato da entrada do preço
        NumberFormatter formatadorInteiro = new NumberFormatter(formatoInteiro);
        formatadorInteiro.setValueClass(Integer.class); //Define que os valores de entrada serão sempre Double
        formatadorInteiro.setAllowsInvalid(false); //Impede entradas inválidas
        formatadorInteiro.setMinimum(0); //Valor mínimo == 0

        return new JFormattedTextField(formatadorInteiro); //Usa o formatador para aplicar as configurações
    }

}
