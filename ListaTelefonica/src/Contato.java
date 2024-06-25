import java.util.LinkedList;
import java.util.List;

public class Contato {

    private int id;
    private String nome;
    private int telefone;
    private static List<Contato> listaContatos = new LinkedList<>();

    public Contato(int id, String nome, int telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public static void addContato(int id, String nome, int telefone) {
        Contato novoContato = new Contato(id, nome, telefone);
        listaContatos.add(novoContato);
    }

    public static void removerContatoPorNome(String nome) {
        for (int i = 0; i < listaContatos.size(); i++) {
            if (listaContatos.get(i).getNome().equals(nome)) {
                listaContatos.remove(i);
                break;
            }
        }
    }

    public static void removerContatoPorTelefone(int telefone) {    
        
        for (int i = 0; i < listaContatos.size(); i++) {
            if (listaContatos.get(i).getTelefone() == telefone) {
                listaContatos.remove(i);
                break;
            }
        }
    }

    public static Contato consultarContatoPorNome(String nome) {
        for (Contato contato : listaContatos) {
            if (contato.getNome().equals(nome)) {
                return contato;
            }
        }
        return null;
    }

    public static Contato consultarContatoPorTelefone(int telefone) {
        for (Contato contato : listaContatos) {
            if (contato.getTelefone() == telefone) {
                return contato;
            }
        }
        return null;
    }

    public static void listarContatos() {
        for (Contato contato : listaContatos) {
            System.out.println("ID: " + contato.getId() +
                               "\nNome: " + contato.getNome() +
                               "\nTelefone: " + contato.getTelefone());
        }
    }

    public static void selectionSortNome() {
        Contato[] arrayContatos = listaContatos.toArray(new Contato[0]);
        
        for (int i = 0; i < arrayContatos.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < arrayContatos.length; j++) {
                if (arrayContatos[j].getNome().compareTo(arrayContatos[min_index].getNome()) < 0) {
                    min_index = j;
                }
            }
            if (i != min_index) {
                Contato temp = arrayContatos[i];
                arrayContatos[i] = arrayContatos[min_index];
                arrayContatos[min_index] = temp;
            }
        }
        
        // Atualiza a lista de contatos com o array ordenado
        listaContatos.clear();
        for (Contato contato : arrayContatos) {
            listaContatos.add(contato);
        }
    }

    public static void selectionSortPorNumero() {
        Contato[] arrayContatos = listaContatos.toArray(new Contato[0]);
        
        for (int i = 0; i < arrayContatos.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < arrayContatos.length; j++) {
                if (arrayContatos[j].getTelefone() < arrayContatos[min_index].getTelefone()) {
                    min_index = j;
                }
            }
            if (i != min_index) {
                Contato temp = arrayContatos[i];
                arrayContatos[i] = arrayContatos[min_index];
                arrayContatos[min_index] = temp;
            }
        }
        
        // Atualiza a lista de contatos com o array ordenado
        listaContatos.clear();
        for (Contato contato : arrayContatos) {
            listaContatos.add(contato);
        }
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

}
