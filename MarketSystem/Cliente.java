import java.util.Date;

public class Cliente extends Pessoa {
    
    private Date data_nasc;

    // Construtor
    public Cliente(String nome, String endereco, String telefone, String cpf, Date data_nasc) {
        super(nome, endereco, telefone, cpf);
        this.data_nasc = data_nasc;
    }


}
