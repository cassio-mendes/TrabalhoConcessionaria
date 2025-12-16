package Controller;

import Model.Veiculo;
import Model.Moto;
import Model.Carro;
import Model.Bicicleta;
import java.util.ArrayList;
import java.util.Scanner;

public class CompraVeiculo {

    public static void main(String[] args) {
        //ArrayList serve como um carrinho de compras
        ArrayList<Veiculo> compra = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);

        boolean encerra = true;

        while (encerra == true) {
            System.out.println("Informe a operacao que deseja realizar: ");
            System.out.println("1- Comprar veiculo");
            System.out.println("2- Consultar carrinho de compras");
            System.out.println("3- Sair");
            try {
                int op = entrada.nextInt();
                switch (op) {

                    case 1:
                        System.out.println("Selecione o tipo de veiculo que deseja comprar: ");
                        System.out.println("a- Bicicleta");
                        System.out.println("b- Carro");
                        System.out.println("c- Moto");
                        String opCompra = entrada.next();

                        switch (opCompra) {
                            case "a":
                                System.out.println("Informe o modelo: ");
                                String modBike = entrada.next();
                                //como pré-definir o valor da bicicleta? 
                                //Ou dos veículos em geral, de acordo com seu modelo...
                                Bicicleta b = new Bicicleta("cesta", modBike, 234.5);
                                compra.add(b);
                                break;
                            case "b":
                                System.out.println("Informe o modelo: ");
                                String modCar = entrada.next();
                                Carro c = new Carro(modCar, 3400.5);
                                compra.add(c);
                                break;
                            case "c":
                                System.out.println("Informe o modelo: ");
                                String modMoto = entrada.next();
                                Moto m = new Moto(modMoto, 9347.7);
                                compra.add(m);
                                break;
                            default:
                                throw new AssertionError();
                        }

                        break;
                    case 2:
                        for (int i = 0; i < compra.size(); i++){
                            System.out.println(compra.get(i));
                        }
                        break;
                    case 3:
                        System.out.println("Encerrando atendimento...");
                        encerra = false;
                        break;
                    default:
                        throw new AssertionError();
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Formato de entrada invalido!");
            }
        }
    }
}
