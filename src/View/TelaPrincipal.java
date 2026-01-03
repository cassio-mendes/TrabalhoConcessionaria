package View;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    private JPanel painelPrincipal;
    private CardLayout baralhoPaineis;

    public TelaPrincipal() {
        this.baralhoPaineis = new CardLayout();
        this.painelPrincipal = new JPanel(baralhoPaineis);

        this.setTitle("Administração Concessionária");
        this.setResizable(false);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PainelInicial pInicial = new PainelInicial(this);
        PainelCadastro pCadastro = new PainelCadastro(this);
        PainelListagem pListagem = new PainelListagem(this);
        PainelAtualizacao pAtualizacao = new PainelAtualizacao(this);
        PainelRemocao pRemocao = new PainelRemocao(this);

        this.painelPrincipal.add(pInicial, "INICIAL");
        this.painelPrincipal.add(pCadastro, "CADASTRO");
        this.painelPrincipal.add(pListagem, "LISTAGEM");
        this.painelPrincipal.add(pAtualizacao, "ATUALIZACAO");
        this.painelPrincipal.add(pRemocao, "REMOCAO");

        this.add(this.painelPrincipal);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TelaPrincipal();
        
    }

    public void trocarPainel(String nomePainel) {
        this.baralhoPaineis.show(this.painelPrincipal, nomePainel);
    }

}
