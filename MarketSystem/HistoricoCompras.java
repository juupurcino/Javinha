import java.util.ArrayList;
import java.util.List;

public class HistoricoCompras {

    private Cliente cliente;
    private List<Venda> compras;

    public HistoricoCompras(Cliente cliente) {
        this.cliente = cliente;
        this.compras = new ArrayList<>();
    }

    public void adicionarCompra(Venda compra) {
        this.compras.add(compra);
    }

    public List<Venda> getCompras() {
        return compras;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public static HistoricoCompras consultarHistoricoCompras(Cliente cliente, List<HistoricoCompras> historicos) {
        for (HistoricoCompras historico : historicos) {
            if (historico.getCliente().equals(cliente)) {
                return historico;
            }
        }
        return null;
    }
}
