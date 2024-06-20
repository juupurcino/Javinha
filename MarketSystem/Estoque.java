import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private static List<Produto> produtos;

    public Estoque() {
        produtos = new ArrayList<>();
    }

    public static void cadastrarNovoProduto(Produto produto) {
        produtos.add(produto);
    }

    public Produto consultarEstoque(int codigoConsulta) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigoConsulta) {
                return produto;
            }
        }
        return null;
    }

    public boolean atualizarEstoque(int codigoProduto, int novaQuantidade) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigoProduto) {
                produto.setQtdEstoque(novaQuantidade);
                return true;
            }
        }
        return false;
    }

    public boolean excluirProduto(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
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
