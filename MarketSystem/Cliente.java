import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends Pessoa {
    
    private Date dataNasc;
    private static List<Cliente> listaClientes = new ArrayList<>();

    public Cliente(String nome, String endereco, String telefone, String cpf, Date dataNasc) {
        super(nome, endereco, telefone, cpf);
        this.dataNasc = dataNasc;
    }

    // Getters e setters
    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public static List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public static void addCliente(String nome, String endereco, String telefone, String cpf, Date dataNasc) {
        
        Cliente novoCliente = new Cliente(nome, endereco, telefone, cpf, dataNasc);
        listaClientes.add(novoCliente);
    }

    public static void popCliente(String cpf) {
        
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getCpf().equals(cpf)) {
                listaClientes.remove(i);
                break;
            }
        }
    }

    public static void atualizarCliente(String nome, String endereco, String telefone, String cpf, Date dataNasc){

        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                cliente.setNome(nome);
                cliente.setEndereco(endereco);
                cliente.setTelefone(telefone);
                cliente.setDataNasc(dataNasc);
                break;
            }
        }
    }

    public static Cliente consultarCliente(String cpf) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
}
