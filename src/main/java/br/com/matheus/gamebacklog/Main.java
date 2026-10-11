package br.com.matheus.gamebacklog;

import java.util.Scanner;

import br.com.matheus.gamebacklog.model.Jogo;
import br.com.matheus.gamebacklog.model.StatusJogo;
import br.com.matheus.gamebacklog.service.JogoService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        JogoService service = new JogoService();

        boolean executando = true;

        while (executando) {

            System.out.println("\n===== GAME BACKLOG =====");
            System.out.println("1 - Cadastrar jogo");
            System.out.println("2 - Listar jogos");
            System.out.println("3 - Alterar status");
            System.out.println("4 - Remover jogo");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Nome do jogo: ");
                    String nome = sc.nextLine();

                    System.out.print("Plataforma: ");
                    String plataforma = sc.nextLine();

                    Jogo novoJogo = new Jogo(
                        nome,
                        StatusJogo.QUERO_JOGAR,
                        plataforma
                    );

                    service.adicionarJogo(novoJogo);

                    System.out.println("Jogo cadastrado.");
                    break;

                case 2:

                    if (service.listarJogos().isEmpty()) {
                        System.out.println("Nenhum jogo cadastrado.");
                        break;
                    }

                    System.out.println("\n===== JOGOS CADASTRADOS =====");

                    for (Jogo jogoAtual : service.listarJogos()) {
                        System.out.println(
                            jogoAtual.getNome()
                            + " | "
                            + jogoAtual.getStatus()
                            + " | "
                            + jogoAtual.getPlataforma()
                        );
                    }

                    break;

                case 3:
                    System.out.print("Nome do jogo: ");
                    String nomeAlterar = sc.nextLine();

                    System.out.println("1 - Quero jogar");
                    System.out.println("2 - Jogando");
                    System.out.println("3 - Finalizado");
                    System.out.println("4 - Abandonado");
                    System.out.print("Escolha o novo status: ");

                    int opcaoStatus = sc.nextInt();
                    sc.nextLine();

                    StatusJogo novoStatus = null;

                    switch (opcaoStatus) {

                        case 1:
                            novoStatus = StatusJogo.QUERO_JOGAR;
                            break;

                        case 2:
                            novoStatus = StatusJogo.JOGANDO;
                            break;

                        case 3:
                            novoStatus = StatusJogo.FINALIZADO;
                            break;

                        case 4:
                            novoStatus = StatusJogo.ABANDONADO;
                            break;

                        default:
                            System.out.println("Status inválido.");
                            break;
                    }

                    if (novoStatus != null) {

                        boolean alterado = service.alterarStatus(
                            nomeAlterar,
                            novoStatus
                        );

                        if (alterado) {
                            System.out.println("Status alterado com sucesso.");
                        } else {
                            System.out.println("Jogo não encontrado.");
                        }
                    }

                    break;

                case 4:
                    System.out.print("Nome do jogo que deseja remover: ");
                    String nomeRemover = sc.nextLine();

                    boolean removido = service.removerPorNome(nomeRemover);

                    if (removido) {
                        System.out.println("Jogo removido com sucesso.");
                    } else {
                        System.out.println("Jogo não encontrado.");
                    }

                    break;

                case 0:
                    executando = false;
                    System.out.println("Game Backlog encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}
