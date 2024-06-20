import java.util.Date;

public class PedidoCompra {
    
    private int idPedido;
    private Fornecedor fornecedor;
    private Produto produto;
    private Date dataEntrega;
    
    // Construtor
    public PedidoCompra(int idPedido, Fornecedor fornecedor, Produto produto, Date dataEntrega) {
        this.idPedido = idPedido;
        this.fornecedor = fornecedor;
        this.produto = produto;
        this.dataEntrega = dataEntrega;
    }

    // Getters e Setters
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
