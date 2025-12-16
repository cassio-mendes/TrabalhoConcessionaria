package View;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame tela = new JFrame("Administração Concessionária");
        tela.setLocation(450, 100);
        tela.setSize(1000, 800);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PainelInicial pInicial = new PainelInicial();
        tela.add(pInicial);
        tela.setVisible(true);
    }

}
