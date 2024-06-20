import java.util.List;

public class Produto {
    
    private int codigo;
    private String nome;
    private String descricao;
    private float precoUn;
    private int qtdEstoque;

    
    public Produto(int codigo, String nome, String descricao, float precoUn, int qtdEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.precoUn = precoUn;
        this.qtdEstoque = qtdEstoque;
    }

    // Getters e setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

}
