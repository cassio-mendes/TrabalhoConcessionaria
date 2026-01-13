package View;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class TelaPrincipal extends JFrame {

    private final JPanel painelPrincipal;
    private final CardLayout baralhoPaineis;
    private final Hashtable<String, PainelPersonalizado> historicoPaineis;

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

            if(nomePainel.equals("LISTAGEM")) { //O painel de listagem precisa ser atualizado
                this.painelPrincipal.remove(this.historicoPaineis.get("LISTAGEM"));
                this.historicoPaineis.remove("LISTAGEM");

                this.painelPrincipal.add(novoPainel, nomePainel);
                this.historicoPaineis.put(nomePainel, novoPainel);
            }

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
