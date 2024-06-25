import java.util.Scanner;

public class ListaTelefonica {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            menuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    buscarContatoPorTelefone();
                    break;
                case 3:
                    buscarContatoPorNome();
                    break;
                case 4:
                    excluirContatoPorTelefone();
                    break;
                case 5:
                    excluirContatoPorNome();
                    break;
                case 6:
                    ordenarContatosPorNome();
                    break;
                case 7:
                    ordenarContatosPorTelefone();
                    break;
                case 8:
                    listarContatos();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }

        } while (opcao != 9);
    }

    public static void menuPrincipal() {
        System.out.print("\n--------- LISTA TELEFONICA -----------\n\n" +
                         "1. Adicionar um contato completo\n" +
                         "2. Buscar contato completo por telefone\n" +
                         "3. Buscar contato completo por nome\n" +
                         "4. Excluir um contato completo por telefone\n" +
                         "5. Excluir um contato completo por nome\n" +
                         "6. Ordenar contatos por nome\n" +
                         "7. Ordenar contatos por telefone\n" +
                         "8. Listar todos os contatos\n" +
                         "9. Sair\n" +
                         "Escolha uma opcao: ");
    }

    public static void adicionarContato() {
        System.out.println("\nAdicionar um novo contato:");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        int telefone = scanner.nextInt();
        scanner.nextLine(); 
        Contato.addContato(id, nome, telefone);
        System.out.println("Contato adicionado com sucesso.");
    }

    public static void buscarContatoPorTelefone() {
        System.out.println("\nBuscar contato por telefone:");

        System.out.print("Telefone: ");
        int telefone = scanner.nextInt();
        scanner.nextLine(); 

        Contato contato = Contato.consultarContatoPorTelefone(telefone);
        if (contato != null) {
            System.out.println("Contato encontrado:");
            System.out.println("ID: " + contato.getId() +
                               ", Nome: " + contato.getNome() +
                               ", Telefone: " + contato.getTelefone());
        } else {
            System.out.println("Contato nao encontrado.");
        }
    }

    public static void buscarContatoPorNome() {
        System.out.println("\nBuscar contato por nome:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        Contato contato = Contato.consultarContatoPorNome(nome);
        if (contato != null) {
            System.out.println("Contato encontrado:");
            System.out.println("ID: " + contato.getId() +
                               "\nNome: " + contato.getNome() +
                               "\nTelefone: " + contato.getTelefone());
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    public static void excluirContatoPorTelefone() {
        System.out.println("\nExcluir contato por telefone:");

        System.out.print("Telefone: ");
        int telefone = scanner.nextInt();
        scanner.nextLine(); 

        Contato.removerContatoPorTelefone(telefone);
        System.out.println("Contato excluido com sucesso.");
    }

    public static void excluirContatoPorNome() {
        System.out.println("\nExcluir contato por nome:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        Contato.removerContatoPorNome(nome);
        System.out.println("Contato excluido com sucesso.");
    }

    public static void ordenarContatosPorNome() {
        Contato.selectionSortNome();
        System.out.println("Contatos ordenados por nome.");
    }

    public static void ordenarContatosPorTelefone() {
        Contato.selectionSortPorNumero();
        System.out.println("Contatos ordenados por telefone.");
    }

    public static void listarContatos() {
        System.out.println("\nLista de contatos:");
        Contato.listarContatos();
    }
}

