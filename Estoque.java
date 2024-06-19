import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrarNovoProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public Produto consultarEstoque(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }

    public boolean atualizarEstoque(String codigo, int novaQuantidade) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                produto.setQtdEstoque(novaQuantidade);
                return true;
            }
        }
        return false;
    }

    public boolean excluirProduto(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                produtos.remove(produto);
                return true;
            }
        }
        return false;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
