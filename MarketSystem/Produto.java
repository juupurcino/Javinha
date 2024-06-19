import java.util.List;

public class Produto {
    
    private String codigo;
    private String nome;
    private String descricao;
    private float precoUn;
    private int qtdEstoque;
    private Fornecedor fornecedorPrincipal;
    private List<Fornecedor> fornecedoresAlternativos;
    
    public Produto(String codigo, String nome, String descricao, float precoUn, int qtdEstoque, 
                   Fornecedor fornecedorPrincipal, List<Fornecedor> fornecedoresAlternativos) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.precoUn = precoUn;
        this.qtdEstoque = qtdEstoque;
        this.fornecedorPrincipal = fornecedorPrincipal;
        this.fornecedoresAlternativos = fornecedoresAlternativos;
    }

    // Getters e setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPrecoUn() {
        return precoUn;
    }

    public void setPrecoUn(float precoUn) {
        this.precoUn = precoUn;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Fornecedor getFornecedorPrincipal() {
        return fornecedorPrincipal;
    }

    public void setFornecedorPrincipal(Fornecedor fornecedorPrincipal) {
        this.fornecedorPrincipal = fornecedorPrincipal;
    }

    public List<Fornecedor> getFornecedoresAlternativos() {
        return fornecedoresAlternativos;
    }

    public void setFornecedoresAlternativos(List<Fornecedor> fornecedoresAlternativos) {
        this.fornecedoresAlternativos = fornecedoresAlternativos;
    }
}
