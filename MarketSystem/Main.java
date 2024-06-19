import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main{

    public static void menuPrincipal(){

        System.out.print("\n--------- SISTEMA DE MERCADO -----------\n\n" +
                                "1. Cadastro de Clientes\n" + //
                                "2. Cadastro de Atendentes de Caixa\n" + //
                                "3. Realização de Vendas\n" + //
                                "4. Historico de Compras\n" + //
                                "5. Histórico de Vendas\n" + //
                                "6. Gerenciamento de Estoque\n" + //
                                "7. Pedidos de Compra\n" + //
                                "8. Sair ");
    }

    public static void menuCadastroClientes() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.print("\n--------- MENU CADASTRO DE CLIENTES -----------\n\n" +
                             "1. Cadastrar Novo Cliente\n" +
                             "2. Consultar Cliente\n" +
                             "3. Atualizar Cliente\n" +
                             "4. Remover Cliente\n" +
                             "5. Voltar ao Menu Principal\n\n" +
                             "Escolha uma opcao: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarNovoCliente(scanner);
                    break;
                case 2:
                    consultarCliente(scanner);
                    break;
                case 3:
                    atualizarCliente(scanner);
                    break;
                case 4:
                    removerCliente(scanner);
                    break;
                case 5:
                    System.out.println("\nVoltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("\nOpcao invalida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void cadastrarNovoCliente(Scanner scanner) {
        
        System.out.print("\nCadastro de Novo Cliente\n");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataNascStr = scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNasc;
        
        try {
            dataNasc = sdf.parse(dataNascStr);
            Cliente.addCliente(nome, endereco, telefone, cpf, dataNasc);
            System.out.println("\nNovo cliente cadastrado com sucesso!");
        } catch (ParseException e) {
            System.out.println("\nErro ao converter data. Formato invalido. Tente novamente.");
        }
    }

    private static void consultarCliente(Scanner scanner) {
        
        System.out.print("\nConsulta de Cliente\n");
        System.out.print("CPF do Cliente: ");
        String cpfConsulta = scanner.nextLine();
        
        Cliente clienteConsultado = Cliente.consultarCliente(cpfConsulta);
        
        if (clienteConsultado != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            System.out.println("\nCliente Encontrado:");
            System.out.println("Nome: " + clienteConsultado.getNome());
            System.out.println("Endereco: " + clienteConsultado.getEndereco());
            System.out.println("Telefone: " + clienteConsultado.getTelefone());
            System.out.println("CPF: " + clienteConsultado.getCpf());
            System.out.println("Data de Nascimento: " + sdf.format(clienteConsultado.getDataNasc()));
        
        } else {
            System.out.println("\nCliente nao encontrado.");
        }
    }

    private static void atualizarCliente(Scanner scanner) {
        
        System.out.print("\nAtualizacao de Cliente\n");
        System.out.print("CPF do Cliente: ");
        String cpfAtualizacao = scanner.nextLine();
        
        Cliente clienteAtualizar = Cliente.consultarCliente(cpfAtualizacao);
        
        if (clienteAtualizar != null) {
            System.out.print("Novo Nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo Endereco: ");
            String novoEndereco = scanner.nextLine();
            System.out.print("Novo Telefone: ");
            String novoTelefone = scanner.nextLine();
            System.out.print("Nova Data de Nascimento (dd/MM/yyyy): ");
            String novaDataNascStr = scanner.nextLine();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date novaDataNasc;
            try {
                novaDataNasc = sdf.parse(novaDataNascStr);
                Cliente.atualizarCliente(novoNome, novoEndereco, novoTelefone, cpfAtualizacao, novaDataNasc);
                System.out.println("\nCliente atualizado com sucesso!");
            } catch (ParseException e) {
                System.out.println("\nErro ao converter data. Formato invalido. Tente novamente.");
            }
        } else {
            System.out.println("\nCliente nao encontrado.");
        }
    }

    private static void removerCliente(Scanner scanner) {
        
        System.out.print("\nRemocao de Cliente\n");
        System.out.print("CPF do Cliente: ");
        String cpfRemocao = scanner.nextLine();
        Cliente.popCliente(cpfRemocao);
        System.out.println("\nCliente removido com sucesso!");
    }

    public static void menuCadastroCaixas() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.print("\n--------- MENU CADASTRO DE CAIXAS -----------\n\n" +
                             "1. Cadastrar Novo Caixa\n" +
                             "2. Consultar Caixa\n" +
                             "3. Atualizar Caixa\n" +
                             "4. Remover Caixa\n" +
                             "5. Voltar ao Menu Principal\n\n" +
                             "Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarNovoCaixa(scanner);
                    break;
                case 2:
                    consultarCaixa(scanner);
                    break;
                case 3:
                    atualizarCaixa(scanner);
                    break;
                case 4:
                    removerCaixa(scanner);
                    break;
                case 5:
                    System.out.println("\nVoltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void cadastrarNovoCaixa(Scanner scanner) {
        System.out.print("\nCadastro de Novo Caixa\n");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Admissao (dd/MM/yyyy): ");
        String dataAdmissaoStr = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAdmissao;
        try {
            dataAdmissao = sdf.parse(dataAdmissaoStr);
            AtendenteCaixa.addCaixa(nome, endereco, telefone, cpf, dataAdmissao, cargo, id);
            System.out.println("\nNovo caixa cadastrado com sucesso!");
        } catch (ParseException e) {
            System.out.println("\nErro ao converter data. Formato inválido. Tente novamente.");
        }
    }

    private static void consultarCaixa(Scanner scanner) {
        System.out.print("\nConsulta de Caixa\n");
        System.out.print("ID do Caixa: ");
        int idConsulta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        AtendenteCaixa caixaConsultado = AtendenteCaixa.consultarCaixa(idConsulta);

        if (caixaConsultado != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            System.out.println("\nCaixa Encontrado:");
            System.out.println("Nome: " + caixaConsultado.getNome());
            System.out.println("Endereço: " + caixaConsultado.getEndereco());
            System.out.println("Telefone: " + caixaConsultado.getTelefone());
            System.out.println("CPF: " + caixaConsultado.getCpf());
            System.out.println("Data de Admissao: " + sdf.format(caixaConsultado.getDataAdmissao()));
            System.out.println("Cargo: " + caixaConsultado.getCargo());
            System.out.println("ID: " + caixaConsultado.getIdCaixa());
        } else {
            System.out.println("\nCaixa não encontrado.");
        }
    }

    private static void atualizarCaixa(Scanner scanner) {
        System.out.print("\nAtualização de Caixa\n");
        System.out.print("ID do Caixa: ");
        int idAtualizacao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
    
        AtendenteCaixa caixaAtualizar = AtendenteCaixa.consultarCaixa(idAtualizacao);
    
        if (caixaAtualizar != null) {
            System.out.print("Novo Nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo Endereço: ");
            String novoEndereco = scanner.nextLine();
            System.out.print("Novo Telefone: ");
            String novoTelefone = scanner.nextLine();
            System.out.print("Novo CPF: ");
            String novoCpf = scanner.nextLine();
            System.out.print("Novo Cargo: ");
            String novoCargo = scanner.nextLine();
            System.out.print("Novo ID: ");
            int novoId = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
    
            caixaAtualizar.setNome(novoNome);
            caixaAtualizar.setEndereco(novoEndereco);
            caixaAtualizar.setTelefone(novoTelefone);
            caixaAtualizar.setCpf(novoCpf);
            caixaAtualizar.setCargo(novoCargo);
            caixaAtualizar.setIdCaixa(novoId);
    
            System.out.println("\nCaixa atualizado com sucesso!");
        } else {
            System.out.println("\nCaixa não encontrado.");
        }
    }
    

    private static void removerCaixa(Scanner scanner) {
        System.out.print("\nRemoção de Caixa\n");
        System.out.print("ID do Caixa: ");
        int idRemocao = scanner.nextInt();
        scanner.nextLine();

        AtendenteCaixa.popCaixa(idRemocao);
        System.out.println("\nCaixa removido com sucesso!");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
    
        do {
            menuPrincipal();
            opcao = scanner.nextInt();
    
            switch (opcao) {
                case 1:
                    menuCadastroClientes();  
                    break;
                case 2:
                    menuCadastroCaixas();
                    break;
                // case 3:
                //     menuVendas();
                //     break;
                // case 4:
                //     menuHistoricoCompras();
                //     break;
                // case 5:
                //     menuHistoricoVendas();
                //     break;
                // case 6:
                //     menuGerenciamentoEstoque();
                //     break;
                // case 7:
                //     menuPedidosCompra();
                //     break;
                case 8:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 8);
    
        scanner.close();
    }
    
}