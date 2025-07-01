package Projeto;

import java.util.Scanner;

public class GestorAssentosVan {
    public static void main(String[] args) {
        char[][] assentoVan = new char[4][5];
        Scanner input = new Scanner(System.in);
        boolean continuar = true;

        for (int i = 0; i < assentoVan.length; i++) {
            for (int j = 0; j < assentoVan[i].length; j++) {
                assentoVan[i][j] = 'O';
            }
        }
        assentoVan[3][1] = ' ';
        assentoVan[3][2] = ' ';
        assentoVan[3][3] = ' ';
        assentoVan[0][4] = 'M';
        assentoVan[1][4] = ' ';

        while (continuar) {

            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("MENU DE OPÇÕES: ");
            System.out.println();
            System.out.println("1 - Ver mapa de assentos");
            System.out.println("2 - Reservar passagem");
            System.out.println("3 - Estatistica de disponibilidade");
            System.out.println("Escolha uma opção: ");
            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("MAPA DE ASSENTOS:");
                    System.out.println();
                    System.out.println("X - Ocupados ");
                    System.out.println("O - Disponiveis ");
                    System.out.println("M - Motorista");
                    System.out.println();
                    for (int i = 0; i < assentoVan.length; i++) {
                        for (int j = 0; j < assentoVan[i].length; j++) {
                            System.out.print(assentoVan[i][j] + "\t");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("ESCOLHA POSIÇÃO DO ASSENTO: ");
                    System.out.println();
                    System.out.println("Lado (0 a 3) ");
                    int lado = input.nextInt();
                    System.out.println("Coluna (0 a 4) ");
                    int coluna = input.nextInt();
                    input.nextLine();

                    if (lado < 0 || lado > 3 || coluna < 0 || coluna > 4) {
                        System.out.println("Posição invalida. Escolha novamente! ");
                    } else if (assentoVan[lado][coluna] == 'X') {
                        System.out.println("Assento ocupado. Escolha novamente! ");
                    } else if (assentoVan[lado][coluna] == 'M') {
                        System.out.println("Local do motorista. Escolha novamente! ");
                    } else if (assentoVan[lado][coluna] == ' ') {
                        System.out.println("Assento não existe. Escolha novamente! ");
                    } else {
                        assentoVan[lado][coluna] = 'X';
                        System.out.println("Assento reservado com sucesso! ");
                    }
                    break;
                case 3:
                    int disponiveis = 0, ocupados = 0;
                    for (int i = 0; i < assentoVan.length; i++) {
                        for (int j = 0; j < assentoVan[i].length; j++) {
                            if (assentoVan[i][j] == 'O') {
                                disponiveis++;
                            } else if (assentoVan[i][j] == 'X') {
                                ocupados++;
                            }
                        }
                    }
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("ESTATISTICA DE DISPONIBILIDADE: ");
                    System.out.println();
                    System.out.println("Total de assentos disponiveis " + disponiveis);
                    System.out.println("Total de assentos ocupados " + ocupados);
                    break;
                default:
                    System.out.println("Digite uma opção valida! ");

            }
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Deseja continuar? [S / N]: ");
            String resposta = input.nextLine().trim();
            while (!resposta.equalsIgnoreCase("S") && !resposta.equalsIgnoreCase("N")) {
                System.out.println("Resposta inválida. Escolha entre [S ou N]: ");
                resposta = input.nextLine().trim();
                input.nextLine();
            }
            if (resposta.equalsIgnoreCase("N")) {
                System.out.println("Finalizando...");
                continuar = false;
            }
        }
        input.close();
    }
}
