import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Pessoa {
    
    private String nome;
    private String endereco;
    private String telefone;
    private String cpf;
    private static List<Pessoa> listaClientes = new ArrayList<>();
    private static List<Pessoa> listaFuncionarios = new ArrayList<>();


    // Construtor
    public Pessoa(String nome, String endereco, String telefone, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public static void addCliente(String nome, String endereco, String telefone, String cpf, Date data_nasc) {
        Cliente novoCliente = new Cliente(nome, endereco, telefone, cpf, data_nasc);
        listaClientes.add(novoCliente);
    }
    
    public static void addCaixa(String nome, String endereco, String telefone, String cpf, Date dataAdmissao, String cargo, int idCaixa) {
        AtendenteCaixa novoCaixa = new AtendenteCaixa(nome, endereco, telefone, cpf, dataAdmissao, cargo, idCaixa);
        listaFuncionarios.add(novoCaixa); // Aqui, corrigimos para adicionar à lista de funcionários

    }
}
