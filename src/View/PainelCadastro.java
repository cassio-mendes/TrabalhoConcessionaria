package View;

import javax.swing.*;

public class PainelCadastro extends JPanel {

    private JFrame tela;

    public PainelCadastro(JFrame tela) {
        this.tela = tela;
        JLabel a = new JLabel("SSS");
        a.setBounds(10, 10, 100, 40);
        this.add(a);
        this.setVisible(true);
    }

}
