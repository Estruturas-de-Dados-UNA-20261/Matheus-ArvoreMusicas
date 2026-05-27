import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArvoreMusicas arvore = new ArvoreMusicas();
        String caminho = "src/Musicas.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            int linhaAtual = 0;

            while ((linha = br.readLine()) != null) {
                linhaAtual++;
                
                if (linha.trim().isEmpty()) continue; 

                String[] dados = linha.split(";");

                if (dados.length < 3) {
                    System.out.println("Aviso: Linha " + linhaAtual + " ignorada por formato inválido.");
                    continue;
                }

                try {
                    int id = Integer.parseInt(dados[0].trim());
                    String nome = dados[1].trim();
                    String artista = dados[2].trim();

                    if (arvore.buscar(id) != null) {
                        System.out.println("Aviso: ID " + id + " duplicado na linha " + linhaAtual + " ignorado.");
                        continue;
                    }

                    Musica musica = new Musica(id, nome, artista);
                    arvore.inserir(musica);

                } catch (NumberFormatException e) {
                    System.out.println("Erro: ID inválido na linha " + linhaAtual + ". Pulando registro.");
                }
            }

            System.out.println("Arquivo processado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar música");
            System.out.println("2 - Buscar música por ID");
            System.out.println("3 - Exibir músicas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        int id = -1;
                        while (true) {
                            try {
                                System.out.print("ID da música: ");
                                id = sc.nextInt();
                                sc.nextLine();

                                if (arvore.buscar(id) != null) {
                                    System.out.println("Erro: Já existe uma música cadastrada com o ID " + id + ". Tente outro.");
                                } else if (id < 0) {
                                    System.out.println("Erro: O ID não pode ser negativo.");
                                } else {
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("❌ Erro: O ID deve ser um número inteiro.");
                                sc.nextLine();
                            }
                        }

                        System.out.print("Nome da música: ");
                        String nome = sc.nextLine();

                        System.out.print("Artista: ");
                        String artista = sc.nextLine();

                        if (nome.trim().isEmpty() || artista.trim().isEmpty()) {
                            System.out.println("Erro: Nome e Artista não podem ficar em branco. Cadastro cancelado.");
                            break;
                        }

                        Musica novaMusica = new Musica(id, nome, artista);
                        arvore.inserir(novaMusica);
                        System.out.println("🎉 Música cadastrada com sucesso!");
                        break;

                    case 2:
                        try {
                            System.out.print("Digite o ID da música: ");
                            int buscaId = sc.nextInt();
                            sc.nextLine();

                            Musica encontrada = arvore.buscar(buscaId);

                            if (encontrada != null) {
                                System.out.println("\nMúsica encontrada:");
                                System.out.println(encontrada);
                            } else {
                                System.out.println("Música não encontrada.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Erro: O ID de busca deve ser um número inteiro.");
                            sc.nextLine();
                        }
                        break;

                    case 3:
                        System.out.println("\n===== MÚSICAS =====");
                        arvore.exibirEmOrdem();
                        break;

                    case 0:
                        System.out.println("Programa encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida. Escolha um número do menu.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida! Por favor, digite um número.");
                sc.nextLine();
                opcao = -1; 
            }

        } while (opcao != 0);

        sc.close();
    }
}