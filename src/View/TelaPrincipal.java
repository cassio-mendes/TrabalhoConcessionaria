package View;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class TelaPrincipal extends JFrame {

    private JPanel painelPrincipal;
    private CardLayout baralhoPaineis;
    private Hashtable<String, PainelPersonalizado> historicoPaineis;

    public TelaPrincipal() {
        this.baralhoPaineis = new CardLayout();
        this.painelPrincipal = new JPanel(baralhoPaineis);
        this.historicoPaineis = new Hashtable<>();

        this.setTitle("Administração Concessionária");
        this.setResizable(false);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(this.painelPrincipal);
        this.trocarPainel("INICIAL", new PainelInicial(this));
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }

    public void trocarPainel(String nomePainel, PainelPersonalizado novoPainel) {
        if(!historicoPaineis.containsKey(nomePainel)) {

            //Se o painel ainda não foi adicionado ao histórico
            this.painelPrincipal.add(novoPainel, nomePainel);
            this.baralhoPaineis.show(this.painelPrincipal, nomePainel);

            this.historicoPaineis.put(nomePainel, novoPainel);
        } else {
            //O painel já foi adicionado
            this.baralhoPaineis.show(this.painelPrincipal, nomePainel);
        }

    }

    public JPanel getPainelPrincipal() {
        return this.painelPrincipal;
    }

    public Hashtable<String, PainelPersonalizado> getHistoricoPaineis() {
        return this.historicoPaineis;
    }
}
