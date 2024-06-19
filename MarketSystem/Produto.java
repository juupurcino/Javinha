import java.util.List;

public class Produto {
    
    private String codigo;
    private String nome;
    private String descricao;
    private float precoUn;
    private int qtdEstoque;
    private Fornecedor fornecedorPrincipal;
    private List<Fornecedor> fornecedoresAlternativos;
}
