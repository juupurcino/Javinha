import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AtendenteCaixa extends Pessoa {
    
    private String cargo;
    private Date dataAdmissao;
    private int idCaixa;
    private static List<AtendenteCaixa> listaFuncionarios = new ArrayList<>();

    public AtendenteCaixa(String nome, String endereco, String telefone, String cpf, Date dataAdmissao, String cargo, int idCaixa) {
        super(nome, endereco, telefone, cpf);
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
        this.idCaixa = idCaixa;
    }

    // Getters e setters
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }

    public static List<AtendenteCaixa> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public static void addCaixa(String nome, String endereco, String telefone, String cpf, Date dataAdmissao, String cargo, int idCaixa) {
        AtendenteCaixa novoCaixa = new AtendenteCaixa(nome, endereco, telefone, cpf, dataAdmissao, cargo, idCaixa);
        listaFuncionarios.add(novoCaixa); 
    }

    public static void popCaixa(int idCaixa) {
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            if (listaFuncionarios.get(i).getIdCaixa() == idCaixa) {
                listaFuncionarios.remove(i);
                break;
            }
        }
    }

    public static void atualizarCaixa(String nome, String endereco, String telefone, String cpf, Date dataAdmissao, String cargo, int idCaixa) {
        for (AtendenteCaixa caixa : listaFuncionarios) {
            if (caixa.getIdCaixa() == idCaixa) {
                caixa.setNome(nome);
                caixa.setEndereco(endereco);
                caixa.setTelefone(telefone);
                caixa.setDataAdmissao(dataAdmissao);
                caixa.setCargo(cargo);
                caixa.setIdCaixa(idCaixa);
                break;
            }
        }
    }

    public static AtendenteCaixa consultarCaixa(int idCaixa) {
        for (AtendenteCaixa caixa : listaFuncionarios) {
            if (caixa.getIdCaixa() == idCaixa) {
                return caixa;
            }
        }
        return null;
    }
}
