import java.util.ArrayList;
import java.util.List;

public class HistoricoVendas {

    private AtendenteCaixa caixa;
    private List<Venda> vendas;

    public HistoricoVendas(AtendenteCaixa caixa) {
        this.caixa = caixa;
        this.vendas = new ArrayList<>();
    }

    public void adicionarVenda(Venda venda) {
        this.vendas.add(venda);
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public AtendenteCaixa getCaixa() {
        return caixa;
    }

    public static HistoricoVendas consultarHistoricoVendas(AtendenteCaixa caixa, List<HistoricoVendas> historicos) {
        for (HistoricoVendas historico : historicos) {
            if (historico.getCaixa().equals(caixa)) {
                return historico;
            }
        }
        return null;
    }
}