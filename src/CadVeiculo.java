import entities.Carro;
import entities.Moto;
import entities.Veiculo;
import services.VeiculoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CadVeiculo {
    private static VeiculoService veiculoService = new VeiculoService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
        }
    }

    private static void exibirMenu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Menu:");
        System.out.println("1. Cadastrar Veículo");
        System.out.println("2. Listar Veículos");
        System.out.println("3. Buscar Veículo por Placa");
        System.out.println("4. Remover Veículo");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");

        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    listarVeiculos();
                    break;
                case 3:
                    buscarVeiculo();
                    break;
                case 4:
                    removerVeiculo();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Pressione Enter para continuar.");
                    scanner.nextLine();
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Pressione Enter para continuar.");
            scanner.nextLine();
        }
    }

    private static void cadastrarVeiculo() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("1. Cadastrar Carro");
        System.out.println("2. Cadastrar Moto");
        System.out.print("Escolha uma opção: ");

        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarCarro();
                    break;
                case 2:
                    cadastrarMoto();
                    break;
                default:
                    System.out.println("Opção inválida. Pressione Enter para continuar.");
                    scanner.nextLine();
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Pressione Enter para continuar.");
            scanner.nextLine();
        }
    }

    private static void cadastrarCarro() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        try {
            System.out.print("Placa: ");
            String placa = scanner.nextLine();
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Ano: ");
            int ano = scanner.nextInt();
            System.out.print("Número de Portas: ");
            int numeroPortas = scanner.nextInt();
            scanner.nextLine();

            veiculoService.adicionarVeiculo(new Carro(placa, modelo, ano, numeroPortas));
            System.out.println("Veículo cadastrado com sucesso! Pressione Enter para continuar.");
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Pressione Enter para continuar.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("NÃO FOI POSSÍVEL CADASTRAR O VEÍCULO");
            System.out.println(e.getMessage());
            System.out.println("Pressione Enter para continuar.");
            scanner.nextLine();
        }
    }

    private static void cadastrarMoto() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        try {
            System.out.print("Placa: ");
            String placa = scanner.nextLine();
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Ano: ");
            int ano = scanner.nextInt();
            scanner.nextLine();

            veiculoService.adicionarVeiculo(new Moto(placa, modelo, ano));
            System.out.println("Veículo cadastrado com sucesso! Pressione Enter para continuar.");
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Pressione Enter para continuar.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("NÃO FOI POSSÍVEL CADASTRAR O VEÍCULO");
            System.out.println(e.getMessage());
            System.out.println("Pressione Enter para continuar.");
            scanner.nextLine();
        }
    }

    private static void listarVeiculos() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        veiculoService.listarVeiculos().forEach(System.out::println);
        System.out.println("Pressione Enter para continuar.");
        scanner.nextLine();
    }

    private static void buscarVeiculo() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        Veiculo veiculo = veiculoService.buscarPorPlaca(placa);
        if (veiculo != null) {
            System.out.println(veiculo);
        } else {
            System.out.println("Veículo não encontrado.");
        }
        System.out.println("Pressione Enter para continuar.");
        scanner.nextLine();
    }

    private static void removerVeiculo() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("Digite a placa do veículo a ser removido: ");
        String placa = scanner.nextLine();
        try {
            veiculoService.removerVeiculo(placa);
            System.out.println("Veículo removido com sucesso.");
        } catch (Exception e) {
            System.out.println("NÃO FOI POSSÍVEL REMOVER O VEÍCULO");
            System.out.println(e.getMessage());
        }
        System.out.println("Pressione Enter para continuar.");
        scanner.nextLine();
    }
}
