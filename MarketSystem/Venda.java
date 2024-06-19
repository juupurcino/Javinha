import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import FormasPagamento.FormaPagamento;

public class Venda {
    
    private int idVenda;
    private Date data;
    private float valorTotal;
    private FormaPagamento formaPagamento;
    private Cliente cliente;
    private AtendenteCaixa caixa;
    private List<Produto> produtos;
    
    public Venda(int idVenda, Date data, float valorTotal, FormaPagamento formaPagamento, Cliente cliente,
                 AtendenteCaixa caixa, List<Produto> produtos) {
        this.idVenda = idVenda;
        this.data = data;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.cliente = cliente;
        this.caixa = caixa;
        this.produtos = produtos;
    }
    
    public static Venda iniciarNovaVenda(int idVenda, Date data, FormaPagamento formaPagamento, Cliente cliente,
                                         AtendenteCaixa caixa) {
        
        return new Venda(idVenda, data, 0, formaPagamento, cliente, caixa, new ArrayList<>());
                                            
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }
    
    public void calcularTotal() {
        float total = 0;
        for (Produto produto : produtos) {
            total += produto.getPrecoUn(); // Usando getPrecoUn de Produto
        }
        this.valorTotal = total;
    }
    
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public AtendenteCaixa getCaixa() {
        return caixa;
    }

    public void setCaixa(AtendenteCaixa caixa) {
        this.caixa = caixa;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
