import java.util.Date;

class AtendenteCaixa extends Pessoa {
    
    private String cargo;
    private Date dataAdmissao;
    private int idCaixa;
    
    public AtendenteCaixa(String nome, String endereco, String telefone, String cpf, Date dataAdmissao, String cargo, int idCaixa) {
        super(nome, endereco, telefone, cpf);
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
        this.idCaixa = idCaixa;
    }
}
