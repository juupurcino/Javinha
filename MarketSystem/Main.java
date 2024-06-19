import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
    
        do {
            exibirMenuPrincipal();
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
    
            switch (opcao) {
                case 1:
                    menuCadastroClientes();
                    break;
                case 2:
                    menuCadastroAtendentes();
                    break;
                case 3:
                    menuVendas();
                    break;
                case 4:
                    menuHistoricoCompras();
                    break;
                case 5:
                    menuHistoricoVendas();
                    break;
                case 6:
                    menuGerenciamentoEstoque();
                    break;
                case 7:
                    menuPedidosCompra();
                    break;
                case 8:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 8);
    
        scanner.close();
    }
    
    public static void exibirMenuPrincipal() {
        System.out.println("Menu Principal:");
        System.out.println("1. Cadastro de Clientes");
        System.out.println("2. Cadastro de Atendentes de Caixa");
        System.out.println("3. Realização de Vendas");
        System.out.println("4. Histórico de Compras");
        System.out.println("5. Histórico de Vendas");
        System.out.println("6. Gerenciamento de Estoque");
        System.out.println("7. Pedidos de Compra");
        System.out.println("8. Sair");
    }

    
}