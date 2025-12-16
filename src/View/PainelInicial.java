package View;

import javax.swing.*;
import java.awt.*;

public class PainelInicial extends JPanel {

    public PainelInicial() {
        this.setLayout(null);

        JLabel titulo = new JLabel("Bem vindo ao administrador de concessionária!");
        titulo.setFont(new Font("Arial", Font.PLAIN, 20));
        titulo.setBounds(50, 50, 800, 800);

        this.add(titulo);
        this.setVisible(true);
    }

}
