import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArvoreMusicas arvore = new ArvoreMusicas();

        arvore.inserir(new Musica(10, "Numb", "Linkin Park"));
        arvore.inserir(new Musica(5, "Believer", "Imagine Dragons"));
        arvore.inserir(new Musica(20, "Shape of You", "Ed Sheeran"));
        arvore.inserir(new Musica(3, "Halo", "Beyoncé"));
        arvore.inserir(new Musica(7, "Blinding Lights", "The Weeknd"));
        arvore.inserir(new Musica(15, "Bad Guy", "Billie Eilish"));
        arvore.inserir(new Musica(30, "Smells Like Teen Spirit", "Nirvana"));

        Scanner sc = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar música");
            System.out.println("2 - Buscar música por ID");
            System.out.println("3 - Exibir músicas");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("ID da música: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome da música: ");
                    String nome = sc.nextLine();

                    System.out.print("Artista: ");
                    String artista = sc.nextLine();

                    Musica musica = new Musica(id, nome, artista);

                    arvore.inserir(musica);

                    System.out.println("Música cadastrada com sucesso!");

                    break;

                case 2:

                    System.out.print("Digite o ID da música: ");
                    int buscaId = sc.nextInt();

                    Musica encontrada = arvore.buscar(buscaId);

                    if (encontrada != null) {

                        System.out.println("\nMúsica encontrada:");
                        System.out.println(encontrada);

                    } else {

                        System.out.println("Música não encontrada.");
                    }

                    break;

                case 3:

                    System.out.println("\n===== MÚSICAS CADASTRADAS =====");

                    arvore.exibirEmOrdem();

                    break;

                case 0:

                    System.out.println("Programa encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}