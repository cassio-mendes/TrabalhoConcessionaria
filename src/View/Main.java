package View;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame tela = new JFrame("Administração Concessionária");
        tela.setLocationRelativeTo(null);
        tela.setSize(800, 600);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PainelInicial pInicial = new PainelInicial();
        tela.add(pInicial);
        tela.setVisible(true);
    }

}
