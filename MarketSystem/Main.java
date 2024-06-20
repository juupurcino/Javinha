import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import FormasPagamento.*;

public class Main{
    
    private static Venda vendaEmAndamento;
    private static Estoque estoque = new Estoque();
   
    // Menu principal com as opções
    public static void menuPrincipal(){

        System.out.print("\n--------- SISTEMA DE MERCADO -----------\n\n" +
                                "1. Cadastro de Clientes\n" + //
                                "2. Cadastro de Atendentes de Caixa\n" + //
                                "3. Realização de Vendas\n" + //
                                "4. Historico de Compras\n" + //
                                "5. Histórico de Vendas\n" + //
                                "6. Gerenciamento de Estoque\n" + //
                                "7. Pedidos de Compra\n" + //
                                "8. Sair /n"+
                                "Escolha uma opcao: ");
    }

    // Menu Cadastro dos clientes
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

    // Método cadastrar novo cliente
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

    // Método consultar cliente
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

    // Método atualizar cliente
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

    // Método remover cliente
    private static void removerCliente(Scanner scanner) {
        
        System.out.print("\nRemocao de Cliente\n");
        System.out.print("CPF do Cliente: ");
        String cpfRemocao = scanner.nextLine();
        
        Cliente.popCliente(cpfRemocao);
        
        System.out.println("\nCliente removido com sucesso!");
    }

    // Menu Cadastro de caixas
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
            scanner.nextLine();

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

    // Método cadastrar novo caixa
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
        scanner.nextLine();

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

    // Método consultar caixa
    private static void consultarCaixa(Scanner scanner) {
        
        System.out.print("\nConsulta de Caixa\n");
        System.out.print("ID do Caixa: ");
        int idConsulta = scanner.nextInt();
        scanner.nextLine();

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
            System.out.println("\nCaixa nao encontrado.");
        }
    }

    // Método atualizar caixa
    private static void atualizarCaixa(Scanner scanner) {
        
        System.out.print("\nAtualizacao de Caixa\n");
        System.out.print("ID do Caixa: ");
        int idAtualizacao = scanner.nextInt();
        scanner.nextLine(); 
    
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
            scanner.nextLine();
    
            caixaAtualizar.setNome(novoNome);
            caixaAtualizar.setEndereco(novoEndereco);
            caixaAtualizar.setTelefone(novoTelefone);
            caixaAtualizar.setCpf(novoCpf);
            caixaAtualizar.setCargo(novoCargo);
            caixaAtualizar.setIdCaixa(novoId);
    
            System.out.println("\nCaixa atualizado com sucesso!");
        } else {
            System.out.println("\nCaixa nao encontrado");
        }
    }
    
    // Método remover caixa
    private static void removerCaixa(Scanner scanner) {
        
        System.out.print("\nRemocao de Caixa\n");
        System.out.print("ID do Caixa: ");
        int idRemocao = scanner.nextInt();
        scanner.nextLine();

        AtendenteCaixa.popCaixa(idRemocao);
        System.out.println("\nCaixa removido com sucesso!");
    }

    // Menu de vendas
    public static void menuVendas() {
        
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.print("\n--------- MENU OPCOES DE VENDA -----------\n\n" +
                             "1. Iniciar nova venda\n" +
                             "2. Adicionar produtos a venda\n" +
                             "3. Finalizar venda\n" +
                             "4. Voltar ao Menu Principal\n\n" +
                             "Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    iniciarVenda(scanner);
                    break;
                case 2:
                    adicionarProduto(scanner);
                    break;
                case 3:
                    finalizarVenda();
                    break;
                case 4:
                    System.out.println("\nVoltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("\nOpcao invalida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    // Método iniciar venda
    public static void iniciarVenda(Scanner scanner) {
        
        System.out.println("Iniciando nova venda\n");
        System.out.print("ID da venda: ");
        int idVenda = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Data (dd/MM/yyyy): ");
        String dataVendaStr = scanner.nextLine();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataVenda;
        
        try {
            dataVenda = sdf.parse(dataVendaStr);
        } catch (ParseException e) {
            System.out.println("Formato de data invalido. Tente novamente.");
            return;
        }

        System.out.print("Forma de pagamento (PIX, CREDITO, DEBITO, DINHEIRO): ");
        String formaPagamentoStr = scanner.nextLine();
        FormaPagamento formaPagamento;
        
        switch (formaPagamentoStr.toUpperCase()) {
            case "PIX":
                formaPagamento = new Pix();
                break;
            case "CREDITO":
                formaPagamento = new CartaoCredito();
                break;
            case "DEBITO":
                formaPagamento = new CartaoDebito();
                break;
            case "DINHEIRO":
                formaPagamento = new Dinheiro();
                break;
            default:
                System.out.println("Forma de pagamento invalida. Tente novamente.");
                return;
        }

        System.out.print("CPF do Cliente: ");
        String cpfCliente = scanner.nextLine();
        Cliente cliente = Cliente.consultarCliente(cpfCliente);
        
        if (cliente == null) {
            System.out.println("Cliente nao encontrado. Tente novamente.");
            return;
        }

        System.out.print("ID do Atendente Caixa: ");
        int idCaixa = scanner.nextInt();
        scanner.nextLine(); 
        AtendenteCaixa caixa = AtendenteCaixa.consultarCaixa(idCaixa);
        
        if (caixa == null) {
            System.out.println("Atendente de Caixa não encontrado. Tente novamente.");
            return;
        }

        vendaEmAndamento = new Venda(idVenda, dataVenda, 0, formaPagamento, cliente, caixa, new ArrayList<>());
        System.out.println("Venda iniciada com sucesso!");
    }
    
    // Método adicionar produto
    public static void adicionarProduto(Scanner scanner) {
        
        System.out.println("\nAdicionar Produto a Venda\n");

        if (vendaEmAndamento == null) {
            System.out.println("Nenhuma venda iniciada. Por favor, inicie uma nova venda primeiro.");
            return;
        }

        System.out.print("Código do Produto: ");
        int codigoProduto = scanner.nextInt();

        Produto produto = estoque.consultarEstoque(codigoProduto);

        if (produto == null) {
            System.out.println("Produto não encontrado no estoque.");
            return;
        }

        System.out.print("Quantidade desejada: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); 

        if (quantidade <= 0) {
            System.out.println("Quantidade inválida. Tente novamente.");
            return;
        }

        if (quantidade > produto.getQtdEstoque()) {
            System.out.println("Quantidade solicitada superior ao estoque disponível.");
            return;
        }

        estoque.atualizarEstoque(codigoProduto, produto.getQtdEstoque() - quantidade);
        
        for (int i = 0; i < quantidade; i++) {
            vendaEmAndamento.adicionarProduto(produto); 
        }

        System.out.println("Produto adicionado a venda com sucesso!");
        
    }

    // Método finalizar venda
    public static void finalizarVenda() {
       
        if (vendaEmAndamento == null || vendaEmAndamento.getProdutos().isEmpty()) {
            System.out.println("Nenhuma venda em andamento ou nenhum produto adicionado.");
            return;
        }

        vendaEmAndamento.calcularTotal();
    
        System.out.println("\nResumo da Venda:");
        System.out.println("ID da Venda: " + vendaEmAndamento.getIdVenda());
        System.out.println("Data da Venda: " + vendaEmAndamento.getData());
        System.out.println("Valor Total: " + vendaEmAndamento.getValorTotal());

        HistoricoCompras.adicionarCompra(vendaEmAndamento);
        HistoricoVendas.adicionarVenda(vendaEmAndamento);

        vendaEmAndamento = null;
        System.out.println("Venda finalizada com sucesso!");
    }

    // Menu Gerenciamento de estouqe
    public static void menuGerenciamentoEstoque() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.print("\n--------- MENU GERENCIAMENTO DE ESTOQUE -----------\n\n" +
                             "1. Cadastrar novo produto\n" +
                             "2. Consultar estoque de um produto\n" +
                             "3. Atualizar estoque de um produto\n" +
                             "4. Excluir produto\n" +
                             "5. Voltar ao Menu Principal\n\n" +
                             "Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarNovoProduto(scanner);
                    break;
                case 2:
                    consultarEstoqueProduto(scanner);
                    break;
                case 3:
                    atualizarEstoqueProduto(scanner);
                    break;
                case 4:
                    removerProduto(scanner);
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

    // Método cadastrar novo produto
    private static void cadastrarNovoProduto(Scanner scanner) {
        
        System.out.print("\nCadastro de Produto\n");
        System.out.print("Codigo: ");
        int codigo = scanner.nextInt();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descricao: ");
        String descricao = scanner.nextLine();
        System.out.print("Preco unidade: ");
        float precoUn = scanner.nextFloat();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto(codigo, nome, descricao, precoUn, quantidade);
        Estoque.cadastrarNovoProduto(produto);
        System.out.println("\nNovo produto cadastrado com sucesso!");
    }

    // Método consultar estoque
    private static void consultarEstoqueProduto(Scanner scanner) {
        
        System.out.print("\nConsulta de Produto\n");
        System.out.print("Codigo do produto: ");
        int codigoConsulta = scanner.nextInt();
        scanner.nextLine();

        Produto produtoConsultado = estoque.consultarEstoque(codigoConsulta);

        if (produtoConsultado != null) {

            System.out.println("\nCaixa Encontrado:");
            System.out.println("Codigo: " + produtoConsultado.getCodigo());
            System.out.println("Nome: " + produtoConsultado.getNome());
            System.out.println("Descricao: " + produtoConsultado.getDescricao());
            System.out.println("Preco Unitario: " + produtoConsultado.getPrecoUn());
            System.out.println("Quantidade no estoque: " + produtoConsultado.getQtdEstoque());

        } else {
            System.out.println("\nCaixa nao encontrado.");
        }
    }

    // Método atualizar estoque
    private static void atualizarEstoqueProduto(Scanner scanner) {
        
        System.out.print("\nAtualizacao de Produto\n");
        System.out.print("Codigo do produto ");
        int codigoAtualizacao = scanner.nextInt();
        scanner.nextLine(); 
    
        Produto produtoAtualizar = estoque.consultarEstoque(codigoAtualizacao);
    
        if (produtoAtualizar != null) {
            
            System.out.print("Novo Codigo: ");
            int novoCodigo = scanner.nextInt();
            System.out.print("Novo Nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Nova Descricao: ");
            String novaDescricao = scanner.nextLine();
            System.out.print("Novo Preco: ");
            float novoPreco = scanner.nextFloat();
            System.out.print("Nova quantidade: ");
            int novaQtd= scanner.nextInt();
            scanner.nextLine();
    
            produtoAtualizar.setCodigo(novoCodigo);
            produtoAtualizar.setNome(novoNome);
            produtoAtualizar.setDescricao(novaDescricao);
            produtoAtualizar.setPrecoUn(novoPreco);
            produtoAtualizar.setQtdEstoque(novaQtd);
    
            System.out.println("\nProduto atualizado com sucesso!");
        } else {
            System.out.println("\nProduto nao encontrado");
        }
    }
   
    // Método remover produto
    private static void removerProduto(Scanner scanner) {
        
        System.out.print("\nRemocao de Produto\n");
        System.out.print("Codigo do produto: ");
        int codigoRemocao = scanner.nextInt();
        scanner.nextLine();

        estoque.excluirProduto(codigoRemocao);
        System.out.println("\nProsuto removido com sucesso!");
    }

    // Menu pedido de compra
    private static void menuPedidosCompra(){

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.print("\n--------- MENU PEDIDO DE COMPRA -----------\n\n" +
                             "1. Fazer pedido de nova compra\n" +
                             "2. Voltar ao Menu Principal\n\n" +
                             "Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    fazerPedidoCompra(scanner);
                    break;
                case 2:
                    System.out.println("\nVoltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
    
    // Método fazer pedido de compra
    public static void fazerPedidoCompra(Scanner scanner) {

        System.out.print("\nPedido de Compra\n");
        System.out.print("Digite o nome do fornecedor: ");
        String nomeConsulta = scanner.nextLine();

        Fornecedor fornecedorConsultado = Fornecedor.consultarFornecedor(nomeConsulta);

        if (fornecedorConsultado == null) {
            
            System.out.print("\nCadastro de novo Fornecedor\n");
            System.out.print("Nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Endereco: ");
            String novoEndereco = scanner.nextLine();
            System.out.print("Telefone: ");
            String novoTelefone = scanner.nextLine();
            System.out.print("Email: ");
            String novoEmail = scanner.nextLine();

            Fornecedor novoFornecedor = new Fornecedor(novoNome, novoEndereco, novoTelefone, novoEmail);
            Fornecedor.adicionarFornecedor(novoFornecedor);
            fornecedorConsultado = novoFornecedor;
            System.out.println("Novo fornecedor cadastrado com sucesso!");
        }

        // Pedido de compra
        System.out.print("ID do pedido: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Codigo do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Nome do Produto: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("Descricao do Produto: ");
        String descricaoProduto = scanner.nextLine();
        System.out.print("Preco unidade: ");
        float precoUnidade = scanner.nextFloat();
        System.out.print("Quantidade do Produto: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Data de entrega (dd/MM/yyyy): ");
        String dataEntregaStr = scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataEntrega = null;

        try {
            dataEntrega = sdf.parse(dataEntregaStr);
        } catch (ParseException e) {
            System.out.println("\nErro ao converter data. Formato invalido. Tente novamente.");
            return;
        }

        Produto produto = new Produto(codigo, nomeProduto, descricaoProduto, precoUnidade, quantidade);
        PedidoCompra pedido = new PedidoCompra(idPedido, fornecedorConsultado, produto, dataEntrega);

        System.out.println("\nPedido de compra realizado com sucesso!");
        System.out.println("Fornecedor: " + fornecedorConsultado.getNome());
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Data de Entrega: " + sdf.format(dataEntrega));
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
                case 3:
                    menuVendas();
                    break;
                // case 4:
                //     menuHistoricoCompras();
                //     break;
                // case 5:
                //     menuHistoricoVendas();
                //     break;
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
    
}