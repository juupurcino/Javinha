import java.util.ArrayList;
import java.util.List;

public class Fornecedor {

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private static List<Fornecedor> listaFornecedores = new ArrayList<>();

    // Construtor vazio
    public Fornecedor() {
    }

    // Construtor com todos os campos
    public Fornecedor(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    // Métodos Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static List<Fornecedor> getListaFornecedores() {
        return listaFornecedores;
    }

    public static void adicionarFornecedor(Fornecedor fornecedor) {
        listaFornecedores.add(fornecedor);
    }

    public static Fornecedor consultarFornecedor(String nome) {
        for (Fornecedor fornecedor : listaFornecedores) {
            if (fornecedor.getNome().equalsIgnoreCase(nome)) {
                return fornecedor;
            }
        }
        return null;
    }
}
